package es.sanitas.test.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.sanitas.test.service.CalculatorService;
import io.corp.calculator.TracerAPI;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CalculatorController {

	@Autowired
	private CalculatorService calculate;

	@Autowired
	private TracerAPI trace;

	@ApiOperation(value = "Microservicio Calculadora", notes = "Devuelve la solucion de una oparación matemática facilitada por parmametros.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Calculo exitoso"),
			@ApiResponse(code = 400, message = "No existe el 'operador'"),
			@ApiResponse(code = 500, message = "Error genérico") })

	@GetMapping("/calculator")
	public ResponseEntity<BigDecimal> calculator(
			@ApiParam(value = "El operador en String posibles valores = SUM,SUB,MUL o DIV", required = true) @RequestParam String operator,
			@ApiParam(value = "El valor en String, ejemplos = '1.0 o -1,0'", required = true) @RequestParam String val1,
			@ApiParam(value = "El valor en String, ejemplos = '-1.0 o 1,0'", required = true) @RequestParam String val2)
			throws Exception {

		Locale l = Locale.ENGLISH;
		if (val1.contains(",") || val2.contains(",")) {
			l = Locale.FRANCE;
		}

		NumberFormat format = NumberFormat.getInstance(l);

		final BigDecimal result = calculate.calculate(format.parse(val1).doubleValue(),
				format.parse(val2).doubleValue(), operator);

		trace.trace(result);

		return ResponseEntity.ok().body(result);
	}

}
