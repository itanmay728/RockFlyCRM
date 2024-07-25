package com.rockfly.services;

import java.util.List;

import com.rockfly.models.ProductSpecifications;

public interface SpecificationsService {

	public void saveSpecifications(ProductSpecifications productSpecifications);
	
	public List<ProductSpecifications> getAllSpecifications();
}
