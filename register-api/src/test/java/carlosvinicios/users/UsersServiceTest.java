package carlosvinicios.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import carlosvinicios.colors.model.Color;
import carlosvinicios.colors.repository.ColorsRepository;
import carlosvinicios.users.dto.CreateUserDTO;
import carlosvinicios.users.exceptions.EmailConflictException;
import carlosvinicios.users.model.User;
import carlosvinicios.users.repository.UsersRepository;
import carlosvinicios.users.service.UsersService;

public class UsersServiceTest {
	
	@Mock
	UsersRepository usersRepository;
	
	@Mock
	ColorsRepository colorsRepository;
	
	@InjectMocks
	UsersService usersService;
	
	@BeforeEach
	public void setUp() {
	   MockitoAnnotations.openMocks(this); 
	}
	
	
	public void testCreateUserCaseSucess() {
        
		UUID colorId = UUID.randomUUID();
		
		Optional<Color> favoriteColor = Optional.of(new Color(colorId, "Azul", "#0000FF"));
		
	    CreateUserDTO createUserDto = new CreateUserDTO(
	    	"Carlos Vinícios De Souza", 
	    	"carlosvinicios@email.com", 
	    	"41956791094", 
	    	colorId
	    );
	    
	    User savedUser = new User(
	    	UUID.randomUUID(),
	    	"Carlos Vinícios De Souza",
	    	"carlosvinicios@email.com", 
	    	"41956791094",
	    	favoriteColor.get()
	    );
	    
	    when(usersRepository.findByEmail(createUserDto.email())).thenReturn(null);
	    when(usersRepository.findByCpf(createUserDto.cpf())).thenReturn(null);
	    when(colorsRepository.findById(colorId)).thenReturn(favoriteColor);
	    when(usersRepository.save(any(User.class))).thenReturn(savedUser);
	    
	    
	    ResponseEntity<User> response = usersService.createUser(createUserDto);

	    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	    assertThat(response.getBody()).isNotNull();
	    assertThat(response.getBody().getName()).isEqualTo(createUserDto.name());
	    assertThat(response.getBody().getEmail()).isEqualTo(createUserDto.email());
	    assertThat(response.getBody().getCpf()).isEqualTo(createUserDto.cpf());
	    assertThat(response.getBody().getFavoriteColor()).usingRecursiveComparison().isEqualTo(favoriteColor.get());   
	}
	
	public void testCreateUserCaseFailByEmailConflictException() {
		UUID colorId = UUID.randomUUID();
		
	    CreateUserDTO createUserDto = new CreateUserDTO(
	    	"Carlos Vinícios De Souza", 
	    	"carlosvinicios@email.com", 
	    	"41956791094", 
	    	colorId
	    );
	    
	    when(usersRepository.findByEmail(createUserDto.email())).thenReturn(new User());
	    assertThrows(EmailConflictException.class, () -> usersService.createUser(createUserDto));
	}
	
	/*
	public void testCreateUserCaseFailByInvalidCpfException() {
		
	}
	*/
	
	public void testCreateUserCaseFailByCpfConflictException() {
		
	}
	
	public void testCreateUserCaseFailByInvalidColorException() {
		
	}
	
	
}
