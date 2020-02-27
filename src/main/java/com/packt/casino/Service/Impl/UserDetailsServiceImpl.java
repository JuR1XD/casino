package com.packt.casino.Service.Impl;

import com.packt.casino.domain.Authority;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService
{

	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		User user = userService.findUserByEmail(email);
		List<GrantedAuthority> authorities = getUserAuthority(user.getAuthorities());
		return buildUserForAuthentication(user, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Authority> userAuthorities)
	{
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Authority authority : userAuthorities)
		{
			authorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(authorities);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities)
	{
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.isActivated(), true, true, true, authorities);
	}
}
