package com.sgcib.coffeemachine.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class OrderTest {

	@Test
	public void should_make_one_chocolate() {
		Order order = new DrinkOrder(OrderType.CHOCOLATE, 0);
		String drinkMakerInput = order.toDrinkMakerInput();

		assertThat(drinkMakerInput).isEqualTo("H::");
	}

	@Test
	public void should_make_one_tea() {
		Order order = new DrinkOrder(OrderType.TEA, 0);

		String drinkMakerInput = order.toDrinkMakerInput();

		assertThat(drinkMakerInput).isEqualTo("T::");
	}

	@Test
	public void should_make_one_coffee() {
		Order order = new DrinkOrder(OrderType.COFFEE, 0);

		String drinkMakerInput = order.toDrinkMakerInput();

		assertThat(drinkMakerInput).isEqualTo("C::");
	}

	@Test
	public void should_make_one_tea_with_1_sugar_and_1_stick() {
		Order order = new DrinkOrder(OrderType.TEA, 1);

		String drinkMakerInput = order.toDrinkMakerInput();

		assertThat(drinkMakerInput).isEqualTo("T:1:0");
	}

	@Test
	public void should_make_one_coffee_with_2_sugar_and_1_stick() {
		Order order = new DrinkOrder(OrderType.COFFEE, 2);

		String drinkMakerInput = order.toDrinkMakerInput();

		assertThat(drinkMakerInput).isEqualTo("C:2:0");
	}

	@Test
	public void should_make_one_coffee_with_minus_2_sugar_and_no_stick() {
		Order order = new DrinkOrder(OrderType.COFFEE, -2);

		String drinkMakerInput = order.toDrinkMakerInput();

		assertThat(drinkMakerInput).isEqualTo("C::");
	}

	@Test
	public void should_return_message() {
		String message = "message";
		Order order = new MessageOrder(message);

		String drinkMakerInput = order.toDrinkMakerInput();

		assertThat(drinkMakerInput).isEqualTo("M:" + message);
	}

}
