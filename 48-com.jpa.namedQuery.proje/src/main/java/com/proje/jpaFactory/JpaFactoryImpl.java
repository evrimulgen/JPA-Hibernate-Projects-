package com.proje.jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/**
 * @author MetinKalinsaz
 */

public class JpaFactoryImpl implements JpaFactory {

	private EntityManager entityManager = null;

	@Override
	public EntityManager getEntityManager() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
		this.entityManager = entityManagerFactory.createEntityManager();

		return this.entityManager;
	}

	@Override
	public EntityTransaction getEntityTransaction() {
		EntityTransaction entityTransaction = this.entityManager.getTransaction();

		return entityTransaction;
	}

}
