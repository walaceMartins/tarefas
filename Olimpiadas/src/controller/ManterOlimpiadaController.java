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
import model.Pais;
import service.OlimpiadaService;
import service.PaisService;


/**
 * Servlet implementation class ManterOlimpiadaController
 */
@WebServlet("/ManterOlimpiadaController.do")
public class ManterOlimpiadaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
			doPost(request, response);
			}

			protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				String pAcao = request.getParameter("acao");
				String pId = request.getParameter("id");
				String pNome = request.getParameter("nome");
				String pTipo = request.getParameter("tipo");
				
				int id = -1;
				try {
				id = Integer.parseInt(pNome);
				} catch (NumberFormatException e) {
				}
			Olimpiada olimpiada = new Olimpiada();
			olimpiada.setNome(pNome);
			olimpiada.setTipo(pTipo);
			

			//instanciar o service
			OlimpiadaService os = new OlimpiadaService();
			RequestDispatcher view = null;
			HttpSession session = request.getSession();

			if (pAcao.equals("Criar")) {
				os.criar(olimpiada);
				ArrayList<Olimpiada>lista = new ArrayList<>();
				lista.add(olimpiada);
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarOlimpiada.jsp");
				} else if (pAcao.equals("Excluir")) {
				os.excluir(olimpiada.getId());
				ArrayList<Olimpiada> lista =
				(ArrayList<Olimpiada>)session.getAttribute("lista");
				lista.remove(busca(olimpiada, lista));
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarOlimpiada.jsp");
				} else if (pAcao.equals("Alterar")) {
				os.atualizar(olimpiada);
				ArrayList<Olimpiada> lista =
				(ArrayList<Olimpiada>)session.getAttribute("lista");
				int pos = busca(olimpiada, lista);
				lista.remove(pos);
				lista.add(pos, olimpiada);
				session.setAttribute("lista", lista);
				request.setAttribute("olimpiada", olimpiada);
				view = request.getRequestDispatcher("VisualizarOlimpiada.jsp");
				} else if (pAcao.equals("Visualizar")) {
					olimpiada = os.carregar(olimpiada.getId());
				request.setAttribute("olimpiada", olimpiada);
				view = request.getRequestDispatcher("VisualizarOlimpiada.jsp");
				} else if (pAcao.equals("Editar")) {
					olimpiada = os.carregar(olimpiada.getId());
				request.setAttribute("olimpiada", olimpiada);
				view = request.getRequestDispatcher("AlterarOlimpiada.jsp");
				}
				view.forward(request, response);
				}
				public int busca(Olimpiada olimpiada, ArrayList<Olimpiada> lista) {
				Olimpiada to;
				for(int i = 0; i < lista.size(); i++){
				to = lista.get(i);
				if(to.getId() == olimpiada.getId()){
				return i;
				}
				}
				return -1;
				}
			}
