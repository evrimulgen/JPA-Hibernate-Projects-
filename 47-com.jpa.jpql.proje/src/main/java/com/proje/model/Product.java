package com.proje.model;

import java.util.Date;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MetinKalinsaz
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
public class Product {

	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
	
	
	
	public Product(String productName,double unitPrice,int avaible,Brand brand,Category category,Date addDate) {
		this.brand=brand;
		this.category=category;
		this.addDate=addDate;
		this.avaible=avaible;
		this.productName=productName;
		this.unitPrice=unitPrice;
		
		
		
		
		
	}
}
