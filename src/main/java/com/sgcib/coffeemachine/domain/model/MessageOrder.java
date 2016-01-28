package com.sgcib.coffeemachine.domain.model;

public class MessageOrder extends Order {
	
	private String message;
	
	public MessageOrder(String message) {
		super(OrderType.MESSAGE);
		this.message = message;
	}

	@Override
	protected String getDrinkMakerAdditionalInfos() {
		return message;
	}

}
