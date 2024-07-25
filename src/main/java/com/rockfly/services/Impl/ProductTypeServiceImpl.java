package com.rockfly.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rockfly.models.ProductType;
import com.rockfly.models.Size;
import com.rockfly.repositories.ProductDetailsRepository;
import com.rockfly.repositories.ProductTypeRepository;
import com.rockfly.repositories.SizeRepository;
import com.rockfly.services.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	
	@Autowired
	private SizeRepository sizeRepository;
	
//	@Autowired
//	private PriRepo
	
	@Override
	public void addProductType(ProductType productType) {
		
		productTypeRepository.save(productType);
	}

	@Override
	public List<ProductType> getAllProductType() {
		
		return productTypeRepository.findAll();
	}

	@Override
	public void manageSize(Size size, ProductType productType) {
		
		  Size size2 = sizeRepository.findById(size.getSizeId()).get();
		  
		  
		  ProductType productType2 = productTypeRepository.findById(productType.getProductTypeId()).get();
		
		  List<ProductType> pt =  size2.getProductType();
		  pt.add(productType2);
		  
		  List<Size> s = productType2.getSize();
		  s.add(size2);
		  
		  sizeRepository.save(size2);
		  productTypeRepository.save(productType2);
		  
	}
	
	
	//to display product variation on the barcode page, so barcode can be generated
//	@Override
//	public List<BarcodeDTO> getProdutsForBarcode() {
//		List<MainStock> mainStock = mainStockRepository.findAll();
//		return mainStock.stream()
//				.map(this::fromEntityToDTO)
//				.collect(Collectors.toList());
//	}
	
//	@Override
//	public List<BarcodeDTO> getProdutsForBarcode() {
//	    List<MainStock> mainStock = mainStockRepository.findAll();
//	    return mainStock.stream()
//	            .map(stock -> {
//	                Price price = priceRepository.findByMainStockId(stock.getId()); // assuming there's a method to get the price by main stock id
//	                return fromEntityToDTO(stock, price);
//	            })
//	            .collect(Collectors.toList());
//	}
	
//	public static byte[] getBarCodeImage(String text,int width, int height) {
//		try {
//			Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap=new Hashtable<>();
//			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//			Writer writer = new Code128Writer();
//			BitMatrix bitMatrix=writer.encode(text, BarcodeFormat.CODE_128, width, height);
//			ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//			MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
//			return byteArrayOutputStream.toByteArray();
//		} catch (Exception e) {
//			return null;
//		}
//	}
//	
//	@Override
//	public BarcodeDTO fromEntityToDTO(MainStock mainStock, Price price) {
//		return new BarcodeDTO(mainStock.getStyleNumber(), mainStock.getColor(), mainStock.getSize(),price.getMrp());
//	}
}
