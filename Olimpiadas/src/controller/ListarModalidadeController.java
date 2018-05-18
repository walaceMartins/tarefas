package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Modalidade;
import model.Olimpiada;
import service.OlimpiadaService;

/**
 * Servlet implementation class ListarModalidadeController
 */
@WebServlet("/ListarModalidadeController.do")
public class ListarModalidadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		String acao = request.getParameter("acao");
		OlimpiadaService pais = new OlimpiadaService();
		ArrayList<Modalidade> lista = null;
		HttpSession session = request.getSession();
		if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				lista = OlimpiadaService.listarModalidade(chave);
			} else {
				lista = OlimpiadaService.ListarModalidade();
			}
			session.setAttribute("lista", lista);
		} else if (acao.equals("reiniciar")) {
			session.setAttribute("lista", null);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarModalidade.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}