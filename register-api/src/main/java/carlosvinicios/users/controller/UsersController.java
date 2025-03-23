package carlosvinicios.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carlosvinicios.users.dto.CreateUserDTO;
import carlosvinicios.users.model.User;
import carlosvinicios.users.service.UsersService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Serviços de usuário")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	
	@Operation(
		summary = "Criação de usuário",
		description = "Cria um novo usuário, verificando se o email, CPF e a cor favorita já existem no banco de dados.",
		responses = {
			@ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos"),
			@ApiResponse(responseCode = "409", description = "Conflito de dados (email ou CPF já existente)")
		}
	)
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody() CreateUserDTO createUserDTO){
		return this.usersService.createUser(createUserDTO);
	}
	
	@GetMapping()
	public ResponseEntity<List<User>> listUsers(){
		return this.usersService.listUsers();
	}
}
