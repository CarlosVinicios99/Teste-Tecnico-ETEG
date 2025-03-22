package carlosvinicios.users.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import carlosvinicios.colors.model.Color;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "full_name")
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color favoriteColor;
	
	
	public User() {
		
	}

	
	public User(UUID id, String name, String email, String cpf, Color favoriteColor) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.favoriteColor = favoriteColor;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Color getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(Color favoriteColor) {
		this.favoriteColor = favoriteColor;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, favoriteColor, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
			&& Objects.equals(favoriteColor, other.favoriteColor) && Objects.equals(id, other.id)
			&& Objects.equals(name, other.name);
	}	
}
