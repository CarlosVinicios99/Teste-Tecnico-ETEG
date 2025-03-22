package carlosvinicios.users;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import carlosvinicios.users.repository.UsersRepository;
import carlosvinicios.users.service.UsersService;

public class UsersServiceTest {
	
	@Mock
	UsersRepository usersRepository;
	
	@InjectMocks
	UsersService usersService;
	
	@BeforeEach
	public void setUp() {
	   MockitoAnnotations.openMocks(this); 
	}
}
