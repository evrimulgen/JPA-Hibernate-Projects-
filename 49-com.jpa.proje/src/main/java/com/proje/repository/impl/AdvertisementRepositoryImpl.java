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

			logger.error("Persist yap�l�rken hata meydana geldi..HATA: " + e);

			try {

				this.entityTransaction.rollback();
			} catch (RollbackException e2) {

				logger.error("Insert Rollback yap�l�rken hata meydana geldi..HATA: " + e2);
			}
		}

	}

	@Override
	public void updateAdvertisement(final Advertisement advertisement) {

		try {

			this.entityTransaction.begin();

			this.entityManager.merge(advertisement);
			// tablolar�m�z g�ncellendiginde commit yap�ld�g�nda g�ncellenmi� sekliyle geri
			// almam�z� sagl�yor...
			this.entityManager.flush();

			this.entityTransaction.commit();

		} catch (RuntimeException e) {

			logger.error("G�ncelleme yap�l�rken hata meydana geldi..HATA:" + e);

			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {

				logger.error("Update rollback yap�l�rken hata meydana geldi..HATA: " + e2);
			}
		}

	}

	// degerini degi�tirmedigimiz i�in daha kararl� �al��mas� i�in final ekledik
	@Override
	public void removeAdvertisement(final Advertisement advertisement) {

		try {
			// eger advertisement bellekte i�eriyorsa sil
			// Yani haf�zas�nda i�eriyorsa ifin i�i true ile cal�syordu
			// i�ine gir ve verriyi sil
			if (this.entityManager.contains(advertisement)) {
				this.entityTransaction.begin();

				this.entityManager.remove(advertisement);

				this.entityTransaction.commit();
			} else {
				// eNT�TYMANAGER HAFIZASINDA ��ERM�YORSA VER�Y� BUL VE S�L
				Advertisement deleteAdvertisement = this.findById(advertisement.getAdvertisementId());
				this.entityTransaction.begin();

				// YUKARIDAKI BULDUGUMUZ VERIYI DELETEadvertisement degi�ken�ne aktard�k ve
				// onuda s�ld�k
				this.entityManager.remove(deleteAdvertisement);

				this.entityTransaction.commit();
			}

		} catch (RuntimeException e) {
			logger.error("Delete yap�l�rken hata meydana geldi..HATA:" + e);

			try {
				this.entityTransaction.rollback();
			} catch (RollbackException e2) {

				logger.error("Delete rollback yap�l�rken hata meydana geldi..HATA: " + e2);
			}
		}

	}

	@Override
	public Advertisement findById(final Integer advertisementId) {

		Advertisement advertisement = null;
		// eger advertisement bulunamazsa null degeri g�nderecek bulursa advertisementin
		// bulunmus degerini yollayacag�z...

		try {

			TypedQuery<Advertisement> typedQuery = this.entityManager.createNamedQuery("Advertisement.findById",
					Advertisement.class);
			typedQuery.setParameter("advertisementId", advertisementId);
			advertisement = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			logger.error("advertisementId ile bulma yap�l�rken hata meydana geldi..HATA: " + e);

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
			logger.error("findAdvertisements first ve max aral�g� Bulunurken hata meydana geldi....HATA: " + e);
		}

		return advertisements;
	}

}
