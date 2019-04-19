package com.proje.service;

import java.util.List;

import com.proje.model.Advertisement;
/**
 * @author MetinKalinsaz
 */
public interface AdvertisementService {

	void saveAdvertisement(Advertisement advertisement);

	void updateAdvertisement(Advertisement advertisement);

	void removeAdvertisement(Advertisement advertisement);

	Advertisement findById(Integer advertisementId);

	Advertisement findByUserName(String userName);

	List<Advertisement> findAdvertisements();

	List<Advertisement> findAdvertisementsEntities(Integer firstResult, Integer maxResult);

}
