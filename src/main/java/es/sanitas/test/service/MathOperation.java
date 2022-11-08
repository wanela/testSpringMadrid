package es.sanitas.test.service;

import org.springframework.stereotype.Component;



@Component
@FunctionalInterface
public interface MathOperation {
	Double operation(Double number1, Double number2);	
}