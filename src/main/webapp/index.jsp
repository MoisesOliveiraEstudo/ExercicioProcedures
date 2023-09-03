<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Clientes</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form style="padding: 10px" action="cliente" method="POST">
		<h3>Formulario de Clientes</h3>
		<div>
			<label>CPF</label> 
			<input type="text" name="cpf" value="<c:out value='${cliente.cpf}'/>">
		</div>
		
		<div>
			<label>Nome</label> 
			<input type="text" name="nome" value="<c:out value='${cliente.nome}'/>">
		</div>

		<div>
			<label>Email</label>
			<input type="text" name="email" value="<c:out value='${cliente.email}'/>">
		</div>
		
		<div>
			<label>Limite de Credito</label>
			<input type="number" name="limite_credito" value="<c:out value='${cliente.limiteDeCredito}'/>">
		</div>
		
		<div>
			<label>Data de nascimento</label>
			<input type="date" name="data_nascimento" value="<c:out value='${cliente.dataNascimento}'/>">
		</div>
		
		<div>
			<input type="submit" name="botao" value="Inserir"/>
			<input type="submit" name="botao" value="Atualizar">
			<input type="submit" name="botao" value="Deletar">
			<input type="submit" name="botao" value="Consultar">
			<input type="submit" name="botao" value="Listar">
		</div>

	</form>
	
	<c:out value="${erro}"></c:out>
	
	<div>

		<c:forEach var="cliente" items="${clientes}" >
			
			<div>
			<c:out value="${cliente.nome }"></c:out>
			<br>
			<c:out value="${cliente.cpf }"></c:out>
			<br>
			<c:out value="${cliente.email }"></c:out>
			</div>
		</c:forEach>
	</div>
</body>
</html>