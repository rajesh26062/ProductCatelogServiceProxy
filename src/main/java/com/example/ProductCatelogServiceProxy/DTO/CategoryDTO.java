package com.example.ProductCatelogServiceProxy.DTO;

import com.example.ProductCatelogServiceProxy.Models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter@Setter
public class CategoryDTO {
    private String name;
    private String description;
    private List<Product> products;
}
