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
		// Baslangýc pozýsyonundan sonra kac urunun sýralanmasý sorgusu
//		List<Product> products=productRepository.findProductEntities(3, 4);
//		for (Product product : products) {
//			System.out.println(product);
//		}

		// --------------------------------------------------------------------------

		// details nesnesi olusturarak tum urunlerý yazdýrdýk
//		List<ProductDetails> details=productRepository.findProductDetails();
//		
//		for (ProductDetails productDetails : details) {
//			System.out.println(productDetails);
//		}

		// --------------------------------------------------------------------------

		// Details nesnesi olusturarak product ýd ile arama yaptýk urunlerý yazdýrdýk
//		List<ProductDetails> details=productRepository.findProductDetailById(2);
//		
//		for (ProductDetails productDetails : details) {
//			System.out.println(productDetails);
//		}

		// ---------------------------------------------------------------------------
		// product urun isimlerini getirdik
		// neden string dedik çünkü return type'ý string bir degero yuzden strýng
		// turuyle listeledik
//		List<String> strings=productRepository.findProductNames();
//		for (String string : strings) {
//			System.out.println(string);
//		}

		// -------------------------------------------------------------------------------
		// "SELECT P.productName,P.unitPrice FROM Product P"
		// 0.eleman //1. eleman
		// Bir diziye aktararak iþlemimizi yapýyoruz
		// product turunden tanýmlayamayýz cunku dizi olusturamýyor coklu yapýdan dolayý
		// yukarýda 2 elemanýmýz ver eger P.avaible da eklenseydý dýzýmýz 3 elemanlý
		// olmus olacaktý

//		List<Object[]> list=productRepository.findProductNamesPrice();
//		
//		for (Object[] objects : list) {
//			                  //0.eleman     //1. eleman
//			System.out.println(objects[0]+" "+objects[1]);
//		}
		// --------------------------------------------------------------------------------
		// girilen fiyattan yüksek olan ürünlerimiz getiriyor
//		List<Product> products= productRepository.findProductGreatPrice(4000);
//
//			for (Product product : products) {
//				System.out.println(product);
//	
//
//			}

		// -----------------------------------------------------------------------------------
		// mýn ve maxx fýyat arasýndaký urunlerýmýz
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

		// herhangibi harflerle ürün bulma

//		List<Product> products=productRepository.findLikeProductName("A");
//		
//	for (Product product : products) {
//		System.out.println(product);
//
//	}
		// ---------------------------------------------------------------------------------------
		// category ismine göre arama yaptýk
////		
//		List<Product> products=productRepository.findInCategoryName("TELEFON","BÝLGÝSAYAR");
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}
//		

		// ---------------------------------------------------------------------------------------
		// Markaya göre arama yapma

//	List<Product> products=productRepository.findInBrandName("APPLE","SONY");
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}

		// ---------------------------------------------------------------------------------------

		// category fýyatýndan en yuksek olanlarýnýn lýstesýný getýr

//		List<Product> products=productRepository.findAllProduct(7);
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}
//		
//				//---------------------------------------------------------------------------------------

		// urunlerýn toplamý ortalamasý en butyugu en kucugunu bulduk

//		
//		List<Object[]> products=productRepository.findFunctionsPrice();
////		
//	 Object[] objects=products.get(0);
//			System.out.println("avg: "+objects[0]+" sum: "+objects[1]+" min: "+objects[2]+" max: "+objects[3]+" count: "+objects[0]);

//		//---------------------------------------------------------------------------------------
		// categori ismine göre her kategorýnýn ortalamasýný bulma

//		List<Object[]> products=productRepository.findProductGroupByCategory();
//
//for (Object[] objects2 : products) {
//	System.out.println("CategoryName: "+objects2[0]+"-avg-"+objects2[1]);
//

		// ----------------------------------------------------------------------------------------------
//		gruplayarak ortalamalarýný bulduk

//				List<Object[]> products=productRepository.findProductGroupByHavingCategory(2600);
//		
//		for (Object[] objects2 : products) {
//			System.out.println("CategoryName: "+objects2[0]+"-avg-"+objects2[1]);
//		
//		
//		
//	}
		// ----------------------------------------------------------------------------------------------
//buyukten kucuge göre sýraladýk fýyatlara gore

//		List<Product> products=productRepository.findProductOrderByDescPrice();
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}
		// ----------------------------------------------------------------------------------------------
		// kucukten buyuge göre sýraladýk fýyatlara gore

//	List<Product> products=productRepository.findProductOrderByAscPrice();
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}

	}

}
