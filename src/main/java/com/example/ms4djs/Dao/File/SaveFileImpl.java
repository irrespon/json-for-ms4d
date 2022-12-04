package com.example.ms4djs.Dao.File;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//формирвоание файла из файла вэб
@Repository
public class SaveFileImpl implements SaveFile {
    @Override
    public boolean save(MultipartFile file){
        boolean state = false;
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedOutputStream stream = null;
        try {
            stream = new BufferedOutputStream(new FileOutputStream(file.getOriginalFilename()));
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
            state = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return state;
    }
}
