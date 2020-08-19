package com.isg.poc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.isg.poc.mode.UserModel;
import com.isg.poc.repo.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/add/{id}/{name}")
	public UserModel addUser(@PathVariable String id, @PathVariable String name) {
		UserModel user = new UserModel();
		user.setUser_id(id);
		user.setUser_name(name);
		user.setCompany("KPIT");
		userRepo.save(user);
		return userRepo.findById(id);
	}
	
	@GetMapping("/getAll")
	public Map<String, UserModel> getAll(){
		return userRepo.findall();
	}
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable String id){
		userRepo.delete(id);
	}
}
