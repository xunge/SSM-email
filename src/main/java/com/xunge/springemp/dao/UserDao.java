package com.xunge.springemp.dao;


import com.xunge.springemp.pojo.User;

public interface UserDao {
	public User findByName(String username) throws Exception;
	
	public int findByEmail(String email) throws Exception;

	public int findByUser(String user) throws Exception;
	
	public boolean addUser(User user) throws Exception;

	public boolean activeUser(String code) throws Exception;

	public int findState(String username) throws Exception;

}
