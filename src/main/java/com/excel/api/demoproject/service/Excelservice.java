package com.excel.api.demoproject.service;

import com.excel.api.demoproject.entity.Product;
import com.excel.api.demoproject.helper.ExcelHelper;
import com.excel.api.demoproject.repository.Filerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class Excelservice {
    @Autowired
    Filerepository filerepository;
    public void save(MultipartFile multipartFile) throws IOException {
        List<Product> ls= ExcelHelper.convertexceltolist(multipartFile.getInputStream());
        filerepository.saveAll(ls);
    }
    public List<Product> getallproducts(){
        return filerepository.findAll();
    }

}
