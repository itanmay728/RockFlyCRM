package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rockfly.models.ProductSpecifications;

public interface ProductSpecificationsRepository extends JpaRepository<ProductSpecifications, Long> {

}
