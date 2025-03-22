package carlosvinicios.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carlosvinicios.users.dto.CreateUserDTO;
import carlosvinicios.users.model.User;
import carlosvinicios.users.service.UsersService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody() CreateUserDTO createUserDTO){
		return this.usersService.createUser(createUserDTO);
	}
}
