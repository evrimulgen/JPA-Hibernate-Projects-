package com.proje.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author MetinKalinsaz
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Address {

	private String street;

	private String road;

	private int postaCode;

	private String city;

}
