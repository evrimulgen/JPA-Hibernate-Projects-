package com.proje.service.impl;

import java.util.List;

import com.proje.model.Advertisement;
import com.proje.repository.AdvertisementRepository;
import com.proje.repository.impl.AdvertisementRepositoryImpl;
import com.proje.service.AdvertisementService;
/**
 * @author MetinKalinsaz
 */
public class AdvertisementServiceImpl implements AdvertisementService {

	private AdvertisementRepository advertisementRepository = new AdvertisementRepositoryImpl();

	@Override
	public void saveAdvertisement(final Advertisement advertisement) {

		this.advertisementRepository.saveAdvertisement(advertisement);

	}

	@Override
	public void updateAdvertisement(final Advertisement advertisement) {

		this.advertisementRepository.updateAdvertisement(advertisement);
	}

	@Override
	public void removeAdvertisement(final Advertisement advertisement) {

		this.advertisementRepository.removeAdvertisement(advertisement);
	}

	@Override
	public Advertisement findById(final Integer advertisementId) {

		Advertisement advertisement = this.advertisementRepository.findById(advertisementId);

		return advertisement;
	}

	@Override
	public Advertisement findByUserName(final String userName) {

		Advertisement advertisement = this.advertisementRepository.findByUserName(userName);
		return advertisement;
	}

	@Override
	public List<Advertisement> findAdvertisements() {

		List<Advertisement> advertisements = this.advertisementRepository.findAdvertisements();

		return advertisements;
	}

	@Override
	public List<Advertisement> findAdvertisementsEntities(final Integer firstResult, final Integer maxResult) {

		List<Advertisement> advertisements = this.findAdvertisementsEntities(firstResult, maxResult);
		return advertisements;
	}

}
