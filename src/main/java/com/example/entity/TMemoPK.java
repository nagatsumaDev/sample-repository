package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

// Spring Data JPAのアノテーション
@Embeddable
public class TMemoPK implements Serializable {
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "memo_id")
	private Integer memoId;
	
	public String getUserId() {
		return userId;
	}

	public Integer getMemoId() {
		return memoId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setMemoId(Integer memoId) {
		this.memoId = memoId;
	}

}
