package com.excel.api.demoproject.helper;

import com.excel.api.demoproject.entity.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static boolean checkexcelformat(MultipartFile multipartFile){
        String content=multipartFile.getContentType();
return content.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }
    public static List<Product> convertexceltolist(InputStream inputStream){
        List<Product> ls=new ArrayList<>();
        try{
        XSSFWorkbook xssfWorkbook= new XSSFWorkbook();
            XSSFSheet xssfSheet=xssfWorkbook.getSheet("data");
            Iterator<Row> it=xssfSheet.iterator();
            int rownum=0;
            while(it.hasNext()){
                if(rownum==0){
                    rownum++;
                    continue;
                }
                Row row=it.next();
                Iterator<Cell> cellIterator=row.iterator();
                int cid=0;
                Product p=new Product();
                while (cellIterator.hasNext()){
                    Cell cell= cellIterator.next();
                    switch (cid){
                        case 0:p.setId((int)cell.getNumericCellValue());
                        case 1:p.setProductname(cell.getStringCellValue());
                        case 2:p.setProductdesc(cell.getStringCellValue());
                        case 3:p.getProductprice((int)cell.getNumericCellValue());
                        default:break;

                    }
                    cid++;
                }
                ls.add(p);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ls;
    }
}
