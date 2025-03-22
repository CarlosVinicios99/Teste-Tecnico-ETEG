package carlosvinicios.users.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carlosvinicios.users.repository.UsersRepository;

@Service
public class UsersService {
	
	private Logger logger = Logger.getLogger(UsersService.class.getName());
	
	@Autowired
	private UsersRepository usersRepository;
	
	
}
