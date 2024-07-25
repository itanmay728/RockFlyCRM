package com.rockfly.services;

import java.util.List;
import com.rockfly.models.ProductDetails;
import com.rockfly.models.RackNumber;

public interface ProductDetailsService {

	public void saveItem(ProductDetails mainStock);

	// public List<MainStockDTO> getMainStockSortByProductType(String productType);

	public List<ProductDetails> getMainStockSortByProductType(String productType);

	public ProductDetails getMainStockProductDetailById(Long id);

//	public void setRackNumber(Long id, RackNumber rackNumber);
//
//	public List<RackNumber> getRackNumberByMainStockId(Long id);

}
