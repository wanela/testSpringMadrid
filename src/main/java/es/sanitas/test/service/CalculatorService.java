package es.sanitas.test.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class CalculatorService {

	public BigDecimal operate(Double a, Double b, MathOperation mathOperation) {
		return new BigDecimal(mathOperation.operation(a, b));
	}

	public BigDecimal calculate(Double a, Double b, String operation) throws Exception {
		MathOperation mathOperation = null;
		switch (operation) {
		case "SUM":
			mathOperation = (number1, number2) -> number1 + number2;
			break;
		case "SUB":
			mathOperation = (number1, number2) -> number1 - number2;
			break;
		case "MUL":
			mathOperation = (number1, number2) -> number1 * number2;
			break;
		case "DIV":
			mathOperation = (number1, number2) -> number1 / number2;
			break;
		default:
			throw new Exception("Invalid operator");
		}

		return operate(a, b, mathOperation);
	}

}
