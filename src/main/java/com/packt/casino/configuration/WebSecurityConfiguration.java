package com.packt.casino.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;


	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http)throws Exception
	{
		String loginpage = "/login";
		String logoutpage = "/logout";
		String admin = "ROLE_ADMIN";
		String user = "ROLE_USER";

		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers(loginpage).permitAll()
				.antMatchers("/games").permitAll()
				.antMatchers("/search").permitAll()
				.antMatchers("/username").permitAll()
				.antMatchers("/success").anonymous()
				.antMatchers("/addGame").hasAuthority(admin)
				.antMatchers("/signIn").anonymous()
				.antMatchers("/login").anonymous()
				.antMatchers("/editUser").hasAnyAuthority(user, admin)
				.antMatchers("/editPassword").hasAnyAuthority(user, admin)
				.antMatchers("/account/**").hasAnyAuthority(user, admin)
				.antMatchers("/account/admin/**").hasAuthority(admin).anyRequest()
				.authenticated().and().csrf().disable().formLogin()
				.loginPage(loginpage).failureUrl("/login?error=true")
				.defaultSuccessUrl("/account")
				.usernameParameter("email")
				.passwordParameter("password")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher(logoutpage))
				.logoutSuccessUrl(loginpage).and().exceptionHandling();
				//.accessDeniedPage("/");
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.
				ignoring()
				.antMatchers("/userTest/**");
	}
}
