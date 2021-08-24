package com.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void itShouldAddTwoNumbers() {
		// given
		int numberOne = 20;
		int numberTwo = 30;

		// when
		int result = underTest.add(numberOne, numberTwo);

		// then
		int expected = 50;
		assertEquals(result, expected);
	}

	class Calculator {
		int add(int a, int b) {
			return a+b;
		}
	}

}