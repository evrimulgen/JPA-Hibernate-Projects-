package com.proje.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactory.JpaFactoryImpl;
import com.proje.model.UserDetail;
import com.proje.repository.UserDetailRepository;
/**
 * @author MetinKalinsaz
 */
public class UserDetailRepositoryImpl implements UserDetailRepository {

	private final Logger logger = (Logger) LogManager.getLogger();

	private final JpaFactory factory = new JpaFactoryImpl();

	private final EntityManager entityManager = factory.getEntityManager();

	private final EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public void saveUserDetail(UserDetail userDetail) {

		try {

			this.entityTransaction.begin();

			this.entityManager.persist(userDetail);

			this.entityTransaction.commit();

		} catch (RuntimeException e) {
			logger.error("UserDetail persist edilirken hata meydana geldi..HATA: " + e);

			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {
				logger.error("UserDetail persist rollback edilirken hata meydana geldi..HATA: " + e2);
			}

		}

	}

	@Override
	public void updateUserDetail(UserDetail userDetail) {

		try {
			this.entityTransaction.begin();

			this.entityManager.merge(userDetail);
			this.entityManager.flush();

			this.entityTransaction.commit();

		} catch (RuntimeException e) {
			logger.error("UserDetail update edilirken hata meydana geldi..HATA: " + e);

			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {
				logger.error("UserDetail update rollback edilirken hata meydana geldi..HATA: " + e2);
			}
		}

	}

	@Override
	public void removeUserDetail(UserDetail userDetail) {

		try {

			if (entityManager.contains(userDetail)) {
				this.entityTransaction.begin();

				this.entityManager.remove(userDetail);

				this.entityTransaction.commit();
			} else {
				UserDetail userDetail2 = this.findById(userDetail.getUserDetailId());
				this.entityTransaction.begin();

				this.entityManager.remove(userDetail2);

				this.entityTransaction.commit();
			}

		} catch (RuntimeException e) {
			logger.error("UserDetail remove edilirken hata meydana geldi..HATA: " + e);
			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {
				logger.error("UserDetail remove rollback edilirken hata meydana geldi..HATA: " + e2);
			}
		}

	}

	@Override
	public UserDetail findByUsurname(final String userName) {

		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findByUsurname",
					UserDetail.class);
			typedQuery.setParameter("userName", userName);
			userDetail = typedQuery.getSingleResult();
		} catch (RuntimeException e) {
			logger.error("UserDetail findByUsurname  bulunurken hata meydana geldi..HATA: " + e);
		}

		return userDetail;
	}

	@Override
	public UserDetail findWithAddressByUserName(final String userName) {

		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = this.entityManager
					.createNamedQuery("UserDetail.findWithAddressByUserName", UserDetail.class);

			typedQuery.setParameter("userName", userName);
			userDetail = typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("UserDetail findWithAddressByUserName  bulunurken hata meydana geldi..HATA: " + e);
		}

		return userDetail;
	}

	@Override
	public UserDetail findWithAdvertisementByUserName(final String userName) {

		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = this.entityManager
					.createNamedQuery("UserDetail.findWithAdvertisementByUserName", UserDetail.class);
			typedQuery.setParameter("userName", userName);
			userDetail = typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("UserDetail findWithAdvertisementByUserName  bulunurken hata meydana geldi..HATA: " + e);
		}

		return userDetail;
	}

	@Override
	public UserDetail findById(final Integer userDetailId) {

		UserDetail userDetail = null;

		try {

			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findById",
					UserDetail.class);
			typedQuery.setParameter("userDetailId", userDetailId);
			userDetail = typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("UserDetail findById  bulunurken hata meydana geldi..HATA: " + e);
		}

		return userDetail;
	}

}
