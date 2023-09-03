package dao;

import java.sql.SQLException;
import java.util.List;

import model.Cliente;

public class ClienteDAO implements DAO<Cliente>{

	@Override
	public void inserir(Cliente e) throws SQLException, ClassNotFoundException {
	}
	
	@Override
	public void atualizar(Cliente e) throws SQLException, ClassNotFoundException {
	}
	
	@Override
	public void deletar(Cliente e) throws SQLException, ClassNotFoundException {
	}
	
	@Override
	public Cliente consultar() throws SQLException, ClassNotFoundException {
		return null;
	}
	
	@Override
	public List<Cliente> consultarTodos() throws SQLException, ClassNotFoundException {
		return null;
	}
}
