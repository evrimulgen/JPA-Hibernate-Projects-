package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactory.JpaFactoryImpl;
import com.proje.model.Advertisement;
import com.proje.repository.AdvertisementRepository;
/**
 * @author MetinKalinsaz
 */
public class AdvertisementRepositoryImpl implements AdvertisementRepository {

	private Logger logger = LogManager.getLogger();
	private JpaFactory factory = new JpaFactoryImpl();
	private EntityManager entityManager = this.factory.getEntityManager();

	private EntityTransaction entityTransaction = this.entityManager.getTransaction();

	@Override
	public void saveAdvertisement(final Advertisement advertisement) {

		try {

			this.entityTransaction.begin();

			this.entityManager.persist(advertisement);

			this.entityTransaction.commit();

		} catch (RuntimeException e) {

			logger.error("Persist yapýlýrken hata meydana geldi..HATA: " + e);

			try {

				this.entityTransaction.rollback();
			} catch (RollbackException e2) {

				logger.error("Insert Rollback yapýlýrken hata meydana geldi..HATA: " + e2);
			}
		}

	}

	@Override
	public void updateAdvertisement(final Advertisement advertisement) {

		try {

			this.entityTransaction.begin();

			this.entityManager.merge(advertisement);
			// tablolarýmýz güncellendiginde commit yapýldýgýnda güncellenmiþ sekliyle geri
			// almamýzý saglýyor...
			this.entityManager.flush();

			this.entityTransaction.commit();

		} catch (RuntimeException e) {

			logger.error("Güncelleme yapýlýrken hata meydana geldi..HATA:" + e);

			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {

				logger.error("Update rollback yapýlýrken hata meydana geldi..HATA: " + e2);
			}
		}

	}

	// degerini degiþtirmedigimiz için daha kararlý çalýþmasý için final ekledik
	@Override
	public void removeAdvertisement(final Advertisement advertisement) {

		try {
			// eger advertisement bellekte içeriyorsa sil
			// Yani hafýzasýnda içeriyorsa ifin içi true ile calýsyordu
			// içine gir ve verriyi sil
			if (this.entityManager.contains(advertisement)) {
				this.entityTransaction.begin();

				this.entityManager.remove(advertisement);

				this.entityTransaction.commit();
			} else {
				// eNTÝTYMANAGER HAFIZASINDA ÝÇERMÝYORSA VERÝYÝ BUL VE SÝL
				Advertisement deleteAdvertisement = this.findById(advertisement.getAdvertisementId());
				this.entityTransaction.begin();

				// YUKARIDAKI BULDUGUMUZ VERIYI DELETEadvertisement degiþkenýne aktardýk ve
				// onuda sýldýk
				this.entityManager.remove(deleteAdvertisement);

				this.entityTransaction.commit();
			}

		} catch (RuntimeException e) {
			logger.error("Delete yapýlýrken hata meydana geldi..HATA:" + e);

			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {

				logger.error("Delete rollback yapýlýrken hata meydana geldi..HATA: " + e2);
			}
		}

	}

	@Override
	public Advertisement findById(final Integer advertisementId) {

		Advertisement advertisement = null;
		// eger advertisement bulunamazsa null degeri gönderecek bulursa advertisementin
		// bulunmus degerini yollayacagýz...

		try {

			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findById",
					Advertisement.class);
			typedQuery.setParameter("advertisementId", advertisementId);
			advertisement = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			logger.error("advertisementId ile bulma yapýlýrken hata meydana geldi..HATA: " + e);

		}

		return advertisement;
	}

	@Override
	public Advertisement findByUserName(final String userName) {

		Advertisement advertisement = null;

		try {
			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findByUserName",
					Advertisement.class);
			typedQuery.setParameter("userName",userName);
			advertisement = typedQuery.getSingleResult();

		} catch (NoResultException e) {

			logger.error("findByUserName Bulunurken hata meydana geldi....HATA: " + e);
		}

		return advertisement;
	}

	@Override
	public List<Advertisement> findAdvertisements() {

		List<Advertisement> advertisements = null;
		try {
			TypedQuery<Advertisement> typedQuery = entityManager.createNamedQuery("Advertisement.findAdvertisements",
					Advertisement.class);
			advertisements = typedQuery.getResultList();
		} catch (Exception e) {
			logger.error("findAdvertisements Bulunurken hata meydana geldi....HATA: " + e);
		}

		return advertisements;
	}

	@Override
	public List<Advertisement> findAdvertisementsEntities(final Integer firstResult, final Integer maxResult) {
		List<Advertisement> advertisements = null;

		try {
			TypedQuery<Advertisement> typedQuery = this.entityManager
					.createNamedQuery("Advertisement.findAdvertisements", Advertisement.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);

			advertisements = typedQuery.getResultList();

		} catch (NoResultException e) {
			logger.error("findAdvertisements first ve max aralýgý Bulunurken hata meydana geldi....HATA: " + e);
		}

		return advertisements;
	}

}
