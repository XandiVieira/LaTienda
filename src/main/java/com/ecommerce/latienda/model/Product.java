package com.ecommerce.latienda.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Product name is required.")
	@Basic(optional = false)
	private String name;

	@NotNull(message = "Product description is required.")
	private String productDescription;

	@NotNull(message = "Product price is required.")
	private Double price;

	@NotNull(message = "Category is required")
	private CategoryENUM category;

	private String pictureUrl;

	public Product() {
		super();
	}

	public Product(@NotNull(message = "Product name is required.") String name,
			@NotNull(message = "Product description is required.") String productDescription,
			@NotNull(message = "Product price is required.") Double price,
			@NotNull(message = "Category is required") CategoryENUM category, String pictureUrl) {
		super();
		this.name = name;
		this.productDescription = productDescription;
		this.price = price;
		this.category = category;
		this.pictureUrl = pictureUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CategoryENUM getCategory() {
		return category;
	}

	public void setCategory(CategoryENUM category) {
		this.category = category;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Product product = (Product) o;

		return id.equals(product.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}