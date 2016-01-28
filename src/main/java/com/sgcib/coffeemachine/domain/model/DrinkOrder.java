package com.sgcib.coffeemachine.domain.model;

public class DrinkOrder extends Order {

	private int nbSugar;

	public DrinkOrder(OrderType drink, int nbSugar) {
		super(drink);
		this.nbSugar = nbSugar;
	}

	private boolean hasSugar() {
		return nbSugar > 0;
	}

	private String getSugarLabel() {
		return hasSugar() ? String.valueOf(nbSugar) : EMPTY_LABEL;
	}

	private String getStickLabel() {
		return hasSugar() ? STICK : EMPTY_LABEL;
	}

	@Override
	protected String getDrinkMakerAdditionalInfos() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getSugarLabel());
		stringBuilder.append(DRINK_MAKER_SEPARATOR);
		stringBuilder.append(getStickLabel());
		return stringBuilder.toString();
	}

}
