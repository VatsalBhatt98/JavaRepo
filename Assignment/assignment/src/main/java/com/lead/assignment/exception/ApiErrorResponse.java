package com.lead.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiErrorResponse {

	 @ExceptionHandler(LeadExistsException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ResponseEntity<ErrorResponse> handleLeadAlreadyExistsException(LeadExistsException ex) {
	        ErrorResponse errorResponse = new ErrorResponse("E10010", ex.getMessage());
	        return ResponseEntity.badRequest().body(errorResponse);
	    }

	    @ExceptionHandler(LeadNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public ResponseEntity<ErrorResponse> handleLeadNotFoundException(LeadNotFoundException ex) {
	        ErrorResponse errorResponse = new ErrorResponse("E10011", ex.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	    }
	}

