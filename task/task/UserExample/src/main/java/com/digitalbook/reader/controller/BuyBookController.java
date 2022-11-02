package com.digitalbook.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbook.reader.entity.Book;
import com.digitalbook.reader.entity.BuyBook;
import com.digitalbook.reader.service.BuyBookService;
@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BuyBookController {
	@Autowired
	public BuyBookService buyBookService;
	
	@Autowired
	RestTemplate rest;
	
	@Autowired
	private KafkaTemplate<String, Book> kafkaTemplate;
    
	private static final String Topic ="topic-demo";

	private static final Book Message = null;
	
	@GetMapping("/reader")
	public String getreader()
	{
		String url="http://localhost:8082/api/v1/digitalbooks/authors";
		String result = rest.getForObject(url,String.class);
		return "this is reader page" +result;
		
	}
	//reader can buy a book
	@PostMapping("/books/buy")
	public String buyBook(@RequestBody BuyBook buyBooks)
	{
		System.out.println("controller");
		return  buyBookService.saveData(buyBooks);
	}
	
	@GetMapping("/publish")
	public String publishBook(@PathVariable String title) {
		int id=(int)(Math.floor(Math.random()*100));
		kafkaTemplate.send(Topic, new Book(id,"java","sunmicrosystems",200));
		return "Published successfully";
	}
	@GetMapping("/publish/{Message}")
	public String publishMessage(@PathVariable("message")final String message)
	{
		return " The Message  was published Successfully!";
	}
	
	//reader can find all purchased books
	@GetMapping("/books/readers")
	public List<BuyBook> getAllPurchasedBooks(@RequestParam String email)
	{
		
		return buyBookService.getAllPurchasedBooks(email);
	}
	
	//reader can read a book by providing emailid and bookid
	@GetMapping("/books/{emailId}/books/{bookId}")
    public String getPurchasedId(@PathVariable String emailId, @PathVariable int bookId)
	{
        return buyBookService.getBookName(emailId,bookId);
    }
	
	//reader can find book by paymentid
	@PostMapping("/books/{emailId}/books")
    public String getPurchasedBookById(@PathVariable String emailId, @RequestParam int generatedId) 
	{
        return buyBookService.getPurchasedBookByPid(emailId,generatedId);
    }
	
	
	//Checking refund is applicable or not
	@PostMapping("/reader/{emailId}/books/{bookId}/refund")
	    public String checkIfRefundIsValid(@PathVariable String emailId, @PathVariable int bookId)
	    {
	        return buyBookService.checkIfRefundIsValid(emailId,bookId);
	    }	
	

}
