package carlosvinicios.users.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carlosvinicios.users.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, UUID>{
	public User findByEmail(String email);
	public User findByCpf(String cpf);
}
