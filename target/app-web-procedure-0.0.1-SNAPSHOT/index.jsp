<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form style="padding: 10px" action="cliente" method="POST">
		<h3>Formulario de Clientes</h3>
		<div>
			<label>CPF</label> 
			<input type="text" name="cpf">
		</div>
		
		<div>
			<label>Nome</label> 
			<input type="text" name="nome">
		</div>

		<div>
			<label>Email</label>
			<input type="text" name="email">
		</div>
		
		<div>
			<label>Limite de Credito</label>
			<input type="number" name="limite_credito">
		</div>
		
		<div>
			<label>Data de nascimento</label>
			<input type="date">
		</div>
		
		<div>
			<input type="submit" name="botao" value="Inserir"/>
			<input type="submit" name="botao" value="Atualizar">
			<input type="submit" name="botao" value="Deletar">
			<input type="submit" name="botao" value="Consultar">
			<input type="submit" name="botao" value="Consultar Todos">
		</div>

	</form>
	
	<c:out value="${erro}"></c:out>
</body>
</html>