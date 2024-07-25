package com.rockfly.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

	private String shopName;
	
	private Long openingBalance;
	
	private LocalDate asOfDate;

}
