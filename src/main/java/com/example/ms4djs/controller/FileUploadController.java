package com.example.ms4djs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

//@RestController
@Controller
public class FileUploadController {
    @Autowired
    MainController mainController;

    @RequestMapping(value = "/upload", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
        String pathfile = "json-uploaded";
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedOutputStream stream =
                null;
        try {
            stream = new BufferedOutputStream(new FileOutputStream(new File(pathfile)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            stream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mainController.test(pathfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
