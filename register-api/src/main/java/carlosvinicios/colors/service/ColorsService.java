package carlosvinicios.colors.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import carlosvinicios.colors.dto.CreateColorDTO;
import carlosvinicios.colors.model.Color;
import carlosvinicios.colors.repository.ColorsRepository;
import carlosvinicios.colors.utils.HexCodeValidator;


@Service
public class ColorsService {
	
	private Logger logger = Logger.getLogger(ColorsService.class.getName());
	
	@Autowired
	private ColorsRepository colorsRepository;
	
	
	public ResponseEntity<Color> createColor(CreateColorDTO createColorDto){
		this.logger.log(Level.INFO, "starting color creation");
		
		this.logger.log(Level.INFO, "checking if hexCode is valid");
		
		if(!HexCodeValidator.isValidHex(createColorDto.hexCode())){
			this.logger.log(Level.SEVERE, "hexCode is invalid");
			//lançar exceção de código hexadecimal inválido
		}
		
		Color newColor = new Color();
		newColor.setName(createColorDto.name());
		newColor.setHexCode(createColorDto.hexCode());
		
		newColor = this.colorsRepository.save(newColor);
		
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(newColor);
	}
}
