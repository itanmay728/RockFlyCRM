package com.rockfly.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.DocumentType;
import com.rockfly.repositories.DocumentTypeRepository;
import com.rockfly.services.DocumentTypeService;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService{

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Override
	public DocumentType save(DocumentType document) {
		return documentTypeRepository.save(document);
	}
	

}
