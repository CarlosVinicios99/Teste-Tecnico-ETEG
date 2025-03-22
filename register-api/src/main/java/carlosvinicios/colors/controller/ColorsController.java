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
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestControllerAdvice
@RequestMapping("/colors")
public class ColorsController {
	
	@Autowired
	private ColorsService colorsService;
	
	
	@PostMapping()
	public ResponseEntity<Color> createColor(@RequestBody() CreateColorDTO createColorDto){
		return this.colorsService.createColor(createColorDto);
	}
	
	@GetMapping()
	public ResponseEntity<List<Color>> listColors(){
		return this.colorsService.listColors();
	}
	
	
}
