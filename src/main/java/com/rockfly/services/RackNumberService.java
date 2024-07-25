package com.rockfly.services;

import java.util.List;

import com.rockfly.models.RackNumber;

public interface RackNumberService {

	public void saveRack(RackNumber rackNumber);
	public List<RackNumber> getAllRackNumbers();
	
}
