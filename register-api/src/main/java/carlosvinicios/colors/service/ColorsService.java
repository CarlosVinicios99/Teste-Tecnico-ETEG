package carlosvinicios.colors.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import carlosvinicios.colors.dto.CreateColorDTO;
import carlosvinicios.colors.exceptions.InvalidHexCodeException;
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
			throw new InvalidHexCodeException();
		}
		
		Color newColor = new Color();
		newColor.setName(createColorDto.name());
		newColor.setHexCode(createColorDto.hexCode());
		
		this.logger.log(Level.WARNING, "create color in database");
		newColor = this.colorsRepository.save(newColor);
		
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(newColor);
	}
	
	public ResponseEntity<List<Color>> listColors(){
		this.logger.log(Level.INFO, "staring list of registered colors");
		
		List<Color> colors = this.colorsRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK)
			.body(colors);
	}
}
