package com.digitalbook.reader.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BuyBook {
	@Column(name="Buyer_Name")
	private String name;
	@Column(name="Book_Name")
	private String bookName;
	@Column(name="Buyer_Emailid")
	private String emailId;
	@Id
	private int bookId;
	private int generatedId;
	//@Temporal(TemporalType.TIMESTAMP)
    private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getGeneratedId() {
		return generatedId;
	}
	public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
	}
	public BuyBook() {
		super();
	}
	
	
	
	public BuyBook(String name, String bookName, String emailId, int bookId, int generatedId, String date) {
		super();
		this.name = name;
		this.bookName = bookName;
		this.emailId = emailId;
		this.bookId = bookId;
		this.generatedId = generatedId;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
