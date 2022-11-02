package com.digitalbook.author.service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.digitalbook.author.entity.Author;
import com.digitalbook.author.entity.AuthorBook;
import com.digitalbook.author.exception.AuthorException;
import com.digitalbook.author.repository.AuthorBookRepository;
import com.digitalbook.author.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
    public AuthorRepository authRepo;
    
    public String saveCredentials(Author author) throws AuthorException
    {
		try
		{
        authRepo.save(author);
        return "Registration success , Please Login" ;
		}
		catch(Exception ae)
		{
			throw new AuthorException("Registration failed");
		}
    }
    
    
    public String validateUser(String username,String password) throws AuthorException
    {
    String dbPassword=    authRepo.filterByPassword(username);
    if(dbPassword != null)
    {
        if(dbPassword.equals(password))
        {
            return "success";
        }
        else
        {
            return "failure";
        }
    }
    else
    {
        return "false";
    }
    
    }


	public Optional<AuthorityUtils> getAuthorById(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}


	}


	/*
	 * public String save(int authorId,AuthorBook authorBooks) {
	 * authRepo.save(authorBooks); return "Book Created successfully";
	 * 
	 * }
	 */


