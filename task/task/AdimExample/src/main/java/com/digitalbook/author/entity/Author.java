package com.digitalbook.author.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorId;
	
	public Author() {
		super();
	}
	public Author(int authorId, String username, String password, String emailId) {
		super();
		this.authorId = authorId;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
	}
	
	public Author(String string, int i) {
		// TODO Auto-generated constructor stub
	}

	private String username;
	private String password;
	private String emailId;
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public static void add(Author author) {
		// TODO Auto-generated method stub
		
	}

}
