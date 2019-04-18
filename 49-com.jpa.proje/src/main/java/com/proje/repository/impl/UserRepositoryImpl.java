package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactory.JpaFactoryImpl;
import com.proje.model.User_My;
import com.proje.model.UserInfo;
import com.proje.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private final Logger logger = (Logger) LogManager.getLogger();

	private final JpaFactory factory = new JpaFactoryImpl();

	private final EntityManager entityManager = factory.getEntityManager();

	private final EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public void saveUser(final User_My user_My) {

		try {
			this.entityTransaction.begin();

			this.entityManager.persist(user_My);

			this.entityTransaction.commit();

		} catch (RuntimeException e) {
			logger.error("User_My persist edilirken hata meydana geldi..HATA: " + e);

			try {

				this.entityTransaction.rollback();

			} catch (RollbackException e2) {
				logger.error("User_My persist rollback edilirken hata meydana geldi..HATA: " + e2);
			}
		}

	}

	@Override
	public void updateUser(final User_My user_My) {

		try {
			this.entityTransaction.begin();

			this.entityManager.merge(user_My);
			this.entityManager.flush();

			this.entityTransaction.commit();

		} catch (RuntimeException e) {
			logger.error("User_My merge edilirken hata meydana geldi..HATA: " + e);

			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {
				logger.error("User_My merge rollback edilirken hata meydana geldi..HATA: " + e);
			}
		}

	}

	@Override
	public void removeUser(final User_My user_My) {

		try {
			if (entityManager.contains(user_My)) {
				this.entityTransaction.begin();

				this.entityManager.remove(user_My);

				this.entityTransaction.commit();
			} else {
				User_My user2 = this.findById(user_My.getUserId());
				this.entityTransaction.begin();

				this.entityManager.remove(user2);

				this.entityTransaction.commit();

			}

		}

		catch (RuntimeException e) {
			logger.error("User_My remove  edilirken hata meydana geldi..HATA: " + e);
			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {
				logger.error("User_My remove rollback  edilirken hata meydana geldi..HATA: " + e);
			}
		}

	}

	@Override
	public User_My findById(final Integer userId) {

		User_My user_My = null;
		try {

			TypedQuery<User_My> typedQuery = entityManager.createNamedQuery("User_My.findById", User_My.class);
			typedQuery.setParameter("userId", userId);
			user_My = typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("User_My findById  edilirken hata meydana geldi..HATA: " + e);
		}

		return user_My;
	}

	@Override
	public User_My findByUserName(final String userName) {
		User_My user_My = null;
		try {

			TypedQuery<User_My> typedQuery = this.entityManager.createNamedQuery("User_My.findByUserName", User_My.class);

			typedQuery.setParameter("userName",userName);
			user_My = (User_My) typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("User_My findByUserName  edilirken hata meydana geldi..HATA: " + e);
		}

		return user_My;
	}

	@Override
	public User_My findWithUserDetailByUsername(final String userName) {

		User_My user_My = null;

		try {

			TypedQuery<User_My> typedQuery = this.entityManager.createNamedQuery("User_My.findWithUserDetailByUsername",
					User_My.class);
			typedQuery.setParameter("userName",userName);
			user_My = typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("User_My findWithUserDetailByUsername  edilirken hata meydana geldi..HATA: " + e);
		}

		return user_My;
	}

	@Override
	public List<User_My> findUsers() {

		List<User_My> user_Mies = null;

		try {

			TypedQuery<User_My> typedQuery = this.entityManager.createNamedQuery("User_My.findUsers", User_My.class);
			user_Mies = typedQuery.getResultList();

		} catch (RuntimeException e) {
			logger.error("User_My findUsers  edilirken hata meydana geldi..HATA: " + e);
		}

		return user_Mies;
	}

	@Override
	public List<User_My> findUsers(final int firstResult,final  int maxResult) {

		List<User_My> user_Mies = null;

		try {

			TypedQuery<User_My> typedQuery = this.entityManager.createNamedQuery("User_My.findUsers", User_My.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);
			user_Mies = typedQuery.getResultList();
		} catch (RuntimeException e) {
			logger.error("User_My findUsers  edilirken hata meydana geldi..HATA: " + e);
		}

		return user_Mies;
	}

	@Override
	public Long findUserCount() {
		Long count = (long) 0;
		try {
			Query typedQuery = entityManager.createNamedQuery("User_My.findCount");
			count = (Long) typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("User_My findUserCount  edilirken hata meydana geldi..HATA: " + e);
		}

		return (long) count;
	}

	@Override
	public UserInfo findUserInfoByUserName(final String userName) {

		UserInfo userInfo = null;

		try {

			TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("User_My.findUserInfoByUserName",
					UserInfo.class);
			typedQuery.setParameter("userName", userName);
			userInfo = typedQuery.getSingleResult();

		} catch (RuntimeException e) {
			logger.error("User_My findUserInfoByUserName  edilirken hata meydana geldi..HATA: " + e);
		}

		return userInfo;
	}

}
