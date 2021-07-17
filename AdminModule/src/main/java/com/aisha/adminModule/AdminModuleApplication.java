package com.aisha.adminModule;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class AdminModuleApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(AdminModuleApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("manal"));
	}

}
