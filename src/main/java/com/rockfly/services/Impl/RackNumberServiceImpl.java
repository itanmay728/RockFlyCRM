package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.RackNumber;
import com.rockfly.repositories.RackNumberRepository;
import com.rockfly.services.RackNumberService;

@Service
public class RackNumberServiceImpl implements RackNumberService{

	@Autowired
	private RackNumberRepository rackNumberRepositories;
	
	@Override
	public List<RackNumber> getAllRackNumbers() {
		// TODO Auto-generated method stub
		return rackNumberRepositories.findAll();
	}

	@Override
	public void saveRack(RackNumber rackNumber) {
		rackNumberRepositories.save(rackNumber);
		
	}

}
