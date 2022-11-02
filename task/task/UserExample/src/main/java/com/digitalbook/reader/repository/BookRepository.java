package com.digitalbook.reader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbook.reader.entity.Book;



public interface BookRepository extends JpaRepository<Book, Integer>
{

	@Query("select b.bookName from Book b where b.bookId=?1")
	public String filterByBookId(int bookId);
	
    
}
