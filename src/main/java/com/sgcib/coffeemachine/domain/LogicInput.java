package com.sgcib.coffeemachine.domain;

public class LogicInput {

	private int nbSugar;

	private String drink;

	public LogicInput(String drink, int nbSugar) {
		this.nbSugar = nbSugar;
		this.drink = drink;
	}

	public int getNbSugar() {
		return nbSugar;
	}

	public String getDrink() {
		return drink;
	}

}
