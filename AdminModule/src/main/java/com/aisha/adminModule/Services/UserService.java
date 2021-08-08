package com.aisha.adminModule.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aisha.adminModule.Entity.User;
import com.aisha.adminModule.Repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Transactional
	public User AddUserRequest(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    user.setIsApproved(false);
	    user.setRole(3);
	    user.setCreated_at(LocalDateTime.now());
	    user.setUpdated_at(LocalDateTime.now());
		return userRepository.saveAndFlush(user);
	}
	
	public List<User> getAllUserRequest(){
		return userRepository.findAll().stream().filter(t->!t.getIsApproved()).collect(Collectors.toList());
		
	}
	
	public void updateResetPasswordToken(String token, String email) throws AccountNotFoundException {
		User user = userRepository.findByEmail(email);
        if (user != null) {
        	user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new AccountNotFoundException("Could not find any customer with the email " + email);
        }
    }
     
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }
     
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
         
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }

}
