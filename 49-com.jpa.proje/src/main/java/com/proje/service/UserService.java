package com.proje.service;

import java.util.List;

import com.proje.model.User_My;
import com.proje.model.UserInfo;

public interface UserService {

	void saveUser(User_My user_My);

	void updateUser(User_My user_My);

	void removeUser(User_My user_My);

	User_My findById(Integer userId);

	User_My findByUserName(String userName);

	User_My findWithUserDetailByUsername(String userName);

	List<User_My> findUsers();

	List<User_My> findUsers(int firstResult, int maxResult);

	Long findUserCount();

	UserInfo findUserInfoByUserName(String userName);
}
