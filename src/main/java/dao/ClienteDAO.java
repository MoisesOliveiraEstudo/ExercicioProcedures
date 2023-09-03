package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import database.Connector;
import model.Cliente;

public class ClienteDAO implements DAO<Cliente>{

	Connection connection;
	
	@Override
	public void inserir(Cliente cliente) throws SQLException, ClassNotFoundException {
		String sql = "CALL procd_cliente('I',?,?,?,?,?)";
		connection = Connector.connect();
		CallableStatement stment = connection.prepareCall(sql);
		stment.setString(1, cliente.getCpf());
		stment.setString(2, cliente.getNome());
		stment.setString(3, cliente.getEmail());
		stment.setFloat(4, cliente.getLimiteDeCredito());
		stment.setDate(5, cliente.getDataNascimento());
		stment.execute();
		stment.close();
		connection.close();
	}
	
	@Override
	public void atualizar(Cliente cliente) throws SQLException, ClassNotFoundException {
		String sql = "CALL procd_cliente('U',?,?,?,?,?)";
		connection = Connector.connect();
		CallableStatement stment = connection.prepareCall(sql);
		stment.setString(1, cliente.getCpf());
		stment.setString(2, cliente.getNome());
		stment.setString(3, cliente.getEmail());
		stment.setFloat(4, cliente.getLimiteDeCredito());
		stment.setDate(5, cliente.getDataNascimento());
		stment.execute();
		stment.close();
		connection.close();
	}
	
	@Override
	public void deletar(Cliente cliente) throws SQLException, ClassNotFoundException {
		String sql = "CALL procd_cliente('D', ?,?,?,?,?)";
		connection = Connector.connect();
		CallableStatement stment = connection.prepareCall(sql);
		stment.setString(1, cliente.getCpf());
		stment.setString(2, "");
		stment.setString(3, "");
		stment.setFloat(4, 0.00f);
		stment.setDate(5, null);
		stment.execute();
		stment.close();
		connection.close();
	}
	
	@Override
	public Cliente consultar(Cliente cliente) throws SQLException, ClassNotFoundException {
		connection = Connector.connect();
		//Cliente cliente = new Cliente();
		String sql = "SELECT nome, email,limite_de_credito,dt_nascimento FROM cliente WHERE cpf = ?";
		PreparedStatement stment = connection.prepareStatement(sql);
		stment.setString(1, cliente.getCpf());
		ResultSet res = stment.executeQuery();
		if(res.next()) {
			cliente.setNome(res.getString("nome"));
			cliente.setEmail(res.getString("email"));
			cliente.setLimiteDeCredito(res.getFloat("limite_de_credito"));
			cliente.setDataNascimento(res.getDate("dt_nascimento"));
		}
		return cliente;
	}
	
	@Override
	public List<Cliente> consultarTodos() throws SQLException, ClassNotFoundException {
		connection = Connector.connect();
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "SELECT cpf, nome, email, limite_de_credito, dt_nascimento FROM cliente";
		PreparedStatement stment = connection.prepareStatement(sql);
		ResultSet res = stment.executeQuery();
		while(res.next()) {
			Cliente cliente = new Cliente();
			cliente.setCpf(res.getString("cpf"));
			cliente.setNome(res.getString("nome"));
			cliente.setEmail(res.getString("email"));
			cliente.setLimiteDeCredito(res.getFloat("limite_de_credito"));
			cliente.setDataNascimento(res.getDate("dt_nascimento"));
			clientes.add(cliente);
		}
		return clientes;
	}
}
