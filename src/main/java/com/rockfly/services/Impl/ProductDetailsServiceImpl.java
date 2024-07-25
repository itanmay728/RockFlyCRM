package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.ProductDetails;
import com.rockfly.models.RackNumber;
import com.rockfly.repositories.ProductDetailsRepository;
import com.rockfly.repositories.RackNumberRepository;
import com.rockfly.services.ProductDetailsService;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService{

	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	
	@Autowired
	private RackNumberRepository rackNumberRepository;
	
	@Override
	public void saveItem(ProductDetails mainStock) {
			
		productDetailsRepository.save(mainStock);
		
	}	
	
	@Override
	public List<ProductDetails> getMainStockSortByProductType(String productType) {
		
		return productDetailsRepository.findAll();
	}

	@Override
	public ProductDetails getMainStockProductDetailById(Long id) {
		ProductDetails mainStockProductDetail = productDetailsRepository.findById(id).get();
		return mainStockProductDetail;
	}


//	@Override
//	public void setRackNumber(Long id, RackNumber rackNumber) {
//		ProductDetails mainStock = getMainStockProductDetailById(id);
//		
//		RackNumber rackNumber2  = rackNumberRepository.findById(rackNumber.getId()).get();
//		
//		List<RackNumber> rack = mainStock.getRackNumber();
//		rack.add(rackNumber2);
//		
//		List<ProductDetails> mainStocks = rackNumber2.getMainStock();
//		mainStocks.add(mainStock);
//		productDetailsRepository.save(mainStock);
//	}


//	@Override
//	public List<RackNumber> getRackNumberByMainStockId(Long id) {
//		ProductDetails mainStock = getMainStockProductDetailById(id);
//		
//		List<RackNumber> rackNumbers = mainStock.getRackNumber();		
//		return rackNumbers;
//	}

	

}
