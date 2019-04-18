package com.proje.service;

import com.proje.model.UserDetail;

public interface UserDetailService {

	void saveUserDetail(UserDetail userDetail);

	void updateUserDetail(UserDetail userDetail);

	void removeUserDetail(UserDetail userDetail);

	UserDetail findByUsurname(String userName);

	UserDetail findById(Integer userDetailId);

	UserDetail findWithAddressByUserName(String userName);

	UserDetail findWithAdvertisementByUserName(String userName);

}
