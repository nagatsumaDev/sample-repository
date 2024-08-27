package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.MUser;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	/** 全件検索 */
	public List<MUser> findAll() {
		return userRepository.findAll();
	}
	
	public MUser findByUserId(String userId) {
		Optional<MUser> mUserOpt = userRepository.findById(userId);
		return mUserOpt.orElse(null);
	}
	
	public List<MUser> fineByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public void update(MUser mUser) {
		userRepository.save(mUser);
	}
}
