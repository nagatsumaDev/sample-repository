package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.TMemo;
import com.example.repository.MemoRepository;

@Service
public class MemoService {
	
	@Autowired
	public MemoRepository memoRepository;
	
	/** 全件検索 */
	public List<TMemo> findAll() {
		return memoRepository.findAll();
	}
	
	public List<TMemo> fineByUserId(String userId) {
		return memoRepository.findByUserIdOrderByMemoId(userId);
	}
	
	public void update(TMemo tMemo) {
		memoRepository.save(tMemo);
	}
}
