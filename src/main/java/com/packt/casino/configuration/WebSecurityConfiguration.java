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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
		String user = "ROLE_USER";
		String admin = "ROLE_ADMIN";

		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers(loginpage).permitAll()
				.antMatchers("/games").permitAll()
				.antMatchers("/games/game").permitAll()
				.antMatchers("/search").permitAll()
				.antMatchers("/signIn").anonymous()
				.antMatchers("/username").permitAll()
				.antMatchers("/success").anonymous()
				.antMatchers("/login").anonymous()
				.antMatchers("/account/**").hasAnyAuthority(user, admin)
				.antMatchers("/admin/**").hasAuthority(admin)
				.antMatchers("/admin/allUsers").hasAuthority(admin).anyRequest()
				.authenticated().and().csrf().disable().formLogin()
				.loginPage(loginpage).failureUrl("/login?error=true")
				.defaultSuccessUrl("/account")
				.usernameParameter("email")
				.passwordParameter("password")
				.and().logout().logoutSuccessUrl("/login?logout=true")
				.logoutRequestMatcher(new AntPathRequestMatcher(logoutpage))
				.and().exceptionHandling()
				.accessDeniedPage("/home");
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.
				ignoring()
				.antMatchers("/userTest/**");
	}
}
