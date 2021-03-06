
package com.zeedlabs.productmanager.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.zeedlabs.productmanager.crud.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {

		return new CustomUserDetailsService();
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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/login").hasAnyAuthority("ICT", "Operations", "Engagement", "ADMIN","FinCon","CreditAndRisk")
				.antMatchers("loan/new").hasAuthority("Engagement")
				.antMatchers("/register/new").hasAnyAuthority("ADMIN")
				.antMatchers("/").hasAnyAuthority("ADMIN", "ICT")
				.antMatchers("/").hasAnyAuthority("ADMIN")
				.antMatchers("/").hasAuthority("ADMIN")
				.and().formLogin().loginPage("/login").usernameParameter("email")
				.defaultSuccessUrl("/list_users").permitAll().and().logout().logoutSuccessUrl("/").permitAll();

	
	}
}
