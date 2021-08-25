package com.auth;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	Calculator underTest = new Calculator();

	class Calculator {
		int add(int a, int b) {
			return a+b;
		}
	}

}