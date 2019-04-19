package com.proje.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactory.JpaFactoryImpl;
import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.model.ProductDetails;
import com.proje.queries.ProductQueries;
import com.proje.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository , Serializable {

	/**
	 * @author MetinKalinsaz
	 */
	private static final long serialVersionUID = 8306366193248017982L;


	private JpaFactory jpaFactory = new JpaFactoryImpl();

	private EntityManager entityManager = jpaFactory.getEntityManager();

	private EntityTransaction entityTransaction = jpaFactory.getEntityTransaction();

	@Override
	public Product saveProduct(Product product) {

		this.entityTransaction.begin();
		
		this.entityManager.persist(product);
		
		this.entityTransaction.commit();
		
		return product;
	}

	@Override
	public Category saveCategory(Category category) {

		this.entityTransaction.begin();
		
		this.entityManager.persist(category);
		
		this.entityTransaction.commit();
		return category;
	}

	@Override
	public Brand saveBrand(Brand brand) {

		this.entityTransaction.begin();
		
		this.entityManager.persist(brand);
		
		this.entityTransaction.commit();
		
		return brand;
	}

	@Override
	public List<Product> findProducts() {
		
		//1. yöntem biraz amatörce çunku bunun list olup olmadýgýný býlmedýgýný soleyerek uyarý verýyor
//		Query query=this.entityManager.createQuery(ProductQueries.findProducts);
//		List<Product> products=query.getResultList();
		//2. yöntem ise daha geliþmiþ yapýdadýr bunun kullanýlmasý daha avantajlýdýr
		
		TypedQuery<Product> typedQuery=(TypedQuery<Product>) this.entityManager.createQuery(ProductQueries.findProducts, Product.class);
		List<Product> products=typedQuery.getResultList();
		
		return products;
	}

	//baslangýc ve toplam gelecek urun sayýsýný belýrterek bu sekýlde kac urunun gelmesýný ýstedýgýmýzý belýrttýk...
	//yukardaký sorgumuzu kullanýyoruz sadece baslangýc ve býtýsý parametre alarak sýnýrlayabýlýyoruz
	@Override
	public List<Product> findProductEntities(int firstResult, int maxResult) {

		TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findProducts, Product.class);
		//baþlangýc pozisyonunu belirttik
		//max kactane olacagýný belýrttýk
		//örnegýn baslangýs degerý 10 olsun ve max da 40 uzun getýrsýn toplam 50 urun gelmýs olur
		typedQuery.setFirstResult(firstResult);
		typedQuery.setMaxResults(maxResult);
	
		List<Product> products=typedQuery.getResultList();
		
		return products;
	}

	@Override
	public Product findProductById(int productId) {

 TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findProductById, Product.class);	
 typedQuery.setParameter("productId", productId); //queryýmýzde : ile yazdýgýmýz alaný alýp gelen parametreyý buna atýyoruz .
		//yani :productId olan querýdeký kýsýma metodumuzdan gelen oproductId olacagýný vbelýrtýyoruyz...
		Product product= typedQuery.getSingleResult(); //(tek veri geldiginde singleresult kullanýrýz
		
		return product;
	}

	@Override
	public List<ProductDetails> findProductDetails() {

TypedQuery<ProductDetails>  typedQuery=this.entityManager.createQuery(ProductQueries.findProductDetails, ProductDetails.class);
List<ProductDetails> productDetails=typedQuery.getResultList();
		
		
		return productDetails;
	}

	@Override
	public List<ProductDetails> findProductDetailById(int productId) {


		TypedQuery< ProductDetails> typedQuery=entityManager.createQuery(ProductQueries.findProductDetailsById, ProductDetails.class);
		typedQuery.setParameter("productId", productId);
		List<ProductDetails> productDetails=typedQuery.getResultList();
		
		
		return productDetails;
	}

	@Override
	public List<String> findProductNames() {


		TypedQuery< String> typedQuery=entityManager.createQuery(ProductQueries.findProductNames, String.class);
		List<String> productNames=typedQuery.getResultList();
		
		return productNames;
	}

	@Override
	public List<Object[]> findProductNamesPrice() {

		TypedQuery< Object[]> typedQuery=entityManager.createQuery(ProductQueries.findProductNamesPrice, Object[].class);
		List<Object[]> productNamesPrice=typedQuery.getResultList();
		
		return productNamesPrice;
	}

	@Override
	public List<Product> findProductGreatPrice(double unitPrice) {

		TypedQuery< Product> typedQuery=entityManager.createQuery(ProductQueries.findProductGreatPrice, Product.class);
		typedQuery.setParameter("unitPrice", unitPrice);
		
		if(typedQuery.getMaxResults()>unitPrice) {
			List<Product> products=typedQuery.getResultList();
			
			return products ;

		}else {

				System.out.println("Ürün bulunamadý.en buyuk deger budur bundan fazla býr deger gýrýnýz...");
				return null;
		}
	}

	@Override
	public List<Product> findProductGreateAndLessPrice(double minUnitprice, double maxUnitPrice) {

		TypedQuery< Product> typedQuery=entityManager.createQuery(ProductQueries.findGreatLessPrice, Product.class);
		typedQuery.setParameter("minUnitprice", minUnitprice);
		typedQuery.setParameter("maxUnitPrice", maxUnitPrice);
		List<Product> products=typedQuery.getResultList();
		
		return products;
	}

	@Override
	public List<Product> findProductBetweenPrice(double minUnitprice, double maxUnitPrice) {


		TypedQuery< Product> typedQuery=this.entityManager.createQuery(ProductQueries.findBetweenPrice, Product.class);
		typedQuery.setParameter("minUnitPrice",minUnitprice );
		typedQuery.setParameter("maxUnitPrice", maxUnitPrice);
		List<Product> products=typedQuery.getResultList();
		
		return products;
	}
	
	@Override
	public List<Product> findLikeProductName(String productName) {


		TypedQuery<Product> typedQuery=this.entityManager.createQuery(ProductQueries.findLikeProductName, Product.class);
		typedQuery.setParameter("productName", "%"+productName+"%");
		List<Product> product=typedQuery.getResultList();
		

		
		return product;
	}

	@Override
	public List<Product> findInCategoryName(String categoryName1, String categoryName2) {
		TypedQuery< Product>  typedQuery=this.entityManager.createQuery(ProductQueries.findInCategoryName, Product.class);

		typedQuery.setParameter("categoryName1", categoryName1);
		typedQuery.setParameter("categoryName2", categoryName2);
		
		List<Product> products=typedQuery.getResultList();
				
				
				return products;
	}

	@Override
	public List<Product> findInBrandName(String brandName1,String brandName2) {
 
		TypedQuery< Product>  typedQuery=this.entityManager.createQuery(ProductQueries.findInBrandName, Product.class);

		typedQuery.setParameter("brandName1", brandName1);
		typedQuery.setParameter("brandName2", brandName2);
		
		List<Product> products=typedQuery.getResultList();
				
				
				return products;
	}

	@Override
	public List<Product> findAllProduct(int categoryId) {

		TypedQuery< Product> typedQuery =this.entityManager.createQuery(ProductQueries.findAllProduct, Product.class);
		typedQuery.setParameter("categoryId", categoryId);
		List<Product> products=typedQuery.getResultList();

		
		
		return products;
	}

	@Override
	public List<Object[]> findFunctionsPrice() {

		TypedQuery<Object[]> typedQuery=this.entityManager.createQuery(ProductQueries.findFunctionsPrice, Object[].class);
		List<Object[]> functionPrice=typedQuery.getResultList();

		
		
		return functionPrice;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findProductGroupByCategory() {

		Query query=this.entityManager.createQuery(ProductQueries.findGroupByCategory, Object[].class);
		List<Object[]> groupByCategory=query.getResultList();
		
		return groupByCategory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findProductGroupByHavingCategory(double unitPrice) {


		Query query=this.entityManager.createQuery(ProductQueries.findGroupByHavingCategory);
		query.setParameter("unitPrice", unitPrice);
		List<Object[]> gropByHavingCategory=query.getResultList();
		
		return gropByHavingCategory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findProductGroupByBrand() {
		Query query=this.entityManager.createQuery(ProductQueries.findGroupByBrand);
		List<Object[]> groupByBrand=query.getResultList();
		
			return groupByBrand;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findProductGroupByHavingBrand(double unitPrice) {
		Query query=this.entityManager.createQuery(ProductQueries.findGroupByHavingBrand);
		query.setParameter("unitPrice", unitPrice);

		List<Object[]> groupByHavingBrand=query.getResultList();
		
			return groupByHavingBrand;	
	}

	@Override
	public List<Product> findProductOrderByDescPrice() {

		TypedQuery< Product> typedQuery=this.entityManager.createQuery(ProductQueries.findOrderByDescPrice, Product.class);
		List<Product> products=typedQuery.getResultList();

		return products;
	}

	
	@Override
	public List<Product> findProductOrderByAscPrice() {

		TypedQuery< Product> typedQuery=this.entityManager.createQuery(ProductQueries.findOrderByAscPrice, Product.class);
		List<Product> products=typedQuery.getResultList();

		
		return products;
	}



	

}
