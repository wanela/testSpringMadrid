package es.sanitas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

import es.sanitas.exception.ControllerExceptionHandler;

@ComponentScans({ @ComponentScan(basePackages = { "es.sanitas.*" }) })
@SpringBootApplication
@Import(ControllerExceptionHandler.class)
public class TestApplication  extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
