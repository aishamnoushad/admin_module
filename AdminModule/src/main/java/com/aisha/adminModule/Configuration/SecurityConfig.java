package com.aisha.adminModule.Configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.aisha.adminModule.handlers.AdminAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	 AuthenticationFailureHandler  MyAuthenticationFailureHandler;
	@Autowired
	AdminAuthenticationSuccessHandler adminAuthenticationSuccessHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider());
    	try {
			auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
        .authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN", "ADMIN_MANAGER")
        .and()
        .authorizeRequests().antMatchers("/login", "/resource/**").permitAll()
        .and()
        .formLogin()
        .loginPage("/login")
        .failureHandler(MyAuthenticationFailureHandler)
        .successHandler(adminAuthenticationSuccessHandler)
        .defaultSuccessUrl("/dashboard")
        .and().csrf().disable();
//        .usernameParameter("username").passwordParameter("password").permitAll()
//        .loginProcessingUrl("/login")
//        .successForwardUrl("/dashboard")
//        .failureUrl("/login?error")
//        .failureHandler(null);
		
//        .and()
//        .logout().logoutSuccessUrl("/logout").permitAll()
//        .and()
//        .csrf().disable();
		
	}
}
