package com.sgcib.coffeemachine.domain.model;

public enum OrderType {
	CHOCOLATE("H"), TEA("T"), COFFEE("C"), MESSAGE("M");

	private String label;

	private OrderType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public static OrderType getOrderType(String type) throws UnknownOrderTypeException {
		OrderType orderType = null;
		try {
			orderType = OrderType.valueOf(type);
		} catch (Exception e) {
			throw new UnknownOrderTypeException(e.getMessage());
		}
		return orderType;
	}
}
