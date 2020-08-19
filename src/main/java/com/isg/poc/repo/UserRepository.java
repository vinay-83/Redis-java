package com.isg.poc.repo;

import java.util.Map;

import com.isg.poc.mode.UserModel;

public interface UserRepository{

	void save(UserModel user);
	Map<String, UserModel> findall();
	UserModel findById(String id);
	void update(UserModel user);
	void delete(String id);
}
