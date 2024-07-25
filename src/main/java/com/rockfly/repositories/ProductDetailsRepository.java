package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockfly.models.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long>{

	//List<MainStock> findByproductType(String productType);
}
