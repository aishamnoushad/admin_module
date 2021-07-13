package com.aisha.adminModule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aisha.adminModule.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
