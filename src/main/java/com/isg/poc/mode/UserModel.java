package com.isg.poc.mode;

import java.io.Serializable;

public class UserModel implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2063215284703254792L;
	private String user_id;
	private String user_name;
	private String company;

	public UserModel() {
	}

	public UserModel(String user_id, String user_name, String company) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.company = company;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
