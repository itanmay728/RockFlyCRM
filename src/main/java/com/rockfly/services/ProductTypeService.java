package com.rockfly.services;

import java.util.List;

import com.rockfly.dto.BarcodeDTO;
import com.rockfly.models.ProductDetails;
import com.rockfly.models.ProductType;
import com.rockfly.models.Size;

import lombok.val;

public interface ProductTypeService {
	
	public void addProductType(ProductType productType);
	
	public List<ProductType> getAllProductType();

	//BarcodeDTO fromEntityToDTO(MainStock mainStock, Price price);

	//List<BarcodeDTO> getProdutsForBarcode();
	
	public void manageSize(Size size , ProductType productType);
}
