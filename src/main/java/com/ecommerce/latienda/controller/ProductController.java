package com.ecommerce.latienda.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.latienda.model.Product;
import com.ecommerce.latienda.service.ProductService;
import com.ecommerce.latienda.service.ShoppingCartService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private final ShoppingCartService shoppingCartService;

	@Autowired
	public ProductController(ShoppingCartService shoppingCartService, ProductService productService) {
		this.shoppingCartService = shoppingCartService;
		this.productService = productService;
	}

	@GetMapping("/products")
	public ModelAndView products() {
		ModelAndView mv = new ModelAndView();

		List<Product> productList = (List<Product>) productService.getAllProducts();

		mv.addObject("activeTabProducts", true);
		mv.addObject("productList", productList);

		int qty = 0;
		for (Integer size : shoppingCartService.getProductsInCart().values()) {
			qty += size;
		}

		mv.addObject("qty", qty);
		mv.addObject("total", String.format("%.2f", shoppingCartService.getTotal()));
		return mv;
	}

	@GetMapping("/products/{id}")
	public String viewProduct(@PathVariable Long id, Model modelMap) {

		Product product = productService.getProduct(id);

		List<Integer> qtyList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		modelMap.addAttribute("qtyList", qtyList);
		modelMap.addAttribute("qty", 1);
		modelMap.addAttribute("product", product);
		int qty = 0;
		for (Integer size : shoppingCartService.getProductsInCart().values()) {
			qty += size;
		}

		modelMap.addAttribute("qty", qty);
		modelMap.addAttribute("total", String.format("%.2f", shoppingCartService.getTotal()));

		return "single";
	}
}