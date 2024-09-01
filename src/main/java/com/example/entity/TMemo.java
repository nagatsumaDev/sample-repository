package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

// Spring Data JPAのアノテーション
@Entity
@Table(name = "t_memo")
@IdClass(TMemoPK.class)
public class TMemo {
	
	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Id
	@Column(name = "memo_id")
	private Integer memoId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "text")
	private String text;
	
	public TMemo() {
	}
	
	public TMemo(int number) {
		this.userId = "";
		this.title = "";
		this.text = "";
		this.memoId = number;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getMemoId() {
		return memoId;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setMemoId(Integer memoId) {
		this.memoId = memoId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
