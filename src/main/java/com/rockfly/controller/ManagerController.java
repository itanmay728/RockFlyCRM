package com.rockfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rockfly.models.ProductDetails;
import com.rockfly.models.ProductSpecifications;
import com.rockfly.models.ProductType;
import com.rockfly.models.RackNumber;
import com.rockfly.models.Size;
import com.rockfly.repositories.ProductTypeRepository;
import com.rockfly.services.ProductDetailsService;
import com.rockfly.services.ProductTypeService;
import com.rockfly.services.RackNumberService;
import com.rockfly.services.SizeService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ProductDetailsService productDetailsService;
	
	@Autowired
	private RackNumberService rackNumberService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@Autowired
	private SizeService sizeService;
	
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	private ProductDetailsService mainStockService;
	
	// Add Item Page
		@GetMapping("/addItem")
		public String getAddItemPage(Model model) {

			// System.out.println(categoryId);
			model.addAttribute("productType", productTypeService.getAllProductType());

			model.addAttribute("Sizes", sizeService.getAllSize());

			return "pages/manager/AddItem";
		}

		// getting ProductSpecifications of a product and creating options in select in
		// addItem page
		@GetMapping("/getproductSpecification/{productId}")
		@ResponseBody
		public List<ProductSpecifications> listProductSpecifications(@PathVariable Long productId) {

			ProductType productType = productTypeRepository.findById(productId).get();
			List<ProductSpecifications> productSpecifications = productType.getProductSpecifications();
			return productSpecifications;
		}

		// getting Size of a product and creating options in select in addItem page
		@GetMapping("/getsize/{productId}")
		@ResponseBody
		public List<Size> listProductSize(@PathVariable Long productId) {

			ProductType productType = productTypeRepository.findById(productId).get();
			List<Size> size = productType.getSize();
			return size;
		}
	
	//url mentioned in layout.html to navigate in main_stock_list page
	@GetMapping("/itemList")
	public String getMainStockList(@RequestParam(name = "sortByproduct_type", defaultValue = "All") String product_type, Model model) {
		
	List<ProductDetails> mainStock = productDetailsService.getMainStockSortByProductType(product_type);
		
		model.addAttribute("MainStock" , mainStock);
		
		return "pages/manager/ItemList";
	}
	
	//View Product Details When click on More button in main stock list page
	@GetMapping("/itemList/{productId}")
	public String getProductDetails(@PathVariable("productId") Long id, Model model) {
			
		model.addAttribute("RackNumbers",rackNumberService.getAllRackNumbers());
		
		model.addAttribute("MainStockProduct", productDetailsService.getMainStockProductDetailById(id));
			
//		model.addAttribute("rackNumbers", mainStockService.getRackNumberByMainStockId(id));
			
		return "pages/manager/ViewProductDetails";
	}
	
	// Saving Item in database
	@PostMapping("/addItem")
	public String saveItem(@ModelAttribute ProductDetails mainStock) {

		mainStockService.saveItem(mainStock);

		return "redirect:/manager/addItem";
	}
	
	@PostMapping("/mainStock")
	public String saveRackNumber(@RequestParam(name = "mainStockId") Long id, @ModelAttribute RackNumber rackNumber) {
		
//			mainStockService.setRackNumber(id, rackNumber);
			Long productId = id;
		return "redirect:/itemList/" + productId;
	}
}
