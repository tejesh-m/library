package com.digitalbook.author.client;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.digitalbook.author.entity.Author;

@FeignClient("Reader")
public interface AuthorClient {
	
	@GetMapping("/api/v1/digitalbooks/author/getAuthor/{authorId}")
	Optional<Author> getAuthorByID(@PathVariable int authorId);
		
	}

