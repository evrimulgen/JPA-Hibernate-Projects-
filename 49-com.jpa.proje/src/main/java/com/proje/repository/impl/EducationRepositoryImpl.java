package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.core.Logger;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactory.JpaFactoryImpl;
import com.proje.model.Education;
import com.proje.repository.EducationRepository;
/**
 * @author MetinKalinsaz
 */
public class EducationRepositoryImpl implements EducationRepository {

	private final Logger logger = (Logger) org.apache.logging.log4j.LogManager.getLogger();

	private JpaFactory factory = new JpaFactoryImpl();

	private EntityManager entityManager = factory.getEntityManager();

	private EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public void saveEducation(final Education education) {

		try {

			this.entityTransaction.begin();

			this.entityManager.persist(education);

			this.entityTransaction.commit();

		} catch (RuntimeException e) {

			logger.error("Education persist edilirken hata meydana  geldi..HATA:  " + e);

			try {

				this.entityTransaction.rollback();
			} catch (RollbackException e2) {
				logger.error("Education persist rollback edilirken hata meydana  geldi..HATA:  " + e2);
			}

		}

	}

	@Override
	public void updateEducation(final Education education) {

		try {

			this.entityTransaction.begin();

			this.entityManager.merge(education);
			this.entityManager.flush();

			this.entityTransaction.commit();

		} catch (RuntimeException e) {
			logger.error("Education update edilirken hata meydana  geldi..HATA:  " + e);

			try {

				this.entityTransaction.rollback();

			} catch (RollbackException e2) {
				logger.error("Education update rollback edilirken hata meydana  geldi..HATA:  " + e2);
			}

		}

	}

	@Override
	public void removeEducation(final Education education) {

		try {
			if (entityManager.contains(education)) {
				this.entityTransaction.begin();

				this.entityManager.remove(education);

				this.entityTransaction.commit();

			} else {
				Education education2 = findById(education.getEducationId());
				this.entityTransaction.begin();

				this.entityManager.remove(education2);

				this.entityTransaction.commit();
			}

		} catch (RuntimeException e) {
			logger.error("Education delete  edilirken hata meydana  geldi..HATA:  " + e);

			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {
				logger.error("Education delete rollback  edilirken hata meydana  geldi..HATA:  " + e2);
			}
		}

	}

	@Override
	public Education findById(final Integer educationId) {

		Education education = null;

		try {
			TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findById",
					Education.class);
			typedQuery.setParameter("educationId", educationId);
			education = typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("Education.findById aranýrken hata meydana  geldi..HATA:  " + e);
		}

		return education;
	}

	@Override
	public List<Education> findEducations() {

		List<Education> educations = null;

		try {
			TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findEducations",
					Education.class);
			educations = typedQuery.getResultList();

		} catch (RuntimeException e) {
			logger.error("Education.findEducations aranýrken hata meydana  geldi..HATA:  " + e);
		}

		return educations;
	}

	@Override
	public Education findWithAdvertisement(final Integer educationId) {

		Education education = null;
		try {

			TypedQuery<Education> typedQuery = this.entityManager.createNamedQuery("Education.findWithAdvertisement",
					Education.class);
			typedQuery.setParameter("educationId", educationId);
			education = typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("Education.findEducations aranýrken hata meydana  geldi..HATA:  " + e);
		}

		return education;
	}

}
