package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dao.ClienteDAO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Acesso a pagina pelo metodo GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		
		ClienteDAO DAO = new ClienteDAO();
		
		String option = request.getParameter("botao");
		
		if(option.contains("Inserir")) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			float limiteCredito = Float.parseFloat(request.getParameter("limite_credito"));
			Date dataNascimento = Date.valueOf(request.getParameter("data_nascimento"));
			Cliente cliente = new Cliente(cpf, nome, email, limiteCredito, dataNascimento);
			try {
				DAO.inserir(cliente);
				request.getRequestDispatcher("http://app-web-procedures/").forward(request, response);
			} 
			catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		if(option.contains("Atualizar")) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			float limiteCredito = Float.parseFloat(request.getParameter("limite_credito"));
			Date dataNascimento = Date.valueOf(request.getParameter("data_nascimento"));
			Cliente cliente = new Cliente(cpf, nome, email, limiteCredito, dataNascimento);
			try {
				DAO.atualizar(cliente);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		if(option.contains("Deletar")) {
			Cliente cliente = new Cliente();
			cliente.setCpf(cpf);
			try {
				DAO.deletar(cliente);
			} 
			
			catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		if(option.contains("Consultar")) {
			Cliente cliente = new Cliente();
			cliente.setCpf(cpf);
			try {
				cliente = DAO.consultar(cliente);
				request.setAttribute("cliente", cliente);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
		if(option.contains("Listar")) {
			try {
				List<Cliente> clientes = DAO.consultarTodos();
				request.setAttribute("clientes", clientes);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} 
			
			catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
	}

}
