package com.proje.repository;

import java.util.Date;
import java.util.List;

import com.proje.model.Product;
import com.proje.model.ProductDetails;

/**
 * @author MetinKalýnsaz
 */

public interface ProductRepository {

	List<Product> findProducts();

	List<Product> findProductsEntities(int firstResult, int maxResult);

	Product findProductById(int productId);

	List<ProductDetails> findProductDetails();

	List<Product> findCategoryName(String categoryName);

	int findProductCount();

	List<Product> findAddDateLater(Date addDate);

}
