package br.com.api_usuario_enderecos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.api_usuario_enderecos.controller.response.ResponseError;
import br.com.api_usuario_enderecos.exceptions.CpfExistenteException;
import br.com.api_usuario_enderecos.exceptions.EmailExistenteException;


@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionConfiguration extends ResponseEntityExceptionHandler {

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage())
                .collect(Collectors.toList());
		
		return ResponseEntity.badRequest().body(new ResponseError(errors));
	}
	
	
	@ExceptionHandler({ CpfExistenteException.class, 
						EmailExistenteException.class })
	public ResponseEntity<Object> handleExistsPropertyException (
			RuntimeException ex, WebRequest request) {
	    
	    return handleExceptionInternal(ex, ex.getMessage(), 
		          new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	
	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<Object> handleEntityNotFoundException (
			EntityNotFoundException ex, WebRequest request) {

		return handleExceptionInternal(ex, "Entidade não encontrada!", 
		          new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
		
	
}
