package carlosvinicios.colors.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateColorDTO(
	@NotBlank(message = "name is required")
	String name,
	
	@NotBlank(message = "hexCode is required")
	String hexCode

) {

}
