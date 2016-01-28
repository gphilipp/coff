package com.sgcib.coffeemachine.domain.service;

import com.sgcib.coffeemachine.domain.LogicInput;
import com.sgcib.coffeemachine.domain.model.DrinkOrder;
import com.sgcib.coffeemachine.domain.model.MessageOrder;
import com.sgcib.coffeemachine.domain.model.Order;
import com.sgcib.coffeemachine.domain.model.OrderType;
import com.sgcib.coffeemachine.domain.model.UnknownOrderTypeException;

public class LogicService {

	private static final String UNKNOWN_DRINK = "Unknown drink.";
	private static final String EMPTY_DRINK = "Empty drink.";
	private static final String EMPTY_INPUT = "Empty input.";

	public String getDrinkMakerInput(LogicInput input) {
		Order order = null;
		try {
			order = getOrder(input);
		} catch (UnvalidOrderException e) {
			order = new MessageOrder(e.getMessage());
		}
		return order.toDrinkMakerInput();
	}

	private Order getOrder(LogicInput input) throws UnvalidOrderException {
		if (input == null) {
			throw new UnvalidOrderException(EMPTY_INPUT);
		}
		String drink = input.getDrink();
		if (drink == null)
			throw new UnvalidOrderException(EMPTY_DRINK);
		return getDrinkOrder(input);
	}

	private Order getDrinkOrder(LogicInput input) throws UnvalidOrderException {
		Order order = null;
		try {
			order = new DrinkOrder(OrderType.getOrderType(input.getDrink()), input.getNbSugar());
		} catch (UnknownOrderTypeException e) {
			throw new UnvalidOrderException(UNKNOWN_DRINK);
		}
		return order;
	}
}
