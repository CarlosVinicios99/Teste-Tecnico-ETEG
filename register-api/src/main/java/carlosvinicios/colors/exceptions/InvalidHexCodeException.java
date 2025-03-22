package carlosvinicios.colors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidHexCodeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidHexCodeException() {
		super("campo hexCode nãoé um código hexadecimal válido");
	}
}
