package com.proje.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MetinKalınsaz
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDetails {

	private String productName;

	private double unitPrice;

	private int avaible;

	private String brandName;

	private String categoryName;

}
