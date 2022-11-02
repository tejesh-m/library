package com.digitalbook.reader.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.reader.entity.Book;
import com.digitalbook.reader.entity.BuyBook;
import com.digitalbook.reader.repository.BookRepository;
@Service
public class BookService {
	
	@Autowired
	public BookRepository repo;
	
	public List<Book> fetchAllBooks() 
	{
		return repo.findAll();
	}
	//getting books by filtering category,author,price and publisher
	public List<Book> getAllBooks(String category, String author, long price, String publisher) 
	{
		List<Book> allBooks=repo.findAll();
		System.out.println("All books" +allBooks  + "size  "+ allBooks.size());
		if(category !=null && author !=null && price !=0 && publisher !=null)
		{
			System.out.println("inside if block");
			allBooks=allBooks.stream()
						.filter(bo ->bo.getBookCatogiry().equals(category))
						.filter(bo ->bo.getBookAuthor().equals(author))
						.filter(bo ->bo.getBookPrice() <= price)
						.filter(bo ->bo.getBookPublisher().equals(publisher))
						.collect(Collectors.toList());
		}
		System.out.println("allbooks "+allBooks);
		return allBooks;
	}
	public String saveData(Book books) {
		
		 repo.save(books);
		 return "book added successfully";
	}
	
	

}
