package com.packt.casino.configuration;

import com.packt.casino.Service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http)throws Exception
	{
		String loginpage = "/login";
		String logoutpage = "/logout";

		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers(loginpage).permitAll()
				.antMatchers("/games").permitAll()
				.antMatchers("/signIn").permitAll()
				.antMatchers("/account/**").hasAuthority("ROLE_USER")
				.antMatchers("/admin/account/**").hasAuthority("ROLE_ADMIN").anyRequest()
				.authenticated().and().csrf().disable().formLogin()
				.loginPage(loginpage).failureUrl("/login?error=true")
				.defaultSuccessUrl("/account")
				.usernameParameter("email")
				.passwordParameter("password")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher(logoutpage))
				.logoutSuccessUrl(loginpage).and().exceptionHandling()
				.accessDeniedPage("/home");
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.
				ignoring()
				.antMatchers("/userTest/**");
	}




	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
