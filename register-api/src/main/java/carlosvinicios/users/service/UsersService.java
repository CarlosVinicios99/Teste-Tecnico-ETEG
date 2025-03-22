package carlosvinicios.users.service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import carlosvinicios.colors.model.Color;
import carlosvinicios.colors.repository.ColorsRepository;
import carlosvinicios.users.dto.CreateUserDTO;
import carlosvinicios.users.model.User;
import carlosvinicios.users.repository.UsersRepository;

@Service
public class UsersService {
	
	private Logger logger = Logger.getLogger(UsersService.class.getName());
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private ColorsRepository colorsRepository;
	
	
	public ResponseEntity<User> createUser(CreateUserDTO createUserDto){
		this.logger.log(Level.INFO, "starting user creation");
		
		this.logger.log(Level.WARNING, "checking if email already exists in database");
		User userWithEmail = this.usersRepository.findByEmail(createUserDto.email());
		
		if(userWithEmail != null) {
			//lançar exceção de email já existente
		}
		
		this.logger.log(Level.WARNING, "checking if cpf already exists in database");
		User userWithCpf = this.usersRepository.findByCpf(createUserDto.cpf());
		
		if(userWithCpf != null) {
			//lancar exceção de cpf já existente
		}
		
		this.logger.log(Level.WARNING, "checking if the color is valid in database");
		Optional<Color> color = this.colorsRepository.findById(createUserDto.favoriteColorId());
		
		if(!color.isPresent()) {
			//lançar exceção de cor inválida
		}
		
		User newUser = new User();
		newUser.setName(createUserDto.name());
		newUser.setEmail(createUserDto.email());
		newUser.setCpf(createUserDto.cpf());
		newUser.setFavoriteColor(color.get());
		
		this.logger.log(Level.WARNING, "create user in database");
		newUser = this.usersRepository.save(newUser);
		
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(newUser);
	}
	
}
