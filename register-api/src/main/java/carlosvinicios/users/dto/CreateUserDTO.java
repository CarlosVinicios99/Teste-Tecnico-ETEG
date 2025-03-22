package carlosvinicios.users.dto;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
	
	@NotBlank(message = "name is required")
	String name,
	
	@Email(message = "email must be a valid email address")
	String email,
	
	@NotBlank(message = "cpf is required")
	String cpf,
	
	@NotBlank(message = "color id is required")
	UUID favoriteColorId
) {

}
