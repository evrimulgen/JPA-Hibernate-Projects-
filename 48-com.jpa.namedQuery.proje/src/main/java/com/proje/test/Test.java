package com.proje.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;
import com.proje.repository.impl.ProductRepositortImpl;

public class Test {

	public static Date custom(int day, int month, int year) {

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);

		return calendar.getTime();
	}

	public static void main(String[] args) {
		ProductRepository productRepository = new ProductRepositortImpl();

		// ------------------------------------------------------------------------------

		// tum l�stey� bulduk
		List<Product> products = productRepository.findProducts();
		for (Product product : products) {
			System.out.println(product);
		}

		// ------------------------------------------------------------------------------

		// baslang�c pozisyonu ve ilerleyecegi miktar ile urunle4r� bulduk
//		List<Product> products=productRepository.findProductsEntities(2, 4);
//		for (Product product : products) {
//			System.out.println(product);
//		}
		// ------------------------------------------------------------------------------
		// �d ile arama yapt�k
//		Product product=productRepository.findProductById(3);
//			System.out.println(product);
		// ------------------------------------------------------------------------------

		// productdetails ile product vs. urunler�n� yazd�rd�k

//		List<ProductDetails> details=productRepository.findProductDetails();
//		
//		for (ProductDetails productDetails : details) {
//			System.out.println(productDetails);
//		}
		// ------------------------------------------------------------------------------
		//CATEGORY �SM� �LE AYNI CATEGOR�DEKI  TUM �S�MLER� BULDUK

		//List<Product> details=productRepository.findCategoryName("B�LG�SAYAR");

//			for (Product productDetails : details) {
//			System.out.println(productDetails);
//		}

		// ------------------------------------------------------------------------------

		// TOPLAM URUNLERIMIZIN KAC ADET OLDUGUNU BULDUK
//		int integer=productRepository.findProductCount();
//		
//		System.out.println(integer);
//		

		// ------------------------------------------------------------------------------
		// bell� b�r tar�hten sonrak� ver�ler�n eklenme tar�hler�ne g�re get�r ded�k
//		
		//	List<Product> products=productRepository.findAddDateLater(custom(10,10,2018));
//	
		//	for (Product product : products) {
		//		System.out.println(product);
		//	}
		

		// ------------------------------------------------------------------------------

	}
}
