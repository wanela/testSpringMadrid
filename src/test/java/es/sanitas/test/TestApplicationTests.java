package es.sanitas.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.sanitas.TestApplication;



@SpringBootTest
class TestApplicationTests {

	@Autowired
	TestApplication testAplication;  
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(testAplication).isNotNull();
	}

	

}
