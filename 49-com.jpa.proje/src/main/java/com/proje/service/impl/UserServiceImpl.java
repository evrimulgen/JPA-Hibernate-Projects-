package com.proje.service.impl;

import java.util.List;

import com.proje.model.User_My;
import com.proje.model.UserInfo;
import com.proje.repository.UserRepository;
import com.proje.repository.impl.UserRepositoryImpl;
import com.proje.service.UserService;
/**
 * @author MetinKalinsaz
 */
public class UserServiceImpl implements UserService {

	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public void saveUser(final User_My user_My) {

		this.userRepository.saveUser(user_My);
	}

	@Override
	public void updateUser(final User_My user_My) {

		this.userRepository.updateUser(user_My);
	}

	@Override
	public void removeUser(final User_My user_My) {

		this.userRepository.removeUser(user_My);
	}

	@Override
	public User_My findById(final Integer userId) {

		User_My user_My = this.userRepository.findById(userId);
		return user_My;
	}

	@Override
	public User_My findByUserName(final String userName) {

		User_My user_My = this.userRepository.findByUserName(userName);

		return user_My;
	}

	@Override
	public User_My findWithUserDetailByUsername(final String userName) {

		User_My user_My = this.userRepository.findWithUserDetailByUsername(userName);
		return user_My;
	}

	@Override
	public List<User_My> findUsers() {

		List<User_My> user_Mies = this.userRepository.findUsers();

		return user_Mies;
	}

	@Override
	public List<User_My> findUsers(final int firstResult, final int maxResult) {

		List<User_My> user_Mies = this.userRepository.findUsers(firstResult, maxResult);

		return user_Mies;
	}

	@Override
	public Long findUserCount() {

		Long longs = this.userRepository.findUserCount();

		return longs;
	}

	@Override
	public UserInfo findUserInfoByUserName(final String userName) {

		UserInfo userInfo = this.userRepository.findUserInfoByUserName(userName);

		return userInfo;
	}

}
