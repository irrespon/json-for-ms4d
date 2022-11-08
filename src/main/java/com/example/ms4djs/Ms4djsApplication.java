package com.example.ms4djs;

import com.example.ms4djs.controller.MainController;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.io.IOException;

@SpringBootApplication
public class Ms4djsApplication {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse("1280KB"));
        factory.setMaxRequestSize(DataSize.parse("1280KB"));
        return factory.createMultipartConfig();
    }
    public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(Ms4djsApplication.class, args);
    }

}
