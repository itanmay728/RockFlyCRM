package com.rockfly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarcodeDTO {

	
	private String styleNumber;
	
	private String color;
	
	private String size;
	
	private Long mrp;
	
}
