package com.ecommerce.latienda.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ecommerce.latienda.model.Product;
import com.ecommerce.latienda.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(long id) {
		return productRepository.findById(id).get();
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}
}