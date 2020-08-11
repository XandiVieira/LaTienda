package com.ecommerce.latienda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.latienda.model.CategoryENUM;
import com.ecommerce.latienda.model.Product;
import com.ecommerce.latienda.service.ProductService;

@SpringBootApplication
@RestController
public class LaTiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaTiendaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product("Xícara com café", "Bela xícara com café quentinho de boa qualidade feito na hora", 19.99, CategoryENUM.ALIMENTOS, "/images/xicara1.png"));
			productService.save(new Product("Camisa Internacional", "Camisa SCI original modelo 2020 seminova", 150.00, CategoryENUM.ROUPAS, "/images/camisa1.png"));
			productService.save(new Product("PS4", "PlayStation 4 seminovo, 300GB HD, 2 joysticks, mais de 10 jogos", 700.00, CategoryENUM.ELETRONICOS, "/images/ps41.png"));
			productService.save(new Product("TV", "TV Samsung ''42 seminova", 500.00, CategoryENUM.ELETRONICOS, "/images/tv1.png"));
			productService.save(new Product("Garrafa vazia", "Garrafa de plástico vazia bem conservada", 0.99, CategoryENUM.VARIADOS, "/images/garrafa1.png"));
			productService.save(new Product("Caixa com roupas", "Caixa de papelão 1m x 50cm com algumas roupas usadas dentro", 50.00, CategoryENUM.ROUPAS, "/images/caixa1.png"));
			productService.save(new Product("Bronco Inalador", "Bronco inalador já utilizado. Ainda tem um restinho", 12.00, CategoryENUM.VARIADOS, "/images/bronco1.png"));
			productService.save(new Product("Cavalinho do Inter", "Cavalinho do Fantástico do Inter", 30.00, CategoryENUM.VARIADOS, "/images/cavalo1.png"));
		};
	}
}