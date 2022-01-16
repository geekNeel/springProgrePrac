package com.example.spd.springpostgredocker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			//Cross-site request forgery
			.csrf().disable() // .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())//.disable()
			//.and()
			.authorizeRequests()
			.antMatchers("/public/**").permitAll()
			.antMatchers(HttpMethod.POST,"/healthcare/patients").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
		
		//CSRF
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("neel").password( this.passwordEncoder().encode("password")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("doe")).roles("NORMAL");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
}
