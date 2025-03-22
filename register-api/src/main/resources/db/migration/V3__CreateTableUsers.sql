CREATE TABLE users(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	full_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL UNIQUE,
	cpf VARCHAR(14) NOT NULL UNIQUE,
	color_id UUID NOT NULL,
	
	CONSTRAINT fk_users_color FOREIGN KEY (color_id) REFERENCES colors(id)
);