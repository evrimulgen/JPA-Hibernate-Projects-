package com.proje.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactory.JpaFactoryImpl;
import com.proje.model.Product;
import com.proje.model.ProductDetails;
import com.proje.repository.ProductRepository;

public class ProductRepositortImpl implements ProductRepository {

	/**
	 * @author MetinKalýnsaz
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private JpaFactory jpaFactory = new JpaFactoryImpl();

	private EntityManager entityManager = jpaFactory.getEntityManager();

	@Override
	public List<Product> findProducts() {

		TypedQuery<Product> typedQuery = this.entityManager.createNamedQuery("Product.findProducts", Product.class);

		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public List<Product> findProductsEntities(int firstResult, int maxResult) {

		TypedQuery<Product> typedQuery = this.entityManager.createNamedQuery("Product.findProducts", Product.class);

		typedQuery.setFirstResult(firstResult);
		typedQuery.setMaxResults(maxResult);
		List<Product> products = typedQuery.getResultList();

		return products;

	}

	@Override
	public Product findProductById(int productId) {
		TypedQuery<Product> typedQuery = entityManager.createNamedQuery("Product.findById", Product.class);
		typedQuery.setParameter("productId", productId);
		Product product = typedQuery.getSingleResult();

		return product;
	}

	@Override
	public List<ProductDetails> findProductDetails() {

		TypedQuery<ProductDetails> typedQuery = entityManager.createNamedQuery("Product.findProductDetails",
				ProductDetails.class);
		List<ProductDetails> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public List<Product> findCategoryName(String categoryName) {

		TypedQuery<Product> typedQuery = entityManager.createNamedQuery("Product.findCategoryName", Product.class);
		typedQuery.setParameter("categoryName", categoryName);
		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public int findProductCount() {

		TypedQuery<Long> typedQuery = entityManager.createNamedQuery("Product.findCount", Long.class);
		Long count = typedQuery.getSingleResult();

		return count.intValue();
	}

	@Override
	public List<Product> findAddDateLater(Date addDate) {
		TypedQuery<Product> typedQuery = entityManager.createNamedQuery("Product.findAddDateLater", Product.class);
		typedQuery.setParameter("addDate", addDate, TemporalType.TIMESTAMP);
		List<Product> products = typedQuery.getResultList();
		return products;
	}

}
