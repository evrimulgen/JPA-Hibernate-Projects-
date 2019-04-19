package com.proje.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.model.Student;
import com.proje.model.Universty;
/**
 * @author MetinKalinsaz
 */
public class Test {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		Universty universty1 = new Universty("dpu");
		Universty universty2 = new Universty("odtü");
		Universty universty3 = new Universty("itü");

		Student student1 = new Student("metin", "kalınsaz", new Date());
		Student student2 = new Student("isa", "kalınsaz", new Date());
		Student student3 = new Student("ahmet", "yıldız", new Date());

		List<Student> students = Arrays.asList(student1, student2, student3);
		universty1.setStudents(students);

		List<Student> students2 = Arrays.asList(student1, student3);
		universty2.setStudents(students2);

		List<Student> students3 = Arrays.asList(student2);
		universty3.setStudents(students3);

		entityTransaction.begin();

		entityManager.persist(universty1);
		entityManager.persist(universty2);
		entityManager.persist(universty3);

		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);

		entityTransaction.commit();

	}
}
