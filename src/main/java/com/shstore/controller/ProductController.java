package com.shstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shstore.dto.ProductDto;
import com.shstore.service.ProductService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("sh-store/api/products")
@AllArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//http://localhost:8080/sh-store/api/products
	@PostMapping
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
		ProductDto product=productService.addPorduct(productDto);
		return new ResponseEntity(product,HttpStatus.CREATED);
	}
	//http://localhost:8080/sh-store/api/products/keyword
	
	@GetMapping("/{keyword}")
	public ResponseEntity<ProductDto>searchProduct(@PathVariable String keyword){
		List<ProductDto>products=productService.searchProduct(keyword);
		return new ResponseEntity(products,HttpStatus.OK);
	}
	

}
