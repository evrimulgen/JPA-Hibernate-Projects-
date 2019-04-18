package com.proje.service.impl;

import com.proje.model.UserDetail;
import com.proje.repository.UserDetailRepository;
import com.proje.repository.impl.UserDetailRepositoryImpl;
import com.proje.service.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService {

	private UserDetailRepository userDetailRepository = new UserDetailRepositoryImpl();

	@Override
	public void saveUserDetail(final UserDetail userDetail) {

		this.userDetailRepository.saveUserDetail(userDetail);

	}

	@Override
	public void updateUserDetail(final UserDetail userDetail) {

		this.userDetailRepository.updateUserDetail(userDetail);
	}

	@Override
	public void removeUserDetail(final UserDetail userDetail) {

		this.userDetailRepository.removeUserDetail(userDetail);
	}

	@Override
	public UserDetail findByUsurname(final String userName) {

		UserDetail userDetail = this.userDetailRepository.findByUsurname(userName);
		return userDetail;
	}

	@Override
	public UserDetail findById(final Integer userDetailId) {

		UserDetail userDetail = this.userDetailRepository.findById(userDetailId);

		return userDetail;
	}

	@Override
	public UserDetail findWithAddressByUserName(final String userName) {

		UserDetail userDetail = this.userDetailRepository.findWithAddressByUserName(userName);
		return userDetail;
	}

	@Override
	public UserDetail findWithAdvertisementByUserName(final String userName) {

		UserDetail userDetail = this.userDetailRepository.findWithAdvertisementByUserName(userName);

		return userDetail;
	}

}
