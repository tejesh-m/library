package com.digitalbook.reader.repository;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.digitalbook.reader.entity.Book;

@Repository
public class Book1Rpository { 
	
	public Book saveBookInDb(Book book) throws SQLException{
		System.out.println("book saved in database : "+book);
		
		int createdId = 199;
		Book.setId(createdId);
		System.out.println("Save bookId in database");
		return book;
	}

}
