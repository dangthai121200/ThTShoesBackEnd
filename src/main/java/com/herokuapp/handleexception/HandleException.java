package com.herokuapp.handleexception;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noSuchElementException(NoSuchElementException ex) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body("Không tìm thấy giá trị");
	}

	@ExceptionHandler(ThtShoesException.class)
	public ResponseEntity<String> thtShoesException(ThtShoesException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		List<String> errors = new ArrayList<>();
		for (ObjectError objectError : ex.getAllErrors()) {
			errors.add(objectError.getDefaultMessage());
		}
		return ResponseEntity.badRequest().body(errors);
	}

}
