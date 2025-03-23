package carlosvinicios.colors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import carlosvinicios.colors.dto.CreateColorDTO;
import carlosvinicios.colors.model.Color;
import carlosvinicios.colors.service.ColorsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestControllerAdvice
@RequestMapping("/colors")
@Tag(name = "Colors", description = "Serviços de gerenciamento das cores")
public class ColorsController {
	
	@Autowired
	private ColorsService colorsService;
	
	
	@Operation(
		summary = "Criação de cor",
		description = "Cria um nova cor, verificando se o código hexadecimal é válido",
		responses = {
			@ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Código Decimal inválido"),
		}
	)
	@PostMapping()
	public ResponseEntity<Color> createColor(@RequestBody() CreateColorDTO createColorDto){
		return this.colorsService.createColor(createColorDto);
	}
	
	@Operation(
		summary = "Busca pelas cores cadastradas"
	)
	@GetMapping()
	public ResponseEntity<List<Color>> listColors(){
		return this.colorsService.listColors();
	}
	
}
