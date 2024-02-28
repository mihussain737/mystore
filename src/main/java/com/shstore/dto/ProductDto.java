package com.shstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	
	private Long productId;
	private String productName;
	private String productBrandName;
	private int buyingPrice;
	private int wholesalePrice;
	private String wholesalePerPc;
	private int customerPrice;
	private String notes;
}
