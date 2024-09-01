package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TMemo;
import com.example.entity.TMemoPK;

@Repository
public interface MemoRepository extends JpaRepository<TMemo, TMemoPK> {

	List<TMemo> findByUserIdOrderByMemoId(String userId);
}
