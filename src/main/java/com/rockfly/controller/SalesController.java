package com.rockfly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sales")
public class SalesController {

	@GetMapping("/preorder")
	public String getPreOrderPage() {
		return "pages/sales/PreOrder";
	}
}
