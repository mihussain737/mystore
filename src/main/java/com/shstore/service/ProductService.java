package com.shstore.service;

import java.util.List;

import com.shstore.dto.ProductDto;

public interface ProductService {

	ProductDto addPorduct(ProductDto productDto);

	List<ProductDto> searchProduct(String keyword);
}
