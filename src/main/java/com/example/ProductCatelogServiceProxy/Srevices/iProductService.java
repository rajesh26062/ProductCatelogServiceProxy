package com.example.ProductCatelogServiceProxy.Srevices;

import com.example.ProductCatelogServiceProxy.DTO.ProductDTO;
import com.example.ProductCatelogServiceProxy.Models.Product;

import java.util.List;

public interface iProductService {
    List<Product> GetAllProduct();

    Product GetProductById(Long productId);

    Product AddProduct(Product product);

    Product UpdateProduct(Long id,Product product);

}