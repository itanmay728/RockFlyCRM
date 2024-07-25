package com.rockfly.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rockfly.dto.BarcodeDTO;
import com.rockfly.dto.CustomerDTO;
import com.rockfly.dto.MainStockDTO;
import com.rockfly.models.Account;
import com.rockfly.models.Customers;

import com.rockfly.models.ProductSpecifications;
import com.rockfly.models.Size;
import com.rockfly.models.ProductType;
import com.rockfly.models.RackNumber;

import com.rockfly.models.DocumentType;
import com.rockfly.models.ProductDetails;
import com.rockfly.models.Size;
import com.rockfly.models.ProductType;
import com.rockfly.repositories.CustomersRepository;
import com.rockfly.repositories.DocumentTypeRepository;
import com.rockfly.repositories.ProductTypeRepository;
import com.rockfly.services.CustomerService;
import com.rockfly.services.SpecificationsService;
import com.rockfly.services.ProductDetailsService;
import com.rockfly.services.SizeService;
import com.rockfly.services.ProductTypeService;
import com.rockfly.services.RackNumberService;
import com.rockfly.services.RolesService;
import com.rockfly.services.Impl.AccountServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AccountServiceImpl accountService;

	@Autowired
	private CustomerService customerServices;

	@Autowired
	private ProductTypeService productTypeService;

	@Autowired
	private SizeService sizeService;

	@Autowired
	private RackNumberService rackNumberService;

	@Autowired
	private SpecificationsService specificationsService;

	@Autowired
	private DocumentTypeRepository documentTypeRepository;

	@Autowired
	private CustomersRepository customersRepository;

	

	@Autowired
	private RolesService rolesService;

	@GetMapping("/addEmployee")
	public String getAddEmployeePage(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "pages/admin/AddEmployee";

	}

	@PostMapping("/addEmployee")
	public String register_accountString(@ModelAttribute Account account, RedirectAttributes attributes) {
		try {
			accountService.saveAccountByDefaultRole(account);
			attributes.addFlashAttribute("message", "Employee added successfully");
			return "redirect:/admin/addEmployee";

		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/admin/addEmployee";

		}

	}

	@GetMapping("/employeelist")
	public String getAllEmployee(Model model) {

		model.addAttribute("employees", accountService.getAllAccount());

		return "pages/admin/EmployeeList";
	}

	@GetMapping("/employee/edit/{id}")
	public String editEmployee(@PathVariable("id") Long id, Model model) {

		Account account = accountService.getAccountById(id);

		model.addAttribute("account", account);

		model.addAttribute("roles", rolesService.getAllRoles());

		return "pages/admin/EditEmployee";
	}

	@PostMapping("/saveEditedEmp")
	public String saveEditedEmployee(Account account) {

		accountService.saveAccount(account);

		return "redirect:/admin/employeelist";
	}


	// ADD/List of Product/Size
	@GetMapping("/addProductAndSize")
	public String AddproductAndSizePage(Model model) {

		model.addAttribute("productType", productTypeService.getAllProductType());

		model.addAttribute("numericSize", sizeService.getAllSize());

		return "pages/admin/AddProductAndSize";
	}

	// Add Product
	@PostMapping("/addProductAndSize")
	public String AddProductType(@ModelAttribute ProductType productType) {

		productTypeService.addProductType(productType);

		return "redirect:/admin/addProductAndSize";
	}

	// Add Size
	@PostMapping("/addSize")
	public String AddSize(@ModelAttribute Size size) {

		sizeService.saveSize(size);
		return "redirect:/admin/addProductAndSize";

	}

	@PostMapping("/manageSize")
	public String manageSize(@ModelAttribute Size size, @ModelAttribute ProductType productType) {

		productTypeService.manageSize(size, productType);

		return "redirect:/admin/addProductAndSize";

	}

	// Specifications And Rack Number
	@GetMapping("/addSpecificationsAndRackNumber")
	public String AddSpecificationsAndRackNumber(Model model) {

		model.addAttribute("RackNumbers", rackNumberService.getAllRackNumbers());
		model.addAttribute("Specifications", specificationsService.getAllSpecifications());

		return "pages/admin/AddSpecificationsAndRackNumber";
	}

	// saving Specifications
	@PostMapping("/addspecification")
	public String saveSpecifications(@ModelAttribute ProductSpecifications productSpecifications) {

		specificationsService.saveSpecifications(productSpecifications);

		return "redirect:/admin/addSpecificationsAndRackNumber";
	}

	// saving Rank Number
	@PostMapping("/saveRackNumber")
	public String saveRackNumber(@ModelAttribute RackNumber rackNumber) {
		rackNumberService.saveRack(rackNumber);
		return "redirect:/admin/addSpecificationsAndRackNumber";
	}

	@GetMapping("/addCustomer")
	public String getAddCustomerPage(Model model) {
		Customers customers = new Customers();
		model.addAttribute("customers", customers);

		List<DocumentType> docs = new ArrayList<>();
		docs.addAll(documentTypeRepository.findAll());
		model.addAttribute("docs", docs);
		DocumentType documentType = new DocumentType();
		model.addAttribute("docType", documentType);
		return "pages/sales/AddCustomer";
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute Customers customers, RedirectAttributes attributes) {
		System.out.println(customers.getShopName());
		try {
			customerServices.save(customers);
			attributes.addFlashAttribute("message", "Customer added successfully");
			return "redirect:/admin/addCustomer";
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/admin/addCustomer";
		}

	}

//	@ResponseBody
//	@RequestMapping("/customers")
	// public List<CustomerDTO> getCustomerList() {

	// return customerServices.getAllCustomers();
	// }

	@GetMapping("/customers")
	public String getCustomerList(Model model,
			@RequestParam(required = false, name = "sort_by", defaultValue = "asOfDate") String sort_by,
			@RequestParam(required = false, name = "per_page", defaultValue = "1") String per_page,
			@RequestParam(required = false, name = "page", defaultValue = "1") String page) {
		// List<CustomerDTO> customerList = customerServices.getAllCustomers();

		Page<CustomerDTO> customers_on_page = customerServices.getAllCustomers(Integer.parseInt(page) - 1,
				Integer.parseInt(per_page), sort_by);
		int total_pages = customers_on_page.getTotalPages();
		List<Integer> pages = new ArrayList<>();
		if (total_pages > 0) {
			pages = IntStream.rangeClosed(0, total_pages - 1).boxed().collect(Collectors.toList());
		}

		List<String> links = new ArrayList<>();

		if (pages != null) {
			for (int link : pages) {
				String active = "";
				if (link == customers_on_page.getNumber()) {
					active = "active";
				}

				String _temp_link = "?per_page=" + per_page + "&page=" + (link + 1) + "&sort_by=" + sort_by;
				links.add("<li class=\"page-item " + active + "\"><a href=\"" + _temp_link + "\" class='page-link'>"
						+ (link + 1) + "</a></li>");
			}

			model.addAttribute("links", links);
		}

		model.addAttribute("customers", customers_on_page);
		return "pages/sales/CustomerList";

	}

	// display customers having specific id from the search bar
	@GetMapping("/customer/{id}")
	public String getCustomer(@PathVariable("id") Long id, Model model) {

		model.addAttribute("customer", customersRepository.findById(id).get());
		return "pages/sales/Customer";
	}

	@PostMapping("/documentType")
	public String manageDocumentType(@ModelAttribute DocumentType docType) {
		documentTypeRepository.save(docType);
		return "redirect:/admin/addCustomer";
	}

	// to get barcode of each item added
//	@GetMapping("/product")
//	public String product(Model model) {
//
//		//List<BarcodeDTO> products = productTypeService;
//
//	//	model.addAttribute("MainStock", mainStock);
//		return "pages/ProductList";
//	}

}
