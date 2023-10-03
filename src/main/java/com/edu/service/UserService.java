package com.edu.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.edu.dao.Seller;
import com.edu.dao.User;

public interface UserService {

	public User addUser(User user);

	public List<User> getAllUser();

	public void signupUser(@Valid User user);

	public User loginUser(String usermailid, String userpassword);

	public User getUserByUserid(Integer userid);

}
