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

		// tum lýsteyý bulduk
		List<Product> products = productRepository.findProducts();
		for (Product product : products) {
			System.out.println(product);
		}

		// ------------------------------------------------------------------------------

		// baslangýc pozisyonu ve ilerleyecegi miktar ile urunle4rý bulduk
//		List<Product> products=productRepository.findProductsEntities(2, 4);
//		for (Product product : products) {
//			System.out.println(product);
//		}
		// ------------------------------------------------------------------------------
		// ýd ile arama yaptýk
//		Product product=productRepository.findProductById(3);
//			System.out.println(product);
		// ------------------------------------------------------------------------------

		// productdetails ile product vs. urunlerýný yazdýrdýk

//		List<ProductDetails> details=productRepository.findProductDetails();
//		
//		for (ProductDetails productDetails : details) {
//			System.out.println(productDetails);
//		}
		// ------------------------------------------------------------------------------
		//CATEGORY ÝSMÝ ÝLE AYNI CATEGORÝDEKI  TUM ÝSÝMLERÝ BULDUK

		//List<Product> details=productRepository.findCategoryName("BÝLGÝSAYAR");

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
		// bellý býr tarýhten sonraký verýlerýn eklenme tarýhlerýne göre getýr dedýk
//		
		//	List<Product> products=productRepository.findAddDateLater(custom(10,10,2018));
//	
		//	for (Product product : products) {
		//		System.out.println(product);
		//	}
		

		// ------------------------------------------------------------------------------

	}
}
