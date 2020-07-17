package com.mobileapp.api.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	Environment environment;
	@Autowired
	public WebSecurity(Environment environment) {
		this.environment=environment;
	}
	public void configure(HttpSecurity http) throws Exception{
		//disable csrf protection 
		http.csrf().disable();
		// get http requests from zuul gateway only
		http.authorizeRequests().antMatchers("/**").hasIpAddress(this.environment.getProperty("gateway.ip"));
		// to enable get into h2-console
		http.headers().frameOptions().disable();
	}

}
