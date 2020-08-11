package com.ecommerce.latienda.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.latienda.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}