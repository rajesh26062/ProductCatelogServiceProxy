package com.example.ProductCatelogServiceProxy.Srevices;
import com.example.ProductCatelogServiceProxy.Clients.FakeStore.Client.FakeStoreApiClient;
import com.example.ProductCatelogServiceProxy.Clients.FakeStore.Dtos.FakeStoreProductDto;
import com.example.ProductCatelogServiceProxy.DTO.ProductDTO;
import com.example.ProductCatelogServiceProxy.Models.Category;
import com.example.ProductCatelogServiceProxy.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements iProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreApiClient fakeStoreApiClient;
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreApiClient fakeStoreApiClient){
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreApiClient = fakeStoreApiClient;
    }

    @Override
    public List<Product> GetAllProduct() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto[] fakeStoreProductDtos =  restTemplate.getForEntity("https://fakestoreapi.com/products",  FakeStoreProductDto[].class).getBody();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(getProductFromProductDTO(fakeStoreProductDto));
        }
        return products;
    }

//    @Override
//    public Product GetProductById(@PathVariable Long productId) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,productId).getBody();
//        return getProductFromProductDTO(fakeStoreProductDto);
//    }
   @Override
    public Product GetProductById(Long productId) {
        return getProductFromProductDTO(fakeStoreApiClient.GetProductById(productId));
    }

//    @Override
//    public Product AddProduct(Product product) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =  restTemplate.postForEntity("https://fakestoreapi.com/products", product, FakeStoreProductDto.class);
//        return getProductFromProductDTO(fakeStoreProductDtoResponseEntity.getBody());
//    }
    @Override
    public Product AddProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto = getFakeStoreProductDtoFromProduct(product);
        FakeStoreProductDto responsefakeStoreProductDto = fakeStoreApiClient.AddProduct(fakeStoreProductDto);
        return getProductFromProductDTO(responsefakeStoreProductDto);
    }

    @Override
    public Product UpdateProduct(Long id ,Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //FakeStoreProductDto fakeStoreProductDto = restTemplate.patchForObject("https://fakestoreapi.com/products/{id}", product, FakeStoreProductDto.class,id);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(HttpMethod.PATCH,"https://fakestoreapi.com/products/{id}",product,FakeStoreProductDto.class,id);
        return getProductFromProductDTO(fakeStoreProductDtoResponseEntity.getBody());
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private Product getProductFromProductDTO(FakeStoreProductDto productDto){
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

    private FakeStoreProductDto getFakeStoreProductDtoFromProduct(Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setImageUrl(product.getImageUrl());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        return fakeStoreProductDto;
    }
}
