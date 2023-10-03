package com.edu.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Seller;
import com.edu.dao.User;
import com.edu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository userRepository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void signupUser(@Valid User user) {
		// Encrypt the seller's password before saving it
        user.setUserpassword(user.getUserpassword());
        userRepository.save(user);
		
	}

	@Override
	public User loginUser(String usermailid, String userpassword) {
		User user = userRepository.findByUsermailid(usermailid);
		System.out.println(user);
        if (user != null && userpassword.equals(user.getUserpassword()) ) {
            return user;
        }

        return null;
    }

	@Override
	public User getUserByUserid(Integer userid) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userid).get();
		return user;
	}

	

	

	

}
