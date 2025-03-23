package carlosvinicios.users.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import carlosvinicios.users.exceptions.CpfConflictException;
import carlosvinicios.users.exceptions.EmailConflictException;
import carlosvinicios.users.exceptions.ErrorResponse;
import carlosvinicios.users.exceptions.InvalidColorException;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(EmailConflictException.class)
    public ResponseEntity<ErrorResponse> handleEmailConflictException(EmailConflictException err) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
        	.body(new ErrorResponse(err.getMessage(), HttpStatus.CONFLICT.value()));
    }
	
	@ExceptionHandler(CpfConflictException.class)
	public ResponseEntity<ErrorResponse> handleCpfConflictException(CpfConflictException err){
		return ResponseEntity.status(HttpStatus.CONFLICT)
			.body(new ErrorResponse(err.getMessage(), HttpStatus.CONFLICT.value()));
	}
	
	@ExceptionHandler(InvalidColorException.class)
	public ResponseEntity<ErrorResponse> handleInvalidColorException(InvalidColorException err){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body(new ErrorResponse(err.getMessage(), HttpStatus.BAD_REQUEST.value()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
			.body(new ErrorResponse("Serviço indisponível", HttpStatus.SERVICE_UNAVAILABLE.value()));
	}
}
