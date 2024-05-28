package com.example.ProductCatelogServiceProxy.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
    private RatingDTO ratingDTO;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + imageUrl + '\'' +
              //  ", category='" + category + '\'' +
                ", ratingDTO=" + ratingDTO +
                '}';
    }
}
