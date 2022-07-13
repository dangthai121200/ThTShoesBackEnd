package com.herokuapp.handleexception;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noSuchElementException(NoSuchElementException ex) {
		return ResponseEntity.badRequest().body("Không tìm thấy giá trị");
	}

	@ExceptionHandler(ThtShoesException.class)
	public ResponseEntity<String> thtShoesException(ThtShoesException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
