package com.example.ProductCatelogServiceProxy.Srevices;

import com.example.ProductCatelogServiceProxy.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageProductService implements iProductService {

    @Override
    public List<Product> GetAllProduct() {
        return List.of();
    }

    @Override
    public Product GetProductById(Long productId) {
        return null;
    }

    @Override
    public Product AddProduct(Product product) {
        return null;
    }

    @Override
    public Product UpdateProduct(Long id, Product product) {
        return null;
    }
}
