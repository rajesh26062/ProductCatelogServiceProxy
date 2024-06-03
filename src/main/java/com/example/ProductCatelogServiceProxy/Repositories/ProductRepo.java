package com.example.ProductCatelogServiceProxy.Repositories;

import com.example.ProductCatelogServiceProxy.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
