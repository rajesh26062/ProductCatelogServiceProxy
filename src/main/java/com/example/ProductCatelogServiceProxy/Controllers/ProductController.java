package com.example.ProductCatelogServiceProxy.Controllers;
import com.example.ProductCatelogServiceProxy.Clients.FakeStore.Dtos.FakeStoreProductDto;
import com.example.ProductCatelogServiceProxy.DTO.ProductDTO;
import com.example.ProductCatelogServiceProxy.Models.Category;
import com.example.ProductCatelogServiceProxy.Models.Product;
import com.example.ProductCatelogServiceProxy.Srevices.iProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

//    @GetMapping("{id}")
//    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
//        try {
//          if (productId < 1 ){
//              throw new IllegalArgumentException("Kuch tho phata he");}
//            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//            headers.add("called by somaone", "pagal ho kya tum");
//            Product product = productService.GetProductById(productId);
//            return new ResponseEntity<>(product, headers, HttpStatus.OK);
//        }
//        catch (Exception exception) {
//            throw exception;
//        }
//    }

    @ExceptionHandler(IllegalArgumentException.class)
private ResponseEntity<String> handleException(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    iProductService productService;

    public ProductController(iProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.GetAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long productId) {
        return productService.GetProductById(productId);
    }

    @PostMapping("")
    public Product addProduct(@RequestBody ProductDTO productDto) {
        Product product = getProductFromProductDTO(productDto);
        return productService.AddProduct(product);
    }

    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable Long id ,@RequestBody ProductDTO productDto) {
        Product product = getProductFromProductDTO(productDto);
        return productService.UpdateProduct(id, product);
    }
    private Product getProductFromProductDTO(ProductDTO productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setTitle(productDto.getTitle());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        return product;
    }

}
