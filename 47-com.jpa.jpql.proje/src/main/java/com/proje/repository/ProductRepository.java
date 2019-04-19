package com.proje.repository;

import java.util.List;

import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.model.ProductDetails;

/**
 * @author MetinKalinsaz
 */
public interface ProductRepository {

	Product saveProduct(Product product);

	Category saveCategory(Category category);

	Brand saveBrand(Brand brand);

	List<Product> findProducts();

	List<Product> findProductEntities(int firstResult, int maxResult);

	Product findProductById(int productId);

	List<ProductDetails> findProductDetails();

	List<ProductDetails> findProductDetailById(int productId);

	List<String> findProductNames();

	List<Object[]> findProductNamesPrice();

	List<Product> findProductGreatPrice(double unitPrice);

	List<Product> findProductGreateAndLessPrice(double minUnitprice, double maxUnitPrice);

	List<Product> findProductBetweenPrice(double minUnitprice, double maxUnitPrice);

	List<Product> findLikeProductName(String productName);

	List<Product> findInCategoryName(String categoryName1, String categoryName2);

	List<Product> findInBrandName(String brandName1, String brandName2);

	// verilen kategorinin price degerinden yuksek olanlarý getir
	List<Product> findAllProduct(int categoryId);

	List<Object[]> findFunctionsPrice();

	List<Object[]> findProductGroupByCategory();

	List<Object[]> findProductGroupByHavingCategory(double unitPrice);

	List<Object[]> findProductGroupByBrand();

	List<Object[]> findProductGroupByHavingBrand(double unitPrice);

	List<Product> findProductOrderByDescPrice();

	List<Product> findProductOrderByAscPrice();

}
