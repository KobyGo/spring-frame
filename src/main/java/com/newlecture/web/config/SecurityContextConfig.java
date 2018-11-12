package com.newlecture.web.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@ComponentScan("com.newlecture.web.config")
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BasicDataSource dataSource;
	
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.headers()
			.frameOptions()
			.sameOrigin()
			.and() //구분해줄때 and 
		.csrf().disable() //CSRF공격을 막아보자
		.authorizeRequests() 
			.antMatchers("/admin/**").hasRole("ADMIN, ACADEMY")
			.anyRequest().permitAll() //위에뺀 나머진 허용
		.and()
		.formLogin()
			.defaultSuccessUrl("/index")
			.loginPage("/member/login") //get
			.loginProcessingUrl("/member/login") //post
 			.successHandler(successHandler)
			.and()
		.logout()
			.logoutUrl("/member/logout")
			.logoutSuccessUrl("/index");
		 
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		 *2가지 방법 [jdbc] 
		 *1. 내가 쿼리를 만들어서 제공 [usersByUsernameQuery]
		 *2. 약속된 인터페이스로 구현된 사용자정보 제공 [authoritiesByUsernameQuery]
		 */
		
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select id, pwd password, 1 enabled from Member where id = ?")
			.authoritiesByUsernameQuery("select memberId id, roleName authority from MemberRole where memberId = ?")
			.passwordEncoder(new BCryptPasswordEncoder());
		
		
		/*
		UserBuilder users = User.builder();
		auth
		   .inMemoryAuthentication()
		   .withUser(users
				   		.username("newlec")
				   		.password("111")
				   		.roles("ADMIN"))
		   .withUser(users
			   		.username("dragon")
			   		.password("111")
			   		.roles("TEACHER")
		);
		*/
		   
		   //$2a$10$zpE1ThBwaRlZM2uMMShksurhrRjw/QtUZXB4cfON4.owLTFqkyQx.
	}
}
