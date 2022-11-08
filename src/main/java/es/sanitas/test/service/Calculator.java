package es.sanitas.test.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@Service
public class Calculator {

	public Double operate(Double a, Double b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	public Double calculate(Double a, Double b, String operation) {
		MathOperation mathOperation = null;
		switch (operation) {
		case "+":
			mathOperation = (number1, number2) -> number1 + number2;
			break;
		case "-":
			mathOperation = (number1, number2) -> number1 - number2;
			break;
		case "*":
			mathOperation = (number1, number2) -> number1 * number2;
			break;
		case "/":
			mathOperation = (number1, number2) -> number1 / number2;
			break;
		}

		return operate(a, b, mathOperation);
	}

}
