package carlosvinicios.users.dto;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
	
	@NotBlank(message = "campo name é obrigatório")
	String name,
	
	@Email(message = "campo email é obrigatório")
	String email,
	
	@NotBlank(message = "campo cpf é obrigatório")
	String cpf,
	
	@NotBlank(message = "color id is required")
	UUID favoriteColorId
) {

}
