package com.ecommerce.latienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.latienda.service.ProductService;
import com.ecommerce.latienda.service.ShoppingCartService;

@Controller
public class ShoppingCartController {

	@Autowired
	private final ShoppingCartService shoppingCartService;

	@Autowired
	private final ProductService productService;

	@Autowired
	public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
		this.shoppingCartService = shoppingCartService;
		this.productService = productService;
	}

	@GetMapping("/cart")
	public ModelAndView shoppingCart() {
		ModelAndView modelAndView = new ModelAndView("cart");
		modelAndView.addObject("products", shoppingCartService.getProductsInCart());
		modelAndView.addObject("total", String.valueOf(shoppingCartService.getTotal()));
		return modelAndView;
	}

	@GetMapping("/product/addProduct/{productId}")
	public String addProductToCart(@PathVariable("productId") Long productId) {
		shoppingCartService.addProduct(productService.getProduct(productId));
		return "redirect:/products";
	}

	@GetMapping("/cart/addProduct/{productId}")
	public ModelAndView goToCart(@PathVariable("productId") Long productId) {
		shoppingCartService.addProduct(productService.getProduct(productId));
		return shoppingCart();
	}

	@GetMapping("/cart/removeProduct/{productId}")
	public ModelAndView removeProductFromCart(@PathVariable("productId") Long productId) {
		shoppingCartService.removeProduct(productService.getProduct(productId));
		return shoppingCart();
	}

	@GetMapping("/cart/removeProducts")
	public String removeAll() {
		shoppingCartService.removeAll();
		return "redirect:/products";
	}
}