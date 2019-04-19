package com.proje.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MetinKalinsaz
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int brandId;

	private String brandName;

	// iliþkinin sahibini belirttik
	@OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
	private List<Product> products;

	public Brand(String brandName) {

		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", products=" + "]";
	}

}