package carlosvinicios.users.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidColorException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidColorException() {
		super("Cor inválida");
	}
}
