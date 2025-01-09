package com.caiovieira.workshop.resources.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.caiovieira.workshop.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class handleError {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandError> resourceNotFound(ObjectNotFoundException exception, HttpServletRequest status) {
		String error = "new error";
		HttpStatus hs = HttpStatus.NOT_FOUND;
		StandError se = new StandError(LocalDateTime.now(), hs.value(), error, exception.getMessage(), status.getRequestURI());
		return ResponseEntity.status(hs).body(se);
	}

}
