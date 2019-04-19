package com.proje.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class Universty {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int universtyId;

	private String name;

	// iliþkinin sahibini belirttik diger tarftada yapabilirdik farketmiyor
	@ManyToMany
	private List<Student> students = new ArrayList<Student>();

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public Universty(String name) {
		this.name = name;
	}

}
