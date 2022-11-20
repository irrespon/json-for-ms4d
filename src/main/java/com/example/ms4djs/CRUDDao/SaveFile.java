package com.example.ms4djs.CRUDDao;

import org.springframework.web.multipart.MultipartFile;


public interface SaveFile {
    boolean save(MultipartFile file);
}
