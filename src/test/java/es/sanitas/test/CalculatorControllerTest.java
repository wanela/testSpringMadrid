package es.sanitas.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import es.sanitas.app.TestApplication;
import es.sanitas.test.controller.CalculatorController;
import io.corp.calculator.TracerAPI;

@WebMvcTest(CalculatorController.class)
@ContextConfiguration(classes = TestApplication.class)
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TracerAPI trace;

	@Autowired
	CalculatorController calculatorController;

	private final String URL = "/calculator";

	@Test
	public void contextLoads() throws Exception {
		assertThat(calculatorController).isNotNull();
	}

	@Test
	public void testCalculaterRest() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL).queryParam("operator", "-")
				.queryParam("val1", "10").queryParam("val2", "20")).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");
		trace.trace("TestCase Result: " + result.getResponse().getContentAsString());

	}

	@Test
	public void testCalculaterSum() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL).queryParam("operator", "+")
				.queryParam("val1", "10").queryParam("val2", "20")).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");

		trace.trace("TestCase Result: " + result.getResponse().getContentAsString());
	}

	@Test
	public void testCalculaterMult() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL).queryParam("operator", "*")
				.queryParam("val1", "10").queryParam("val2", "21")).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");
		trace.trace("TestCase Result: " + result.getResponse().getContentAsString());
	}

	@Test
	public void testCalculaterDiv() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL).queryParam("operator", "/")
				.queryParam("val1", "10").queryParam("val2", "20")).andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");

		trace.trace("TestCase Result: " + result.getResponse().getContentAsString());
	}
}
