package com.digitalbook.author.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.author.entity.Author;
import com.digitalbook.author.entity.ErrorMessage;
import com.digitalbook.author.exception.AuthorException;
import com.digitalbook.author.service.AuthorService;
@RestController
@RequestMapping("/api/v1/digitalbooks")
public class AuthorController {
	
	
	@Autowired
    public AuthorService authorService;
	
	@GetMapping("/authors")
	public String getAuthor()
	{
		return "Welcome to author page";
	}
    
    //User can signup
    @PostMapping("/signup")
    public String accountCreation(@RequestBody Author author) throws AuthorException
    {
        System.out.println("username " +author.getUsername());
        System.out.println("username " +author.getPassword());
        System.out.println("username " +author.getEmailId());
    return authorService.saveCredentials(author);    
    }
    
    @PostMapping("/login")
    public String authorLogin(@RequestBody Author author) throws AuthorException
    {
        String username=author.getUsername();
        System.out.println("username" +username);
        String password=author.getPassword();
        String s=authorService.validateUser(username,password);
        if(s.equalsIgnoreCase("success"))
        {
            return "Login Success";    
        }
        else if(s.equalsIgnoreCase("failure"))
        {
            return "Password is incorrect,Please enter correct password";
        }
        else
        {
            return "User does not exist,Please register";
        }
        
    }
   
   
}
  
    	


