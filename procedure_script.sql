CREATE DATABASE db_app_procedures
GO
USE db_app_procedures
GO
CREATE TABLE cliente(
	cpf CHAR(11) PRIMARY KEY,
	nome VARCHAR(100),
	email VARCHAR(200),
	limite_de_credito DECIMAL(7,2),
	dt_nascimento DATE CHECK(dt_nascimento < GETDATE())
)

INSERT INTO cliente VALUES ('55555555555','Akinaldo', 'akin@email.com', 774.89, '2005-06-19')

CREATE PROCEDURE procedure_insert(@cpf AS CHAR(11), @nome AS VARCHAR(100), @email AS VARCHAR(200), 
@limite_credito AS DECIMAL(7,2), @dt_nascimento AS DATE)
AS
	IF(LEN(@cpf) = 11)
		BEGIN
			INSERT INTO cliente VALUES (@cpf, @nome, @email, @limite_credito, @dt_nascimento)
		END
	ELSE
		BEGIN
			THROW 51000, 'CPF nao valido',1
		END