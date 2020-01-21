package br.com.udemy.workshopmongo.resource.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	
	public ResponseEntity<StandardError> objectNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error 		= "Resource not found";
		HttpStatus status 	= HttpStatus.NOT_FOUND;
		StandardError err 	= new StandardError(Instant.now(), status.value(), error, e.getMessage(),
								request.getRequestURI());
		return 	ResponseEntity.status(status).body(err);
	}	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request) {
			String error 		= "Data base error ";
			HttpStatus status 	= HttpStatus.BAD_REQUEST;
			StandardError err 	= new StandardError(Instant.now(), status.value(), error, e.getMessage(),
								request.getRequestURI());
			return ResponseEntity.status(status).body(err);
	}


}
