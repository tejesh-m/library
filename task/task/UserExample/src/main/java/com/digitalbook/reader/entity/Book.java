package com.digitalbook.reader.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Book {
	@Id
	@Column(name="Book_Id")
	private int bookId;
	@Column(name="Book_Name")
	private String bookName;
	@Column(name="Book_Author")
	private String bookAuthor;
	@Column(name="Book_Publisher")
	private String bookPublisher;
	@Column(name="Book_Price")
	private long bookPrice;
	@Column(name="Book_Date")
	private String date;
	@Column(name="Book_Category")
	private String bookCategory;
	
	public Book(int id, String string, String string2, int i)
	{
		
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public long getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(long bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBookCatogiry() {
		return bookCategory;
	}
	public void setBookCatogiry(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public Book(int bookId, String bookName, String bookAuthor, String bookPublisher, long bookPrice, String date,
			String bookCatogiry) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
		this.date = date;
		this.bookCategory = bookCatogiry;
	}
	public static void setId(int createdId) {
		// TODO Auto-generated method stub
		
	}
	

}
