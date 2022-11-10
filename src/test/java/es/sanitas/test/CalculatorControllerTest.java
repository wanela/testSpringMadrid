package es.sanitas.test;



import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import es.sanitas.test.controller.CalculatorController;
import io.corp.calculator.TracerAPI;



@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

	private final String URL = "/calculator";

	private MockMvc mockMvc;
	
	@Autowired
	private TracerAPI trace;

	@InjectMocks
	CalculatorController calculatorController;

	
	

	@Test
	public void contextLoads() throws Exception {
		assertThat(calculatorController).isNotNull();
	}
	
    @BeforeEach
    void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
	public void testUrl() throws Exception {
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL)).andReturn();
		int status = result.getResponse().getStatus();
		assertThat(status, not(HttpStatus.NOT_FOUND.value()));
		
		trace.trace("TestCase Result: " + result.getResponse().getContentAsString());

    }
 
}
