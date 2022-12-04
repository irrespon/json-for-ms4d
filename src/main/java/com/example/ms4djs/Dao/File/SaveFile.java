package com.example.ms4djs.Dao.File;

import org.springframework.web.multipart.MultipartFile;


public interface SaveFile {
    boolean save(MultipartFile file);
}
