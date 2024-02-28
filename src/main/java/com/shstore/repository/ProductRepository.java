package com.shstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shstore.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByProductNameContainingIgnoreCase(String keyword);
}
