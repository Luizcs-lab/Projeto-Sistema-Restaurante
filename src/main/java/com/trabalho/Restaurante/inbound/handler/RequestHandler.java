package com.trabalho.Restaurante.inbound.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trabalho.Restaurante.core.entity.ExceptionResponse;
import com.trabalho.Restaurante.core.exception.BusinessException;

@RestControllerAdvice
public class RequestHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ExceptionResponse> handleException(Exception ex) {
		final var message = ex.getMessage();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(ExceptionResponse.builder().message(message).status(HttpStatus.BAD_REQUEST.toString()).build());
	}

	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException ex) {
		final var message = ex.getMessage();

		return ResponseEntity.status(ex.getStatus())
			.body(ExceptionResponse.builder().message(message).status(ex.getStatus().toString()).build());
	}

}
