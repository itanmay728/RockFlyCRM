package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockfly.models.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long>{

}
