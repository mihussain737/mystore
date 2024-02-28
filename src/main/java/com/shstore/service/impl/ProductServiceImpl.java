package com.shstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shstore.dto.ProductDto;
import com.shstore.entity.Product;
import com.shstore.repository.ProductRepository;
import com.shstore.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto addPorduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto,Product.class);
		Product savedProduct = productRepository.save(product);
		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public List<ProductDto> searchProduct(String keyword) {
		List<Product> products = productRepository.findByProductNameContainingIgnoreCase(keyword);
		return products.stream().map(product-> modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
	}
}
