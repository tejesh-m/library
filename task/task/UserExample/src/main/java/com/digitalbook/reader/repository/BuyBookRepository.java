package com.digitalbook.reader.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digitalbook.reader.entity.BuyBook;

public interface BuyBookRepository extends JpaRepository<BuyBook, String> {
	
	//Query for getting bookname by using emailid and bookid
	@Query("select c.bookName from BuyBook c where c.emailId=?1 and c.bookId=?2")
	public String filterByBookId(String emailId, int bookId);
	
	//reader can find book by paymentid
	@Query("select c.bookName from BuyBook c where c.emailId=?1 and c.generatedId=?2")
	public String filterByGeneratedId(String emailId,int pid);
	
	//Query for getting date by using bookid
	@Query("select c.date from BuyBook c where c.bookId=?1")
	public String getDateFromBuyBook(int bookId);
	@Transactional
	@Modifying
	@Query("delete from BuyBook c where c.bookId=?1")
	public void deleteById(int bookId);
	
	

}
