package com.example.ProductCatelogServiceProxy.Clients.FakeStore.Dtos;

import com.example.ProductCatelogServiceProxy.DTO.RatingDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
    private FakeStoreRatingDto FratingDTO;


}
