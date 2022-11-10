package es.sanitas.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import es.sanitas.test.service.CalculatorService;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

	private MockMvc mockMvc;

	@InjectMocks
	CalculatorService calculatorService;

	@Test
	public void contextLoads() throws Exception {
		assertThat(calculatorService).isNotNull();
	}

	@BeforeEach
	void init() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(calculatorService).build();
	}

	@Test
	public void testCalculaterSUB() throws Exception {
		assertEquals(new BigDecimal(10), calculatorService.calculate(2.0, -8.0, "SUB"), "Error TestCalculaterSUB");

	}

	@Test
	public void testCalculaterSUM() throws Exception {
		assertEquals(new BigDecimal(-6), calculatorService.calculate(2.0, -8.0, "SUM"), "Error TestCalculaterMUL");

	}

	@Test
	public void testCalculaterMult() throws Exception {
		assertEquals(new BigDecimal(-16), calculatorService.calculate(2.0, -8.0, "MUL"), "Error TestCalculaterMUL");

	}

	@Test
	public void testCalculaterDiv() throws Exception {
		assertEquals(new BigDecimal(-0.25), calculatorService.calculate(2.0, -8.0, "DIV"), "Error TestCalculaterDIV");
	}

	@Test
	public void testCalculaterDivZero() throws Exception {
		try {
			calculatorService.calculate(2.0, 0.0, "DIV");
			fail();
		} catch (Exception e) {
			final String expected = "Infinite or NaN";
			assertEquals(expected, e.getMessage());
		}
	}

	@Test
	public void testCalculaterAny() throws Exception {
		try {
			calculatorService.calculate(2.0, -8.0, "ANY");
			fail();
		} catch (Exception e) {
			final String expected = "Invalid operator";
			assertEquals(expected, e.getMessage());
		}

	}
}
