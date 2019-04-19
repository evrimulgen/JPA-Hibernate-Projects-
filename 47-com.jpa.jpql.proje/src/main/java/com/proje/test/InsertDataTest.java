package com.proje.test;

import java.util.Date;

import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.repository.ProductRepository;
import com.proje.repository.impl.ProductRepositoryImpl;

public class InsertDataTest {
	/**
	 * @author MetinKalinsaz
	 */

	private static ProductRepository productRepository = new ProductRepositoryImpl();

	public static void main(String[] args) {
		InsertDataTest dataTest = new InsertDataTest();
		dataTest.insertData();

	}

	public void insertData() {

		Brand brand1 = new Brand("APPLE");
		Brand brand2 = new Brand("LG");
		Brand brand3 = new Brand("SONY");
		Brand brand4 = new Brand("SAMSUNG");
		Brand brand5 = new Brand("ASUS");

		Category category1 = new Category("BÝLGÝSAYAR");
		Category category2 = new Category("TABLET");
		Category category3 = new Category("TELEFON");

		Product product1 = new Product("IPHONE 7", 3500, 2, brand1, category3, new Date());
		Product product2 = new Product("LG G3 ", 2500, 1, brand2, category3, new Date());
		Product product3 = new Product("SONY XPERIA", 2700, 1, brand3, category3, new Date());

		Product product4 = new Product("Samsung z500", 1700, 1, brand4, category1, new Date());
		Product product5 = new Product("MAC i5", 4100, 1, brand1, category1, new Date());
		Product product6 = new Product("ASUS Ý7", 3100, 2, brand5, category1, new Date());

		Product product7 = new Product("GALAXY tABLET", 2300, 1, brand4, category2, new Date());
		Product product8 = new Product("IPAD ", 2600, 3, brand1, category2, new Date());
		Product product9 = new Product("SONY TABLET", 2400, 1, brand3, category2, new Date());

		productRepository.saveBrand(brand1);
		productRepository.saveBrand(brand2);
		productRepository.saveBrand(brand3);
		productRepository.saveBrand(brand4);
		productRepository.saveBrand(brand5);

		productRepository.saveCategory(category1);
		productRepository.saveCategory(category2);
		productRepository.saveCategory(category3);

		productRepository.saveProduct(product1);
		productRepository.saveProduct(product2);
		productRepository.saveProduct(product3);
		productRepository.saveProduct(product4);
		productRepository.saveProduct(product5);
		productRepository.saveProduct(product6);
		productRepository.saveProduct(product7);
		productRepository.saveProduct(product8);
		productRepository.saveProduct(product9);

	}
}
