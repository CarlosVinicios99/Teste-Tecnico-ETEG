package carlosvinicios.colors.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import carlosvinicios.colors.exceptions.ErrorResponse;
import carlosvinicios.colors.exceptions.InvalidHexCodeException;

@RestControllerAdvice
public class ColorExceptionHandler {
	
	@ExceptionHandler(InvalidHexCodeException.class)
	public ResponseEntity<ErrorResponse> handleInvalidHexCodeException(InvalidHexCodeException err){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new ErrorResponse(err.getMessage(), HttpStatus.BAD_REQUEST.value()));
	}
	
}
