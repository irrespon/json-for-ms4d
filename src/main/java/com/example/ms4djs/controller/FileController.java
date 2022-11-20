package com.example.ms4djs.controller;

import com.example.ms4djs.service.ServiceCRUDFile;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//загрузка файла из вэб
@RestController
public class FileController {

    @Autowired
    ServiceCRUDFile serviceCRUDFile;

    @RequestMapping(value = "/upload", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {

        String pathfile = file.getOriginalFilename();
        if (serviceCRUDFile.save(file))
            return ResponseEntity.ok(pathfile);
        else return (ResponseEntity<?>) ResponseEntity.badRequest();
    }

    @PostMapping("/loadFile")
    public ResponseEntity<?> loadFile(@RequestBody String nameFile) {
        //определение типа файла, выбор соответсвующего метода
        switch (Files.getFileExtension(nameFile)) {
            case "json":
                serviceCRUDFile.loadJSON(nameFile);
                break;
            case "csv":
                serviceCRUDFile.loadString(nameFile);
                break;
        }
        return ResponseEntity.ok(nameFile);
    }
}
