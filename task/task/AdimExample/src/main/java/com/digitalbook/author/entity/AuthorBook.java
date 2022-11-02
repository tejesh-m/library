package com.digitalbook.author.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthorBook {
	@Id
	private int bookId;
	private String bookTitle;
	private String bookCategory;
	private String bookPrice;
	private String bookAuthor;
	private String bookPublisher;
	private String Date;
	private String bookContent;
	private boolean bookStatus;
	public AuthorBook() {
		super();
	}
	public AuthorBook(int bookId, String bookTitle, String bookCategory, String bookPrice, String bookAuthor,
			String bookPublisher, String date, String bookContent, boolean bookStatus) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookCategory = bookCategory;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		Date = date;
		this.bookContent = bookContent;
		this.bookStatus = bookStatus;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
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
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	public boolean getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(boolean bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	

}
