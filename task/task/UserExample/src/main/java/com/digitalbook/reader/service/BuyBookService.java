package com.digitalbook.reader.service;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.reader.entity.Book;
import com.digitalbook.reader.entity.BuyBook;
import com.digitalbook.reader.repository.BookRepository;
import com.digitalbook.reader.repository.BuyBookRepository;

@Service
public class BuyBookService {
	@Autowired
	public BuyBookRepository buyRepo;
	@Autowired
	public BookRepository bookRepo;

	// Saving buy book details
	public String saveData(BuyBook book) {
		int z = book.getBookId();
		System.out.println("book id" + z);
		String bookName = bookRepo.filterByBookId(z);
		System.out.println("book name" + bookName);
		int a = ThreadLocalRandom.current().nextInt();
		int d = Math.abs(a);
		System.out.println("random number" + d);
		book.setGeneratedId(d);
		// getting date and storing in db
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("date" + dtf.format(now));
		book.setDate(dtf.format(now));
		book.setBookName(bookName);
		buyRepo.save(book);
		return "you have successfully purchased book and your book id is" + d;

	}

	// Getting all purchased books by sending email id
	public List<BuyBook> getAllPurchasedBooks(String email) {
		List<BuyBook> purchasedBooks = buyRepo.findAll();
		System.out.println("All books" + purchasedBooks + "size  " + purchasedBooks.size());
		if (email != null) {
			System.out.println("inside if block");
			purchasedBooks = purchasedBooks.stream().filter(pb -> pb.getEmailId().equals(email))
					.collect(Collectors.toList());
		}
		return purchasedBooks;
	}

	// Reader can read a book
	public String getBookName(String emailId, int bookId) {
		return buyRepo.filterByBookId(emailId, bookId);
	}

	// reader can find book by paymentid
	public String getPurchasedBookByPid(String emailId, int generatedId) {
		return buyRepo.filterByGeneratedId(emailId, generatedId);
	}

	// Checking refund is applicable or not
	public String checkIfRefundIsValid(String emailId, int bookId) {
		// long seconds,minutes,hours,years;
		long days = 0;
		String start = buyRepo.getDateFromBuyBook(bookId);
		System.out.println("date from buybook table" + start);
		if (start != null) {
			DateTimeFormatter dlf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String end = dlf.format(now);
			// logic for find time difference
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			try {
				Date d1 = sdf.parse(start);
				Date d2 = sdf.parse(end);
				long difference_In_Time = d2.getTime() - d1.getTime();

				days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;

				System.out.println("days" + days);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (days < 1) {
				buyRepo.deleteById(bookId);
				return "refund success";
			} else {
				return "Refund is valid for upto 24 hours";
			}

		} else {
			return "book id doesn't exist,Please enter existing boook id";
		}

	}

}
