package com.aisha.adminModule.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.aisha.adminModule.Entity.User;
import com.aisha.adminModule.Services.AdminUserDetailService;
import com.aisha.adminModule.handlers.ActiveUserStore;
import com.aisha.adminModule.handlers.MyAuthenticationFailureHandler;

@Configuration
public class AppConfig {

	@Bean
    public UserDetailsService userDetailsService() {
        return new AdminUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
    public User user() {
        return new User();
    }
    @Bean
    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return new MyAuthenticationFailureHandler();
    }
//    @Bean
//    public ActiveUserStore activeUserStore(){
//        return new ActiveUserStore();
//    }
	
}
