package com.ecommerce.latienda.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.latienda.model.Product;

@Service
@Transactional
public class ShoppingCartService {

	private Map<Product, Integer> products = new HashMap<>();

	public void addProduct(Product product) {
		if (products.containsKey(product)) {
			products.replace(product, products.get(product) + 1);
		} else {
			products.put(product, 1);
		}
	}

	public void removeProduct(Product product) {
		if (products.containsKey(product)) {
			if (products.get(product) > 1)
				products.replace(product, products.get(product) - 1);
			else if (products.get(product) == 1) {
				products.remove(product);
			}
		}
	}

	public void removeAll() {
		products.clear();
	}

	public Map<Product, Integer> getProductsInCart() {
		return Collections.unmodifiableMap(products);
	}

	public double getTotal() {
		double total = 0;

		for (Product product : products.keySet()) {
			total += (product.getPrice() * products.get(product));
		}

		return total;
	}
}