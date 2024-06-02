package com.example.ProductCatelogServiceProxy.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
