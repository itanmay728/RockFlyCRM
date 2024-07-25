package com.rockfly.services;

import java.util.List;

import com.rockfly.models.Size;

public interface SizeService {

	public void saveSize(Size size);
	
	public List<Size> getAllSize();
}
