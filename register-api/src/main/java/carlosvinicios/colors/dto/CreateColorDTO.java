package carlosvinicios.colors.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateColorDTO(
	@NotBlank(message = "campo nome é obrigatório")
	String name,
	
	@NotBlank(message = "campo hexCode é obrigatório")
	String hexCode

) {

}
