package es.sanitas.test.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import io.corp.calculator.TracerAPI;

@Component
public class TraceApiImpl implements TracerAPI{

	private static final Logger log = LogManager.getLogger(TraceApiImpl.class);

	@Override
	public <T> void trace(T arg0) {
		log.info(arg0);
	}

}
