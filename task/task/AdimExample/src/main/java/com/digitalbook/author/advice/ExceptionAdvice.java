package com.digitalbook.author.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.digitalbook.author.entity.ErrorMessage;
import com.digitalbook.author.exception.AuthorException;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(AuthorException.class)
	public ResponseEntity<ErrorMessage> handleAuthorException(AuthorException ae)
	{
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(
				"AuthorException:" +ae.getMessage(),
				ae.getClass().toString(),
				"Exception has occured,Please check"),HttpStatus.OK);

	}

}
