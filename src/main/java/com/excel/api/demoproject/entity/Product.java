package com.excel.api.demoproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private Integer id;
    @Column(name="productname")
    private String Productname;
    @Column(name="productdesc")
    private String Productdesc;
    @Column(name="productPrice")
    private Integer Productprice;

    public Product() {
    }

    public Product(Integer id, String productname, String productdesc, String productprice) {
        this.id = id;
        Productname = productname;
        Productdesc = productdesc;
        Productprice = Integer.valueOf(productprice);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public String getProductdesc() {
        return Productdesc;
    }

    public void setProductdesc(String productdesc) {
        Productdesc = productdesc;
    }

    public Integer getProductprice(int numericCellValue) {
        return Productprice;
    }

    public void setProductprice(String productprice) {
        Productprice = Integer.valueOf(productprice);
    }
}
