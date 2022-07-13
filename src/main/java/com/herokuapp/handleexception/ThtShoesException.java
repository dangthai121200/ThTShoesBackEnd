package com.herokuapp.handleexception;

public class ThtShoesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public ThtShoesException(String message) {
		super(message);
	}

}
