package com.proje.repository;

import java.util.List;

import com.proje.model.Advertisement;

public interface AdvertisementRepository {

	void saveAdvertisement(Advertisement advertisement);

	void updateAdvertisement(Advertisement advertisement);

	void removeAdvertisement(Advertisement advertisement);

	Advertisement findById(Integer advertisementId);

	Advertisement findByUserName(String userName);

	List<Advertisement> findAdvertisements();

	List<Advertisement> findAdvertisementsEntities(Integer firstResult, Integer maxResult);

}
