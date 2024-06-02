//package com.example.ProductCatelogServiceProxy;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//
//@SpringBootApplication
//
//@EntityScan(basePackages = "com.example.ProductCatelogServiceProxy.Models")
//public class ProductCatelogServiceProxyApplication {
//	public static void main(String[] args) {
//		SpringApplication.run(ProductCatelogServiceProxyApplication.class, args);
//	}
//
//}
package com.example.ProductCatelogServiceProxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.ProductCatelogServiceProxy.Models")
public class ProductCatelogServiceProxyApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductCatelogServiceProxyApplication.class, args);
	}
}
