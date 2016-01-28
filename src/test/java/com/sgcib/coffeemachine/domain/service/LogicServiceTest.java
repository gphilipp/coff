package com.sgcib.coffeemachine.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.sgcib.coffeemachine.domain.LogicInput;

public class LogicServiceTest {

	private LogicService logicService = new LogicService();

	@Test
	public void should_throw_UnknowOrderTypeException_when_input_null() {
		String drinkMakerInput = logicService.getDrinkMakerInput(null);

		assertThat(drinkMakerInput).isEqualTo("M:Empty input.");
	}

	@Test
	public void should_throw_UnknowOrderTypeException_when_drink_and_message_null() {
		LogicInput input = new LogicInput(null, 0);

		String drinkMakerInput = logicService.getDrinkMakerInput(input);

		assertThat(drinkMakerInput).isEqualTo("M:Empty drink.");
	}

	@Test
	public void should_generate_one_message() {
		LogicInput input = new LogicInput("message", 0);

		String drinkMakerInput = logicService.getDrinkMakerInput(input);

		assertThat(drinkMakerInput).isEqualTo("M:Unknown drink.");
	}

	@Test
	public void should_make_one_tea() {
		LogicInput input = new LogicInput("TEA", 0);

		String drinkMakerInput = logicService.getDrinkMakerInput(input);

		assertThat(drinkMakerInput).isEqualTo("T::");
	}

}
