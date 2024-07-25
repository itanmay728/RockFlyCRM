package com.rockfly.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rockfly.dto.CustomerDTO;
import com.rockfly.models.Customers;
import com.rockfly.repositories.CustomersRepository;
import com.rockfly.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomersRepository customersRepository;

	@Override
	public Customers save(Customers customers) {

		return customersRepository.save(customers);

	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customers> customers = customersRepository.findAll();
		return customers.stream()
				.map(this::fromEntityToDTO)
				.collect(Collectors.toList());
	}
	
//	@SuppressWarnings("unchecked")
//	public Page<CustomerDTO> getAllCustomers(int offset, int pageSize, String field) {
//		Page<Customers> customers = customersRepository.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field));
//		return (Page<CustomerDTO>) customers.stream()
//				.map(this::fromEntityToDTO)
//				.collect(Collectors.toList());
//	}
	
	@Override
	public Page<CustomerDTO> getAllCustomers(int offset, int pageSize, String field) {
	    Page<Customers> customers = customersRepository.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field));
	    List<CustomerDTO> customerDTOs = customers.stream()
	            .map(this::fromEntityToDTO)
	            .collect(Collectors.toList());
	    return new PageImpl<>(customerDTOs, PageRequest.of(offset, pageSize), customers.getTotalElements());
	}

	@Override
	public CustomerDTO fromEntityToDTO(Customers customers) {
		return new CustomerDTO(customers.getShopName(), customers.getOpeningBalance(), customers.getAsOfDate());
	}
}
