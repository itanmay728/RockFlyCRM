package com.rockfly.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rockfly.dto.CustomerDTO;
import com.rockfly.models.Customers;

public interface CustomerService {

	Customers save(Customers customers);

	List<CustomerDTO> getAllCustomers();

	Page<CustomerDTO> getAllCustomers(int offset, int pageSize, String field);

	CustomerDTO fromEntityToDTO(Customers customers);

}
