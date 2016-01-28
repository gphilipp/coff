package com.sgcib.coffeemachine.domain.model;

public abstract class Order {

	static final String STICK = "0";
	static final String EMPTY_LABEL = "";
	static final String DRINK_MAKER_SEPARATOR = ":";

	private OrderType order;

	protected Order(OrderType order) {
		this.order = order;
	}

	private String getDrinkMakerLabel() {
		return order.getLabel();
	}

	protected abstract String getDrinkMakerAdditionalInfos();

	public String toDrinkMakerInput() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getDrinkMakerLabel());
		stringBuilder.append(DRINK_MAKER_SEPARATOR);
		stringBuilder.append(getDrinkMakerAdditionalInfos());
		return stringBuilder.toString();
	}

}