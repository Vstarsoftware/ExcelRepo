package com.excel.api.demoproject.repository;

import com.excel.api.demoproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Filerepository extends JpaRepository<Product,Integer> {
}
