package com.edu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsermailid(String usermailid);

	public User getUserByUserid(Integer userid);
	

}
