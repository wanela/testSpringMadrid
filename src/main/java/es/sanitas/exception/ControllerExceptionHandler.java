package es.sanitas.exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import io.corp.calculator.TracerAPI;

@ControllerAdvice
public class ControllerExceptionHandler {

	@Autowired
	private TracerAPI trace;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		switch (ex.getMessage()) {
		case "Invalid operator":
			status = HttpStatus.BAD_REQUEST;
			break;
		}

		ErrorMessage message = new ErrorMessage(status.value(), new Date(), ex.getMessage(),
				request.getDescription(false));

		trace.trace(ex.getMessage());

		return new ResponseEntity<ErrorMessage>(message, status);
	}
}
