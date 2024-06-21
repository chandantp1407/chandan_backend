package com.excelsoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.excelsoft.config.UserInfoUserDetails;
import com.excelsoft.entity.UserEntity;
import com.excelsoft.repository.UserRepo;

@Service
public class UserEntityDetailService implements UserDetailsService{

@Autowired
private UserRepo userRepo;

@Autowired
private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> userInfo = userRepo.findByUsername(username);
		
		return userInfo.map(UserInfoUserDetails::new)
		.orElseThrow(()-> new UsernameNotFoundException("user not found"));
	}
	
	public String addUser(UserEntity userEntity) {
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		userRepo.save(userEntity);
		return "user added";
	}

}
