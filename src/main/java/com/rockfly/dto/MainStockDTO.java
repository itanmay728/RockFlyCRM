package com.rockfly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainStockDTO {

	private Long id;
	
	private String productType;

	private String styleNumber;

	private String itemHsnSac;

	private String color;

	private String productSpecification;

	// Size
	private String size;

	// Quantity
	private String quantity;
	
	
}
