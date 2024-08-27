package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.MUser;

@Repository
public interface UserRepository extends JpaRepository<MUser, String> {
	
	List<MUser> findByUserName(String userName);
}
