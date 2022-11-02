package com.digitalbook.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbook.author.entity.Author;
import com.digitalbook.author.entity.AuthorBook;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	 @Query("select u.password from Author u where u.username=?1")
	  public String filterByPassword(String username);

	
	 

}
