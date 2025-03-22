package carlosvinicios.colors.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "colors")
public class Color implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column
	private String name;
	
	@Column(name = "hex_code")
	private String hexCode;
	
	
	public Color() {
		
	}

	public Color(UUID id, String name, String hexCode) {
		super();
		this.id = id;
		this.name = name;
		this.hexCode = hexCode;
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

	public String getHexCode() {
		return hexCode;
	}

	public void setHexCode(String hexCode) {
		this.hexCode = hexCode;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(hexCode, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		return Objects.equals(hexCode, other.hexCode) && Objects.equals(id, other.id)
			&& Objects.equals(name, other.name);
	}
	
}
