package com.excel.api.demoproject.controller;

import com.excel.api.demoproject.entity.Product;
import com.excel.api.demoproject.helper.ExcelHelper;
import com.excel.api.demoproject.service.Excelservice;
import org.hibernate.id.uuid.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ExcelController {
    @Autowired
    Excelservice excelservice;
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        if(ExcelHelper.checkexcelformat(multipartFile)){
            excelservice.save(multipartFile);
            return ResponseEntity.ok(Map.of("message","file uploaded"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("file not uploaded check file format");
    }
    @GetMapping("/get")
    public List<Product> getall(){
        return excelservice.getallproducts();
    }
}
