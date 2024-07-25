package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.Size;
import com.rockfly.repositories.SizeRepository;
import com.rockfly.services.SizeService;

@Service
public class SizeServiceImpl implements SizeService {

	@Autowired
	private SizeRepository sizeRepository;
	
	@Override
	public void saveSize(Size size) {
		sizeRepository.save(size);
		
	}

	@Override
	public List<Size> getAllSize() {
		
		return sizeRepository.findAll();
	}

}
