package carlosvinicios.colors.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carlosvinicios.colors.model.Color;

@Repository
public interface ColorsRepository extends JpaRepository<Color, UUID>{}
