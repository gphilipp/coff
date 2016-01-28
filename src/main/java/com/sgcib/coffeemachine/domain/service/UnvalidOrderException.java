package com.sgcib.coffeemachine.domain.service;

public class UnvalidOrderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnvalidOrderException(String message) {
		super(message);
	}

}
