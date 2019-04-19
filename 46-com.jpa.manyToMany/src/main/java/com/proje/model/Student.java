package com.proje.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int studentId;

	private String firstName;

	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date birthOfDate;

	@ManyToMany(mappedBy = "students")
	private List<Universty> universties = new ArrayList<Universty>();

	public void addUniversty(Universty universty) {
		this.universties.add(universty);
	}

	public Student(String firstName, String lastName, Date birthOfDate) {
		this.birthOfDate = birthOfDate;
		this.lastName = lastName;
		this.firstName = firstName;

	}

}
