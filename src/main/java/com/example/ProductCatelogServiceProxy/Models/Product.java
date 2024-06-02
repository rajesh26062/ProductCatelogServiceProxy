package com.example.ProductCatelogServiceProxy.Models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
}
