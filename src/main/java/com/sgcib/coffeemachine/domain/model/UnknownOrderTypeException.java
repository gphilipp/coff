package com.sgcib.coffeemachine.domain.model;

public class UnknownOrderTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownOrderTypeException(String message) {
		super(message);
	}

}
