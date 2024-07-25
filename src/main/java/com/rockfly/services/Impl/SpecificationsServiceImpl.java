package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.ProductSpecifications;
import com.rockfly.repositories.ProductSpecificationsRepository;
import com.rockfly.services.SpecificationsService;

@Service
public class SpecificationsServiceImpl implements SpecificationsService {

	@Autowired
	private ProductSpecificationsRepository productSpecificationsRepository;
	
	@Override
	public void saveSpecifications(ProductSpecifications productSpecifications) {
		productSpecificationsRepository.save(productSpecifications);
		
	}

	@Override
	public List<ProductSpecifications> getAllSpecifications() {
		
		return productSpecificationsRepository.findAll();
	}

}
