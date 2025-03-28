package carlosvinicios.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmailConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmailConflictException() {
		super("Email já existente");
	}
	
}
