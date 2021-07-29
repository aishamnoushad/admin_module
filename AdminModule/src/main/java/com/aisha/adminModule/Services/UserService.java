package com.aisha.adminModule.Services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aisha.adminModule.Entity.User;
import com.aisha.adminModule.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User AddUserRequest(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    user.setIsApproved(false);
	    user.setCreated_at(LocalDateTime.now());
	    user.setUpdated_at(LocalDateTime.now());
		return userRepository.saveAndFlush(user);
	}

}
