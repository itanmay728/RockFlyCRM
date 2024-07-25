package com.rockfly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rockfly.models.DocumentType;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long>{

}
