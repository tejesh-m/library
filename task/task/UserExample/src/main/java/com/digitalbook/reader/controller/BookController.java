package com.digitalbook.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.reader.entity.Book;
import com.digitalbook.reader.entity.BuyBook;
import com.digitalbook.reader.service.BookService;
@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	public BookService bookService;
	
	@PostMapping("/create")
	public String buyBook(@RequestBody Book books)
	{
		System.out.println("controller");
		return  bookService.saveData(books);

	}
	//User can fetch all books
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookService.fetchAllBooks();
	}
	
	//User can search books by providing category,author,price,publisher
	@GetMapping("/search") 
	public List<Book> getBooks(
			  @RequestParam String category,
			  @RequestParam String author,
			  @RequestParam long price,
			  @RequestParam String publisher)
	  { 
		
		  return bookService.getAllBooks(category,author,price,publisher); 
	  }
	
		/*
		 * @PostMapping("author/{authorId}/books") public String
		 * accountCreation(@PathVariable AuthorAccountCreation author) { return
		 * bookService.saveData(author); }
		 */
	
	
	

}
