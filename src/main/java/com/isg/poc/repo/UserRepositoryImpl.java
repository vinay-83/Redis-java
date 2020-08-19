package com.isg.poc.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.isg.poc.mode.UserModel;

@Repository
public class UserRepositoryImpl implements UserRepository{

	
	private RedisTemplate<String, UserModel> redisTemplete;
	private HashOperations hashOperations;
	
	public UserRepositoryImpl(RedisTemplate<String, UserModel> redisTemplete) {
		this.redisTemplete=redisTemplete;
		hashOperations = redisTemplete.opsForHash();
	}
	@Override
	public void save(UserModel user) {
		hashOperations.put("USERNEW", user.getUser_id(), user);
		
	}

	@Override
	public Map<String, UserModel> findall() {
		
		return hashOperations.entries("USERNEW");
	}

	@Override
	public UserModel findById(String id) {
		// TODO Auto-generated method stub
		return (UserModel) hashOperations.get("USERNEW", id);
	}

	@Override
	public void update(UserModel user) {
		save(user);
		
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("USERNEW", id);
		
	}

}
