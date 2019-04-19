package com.proje.test;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;
import com.proje.repository.impl.ProductRepositoryImpl;

public class Test {
	/**
	 * @author MetinKalinsaz
	 */
	static ProductRepository productRepository = new ProductRepositoryImpl();

	public static void main(String[] args) {
		// -----------------------------------------------------------------------
		// findProducts Product tum listesini bulma
//		List<Product> products=productRepository.findProducts();
//		
//		for (Product Product : products) {
//			System.out.println(Product);
//		}
		// -----------------------------------------------------------------------------

		// Product listesini id ile bulma
//		Product  Product=productRepository.findProductById(3);
//		
//		System.out.println(Product);

		// ------------------------------------------------------------------------
		// Baslang�c poz�syonundan sonra kac urunun s�ralanmas� sorgusu
//		List<Product> products=productRepository.findProductEntities(3, 4);
//		for (Product product : products) {
//			System.out.println(product);
//		}

		// --------------------------------------------------------------------------

		// details nesnesi olusturarak tum urunler� yazd�rd�k
//		List<ProductDetails> details=productRepository.findProductDetails();
//		
//		for (ProductDetails productDetails : details) {
//			System.out.println(productDetails);
//		}

		// --------------------------------------------------------------------------

		// Details nesnesi olusturarak product �d ile arama yapt�k urunler� yazd�rd�k
//		List<ProductDetails> details=productRepository.findProductDetailById(2);
//		
//		for (ProductDetails productDetails : details) {
//			System.out.println(productDetails);
//		}

		// ---------------------------------------------------------------------------
		// product urun isimlerini getirdik
		// neden string dedik ��nk� return type'� string bir degero yuzden str�ng
		// turuyle listeledik
//		List<String> strings=productRepository.findProductNames();
//		for (String string : strings) {
//			System.out.println(string);
//		}

		// -------------------------------------------------------------------------------
		// "SELECT P.productName,P.unitPrice FROM Product P"
		// 0.eleman //1. eleman
		// Bir diziye aktararak i�lemimizi yap�yoruz
		// product turunden tan�mlayamay�z cunku dizi olusturam�yor coklu yap�dan dolay�
		// yukar�da 2 eleman�m�z ver eger P.avaible da eklenseyd� d�z�m�z 3 elemanl�
		// olmus olacakt�

//		List<Object[]> list=productRepository.findProductNamesPrice();
//		
//		for (Object[] objects : list) {
//			                  //0.eleman     //1. eleman
//			System.out.println(objects[0]+" "+objects[1]);
//		}
		// --------------------------------------------------------------------------------
		// girilen fiyattan y�ksek olan �r�nlerimiz getiriyor
//		List<Product> products= productRepository.findProductGreatPrice(4000);
//
//			for (Product product : products) {
//				System.out.println(product);
//	
//
//			}

		// -----------------------------------------------------------------------------------
		// m�n ve maxx f�yat aras�ndak� urunler�m�z
//		List<Product> products=productRepository.findProductGreateAndLessPrice(2000,3000);
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}
//		
//		--------------------------------------------------------------------------------------
//		
//	List<Product> products=productRepository.findProductBetweenPrice(2000,3000);
//	
//	for (Product product : products) {
//		System.out.println(product);
//	}
//		
//		
		// ---------------------------------------------------------------------------------------

		// herhangibi harflerle �r�n bulma

//		List<Product> products=productRepository.findLikeProductName("A");
//		
//	for (Product product : products) {
//		System.out.println(product);
//
//	}
		// ---------------------------------------------------------------------------------------
		// category ismine g�re arama yapt�k
////		
//		List<Product> products=productRepository.findInCategoryName("TELEFON","B�LG�SAYAR");
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}
//		

		// ---------------------------------------------------------------------------------------
		// Markaya g�re arama yapma

//	List<Product> products=productRepository.findInBrandName("APPLE","SONY");
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}

		// ---------------------------------------------------------------------------------------

		// category f�yat�ndan en yuksek olanlar�n�n l�stes�n� get�r

//		List<Product> products=productRepository.findAllProduct(7);
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}
//		
//				//---------------------------------------------------------------------------------------

		// urunler�n toplam� ortalamas� en butyugu en kucugunu bulduk

//		
//		List<Object[]> products=productRepository.findFunctionsPrice();
////		
//	 Object[] objects=products.get(0);
//			System.out.println("avg: "+objects[0]+" sum: "+objects[1]+" min: "+objects[2]+" max: "+objects[3]+" count: "+objects[0]);

//		//---------------------------------------------------------------------------------------
		// categori ismine g�re her kategor�n�n ortalamas�n� bulma

//		List<Object[]> products=productRepository.findProductGroupByCategory();
//
//for (Object[] objects2 : products) {
//	System.out.println("CategoryName: "+objects2[0]+"-avg-"+objects2[1]);
//

		// ----------------------------------------------------------------------------------------------
//		gruplayarak ortalamalar�n� bulduk

//				List<Object[]> products=productRepository.findProductGroupByHavingCategory(2600);
//		
//		for (Object[] objects2 : products) {
//			System.out.println("CategoryName: "+objects2[0]+"-avg-"+objects2[1]);
//		
//		
//		
//	}
		// ----------------------------------------------------------------------------------------------
//buyukten kucuge g�re s�ralad�k f�yatlara gore

//		List<Product> products=productRepository.findProductOrderByDescPrice();
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}
		// ----------------------------------------------------------------------------------------------
		// kucukten buyuge g�re s�ralad�k f�yatlara gore

//	List<Product> products=productRepository.findProductOrderByAscPrice();
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}

	}

}
