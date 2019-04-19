package com.proje.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MetinKalýnsaz
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQueries({ @NamedQuery(name = "Product.findProducts", query = "SELECT P FROM Product P"),
		@NamedQuery(name = "Product.findById", query = "SELECT P FROM Product P WHERE P.productId=:productId"),
		@NamedQuery(name = "Product.findCategoryName", query = "SELECT P FROM Product P where P.category.categoryName=:categoryName"),
		@NamedQuery(name = "Product.findCount", query = "SELECT COUNT(P) FROM Product P"),
		@NamedQuery(name = "Product.findAddDateLater", query = "SELECT P FROM Product P WHERE P.addDate>:addDate "),
		@NamedQuery(name = "Product.findProductDetails", query = "SELECT new com.proje.model.ProductDetails(P.productName,P.unitPrice,P.avaible,P.brand.brandName,P.category.categoryName) FROM Product P") })
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productId;

	private String productName;

	private double unitPrice;

	private int avaible;

	@Temporal(TemporalType.TIMESTAMP)
	private Date addDate;

	private Date updateDate;

	@ManyToOne
	private Category category;

	@ManyToOne
	private Brand brand;

	public Product(String productName, double unitPrice, int avaible, Brand brand, Category category, Date addDate) {
		this.brand = brand;
		this.category = category;
		this.addDate = addDate;
		this.avaible = avaible;
		this.productName = productName;
		this.unitPrice = unitPrice;

	}
}
