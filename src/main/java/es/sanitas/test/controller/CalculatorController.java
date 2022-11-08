package es.sanitas.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.sanitas.test.service.Calculator;
import io.corp.calculator.TracerAPI;

@RestController
public class CalculatorController {


	@Autowired
	private Calculator calculate;

	@Autowired
	private TracerAPI trace;

	@GetMapping("/calculator")
	public ResponseEntity<Double> calculator(@RequestParam String operator, @RequestParam Double val1,
			@RequestParam Double val2) throws Exception {
		
			final Double result = calculate.calculate(val1, val2, operator);

			trace.trace(result);

			return ResponseEntity.ok().body(result);
		

	}

}
