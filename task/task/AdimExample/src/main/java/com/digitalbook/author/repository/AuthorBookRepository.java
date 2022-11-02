package com.digitalbook.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbook.author.entity.AuthorBook;

public interface AuthorBookRepository extends JpaRepository<AuthorBook, String>{

}
