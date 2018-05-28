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

@WebServlet("/ManterModalidadeController.do")
public class ManterModalidadeController extends HttpServlet {
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
				String pOuro = request.getParameter("ouro");
				String pPrata = request.getParameter("prata");
				String pBronze = request.getParameter("bronze");
				int id = -1;
				try {
				id = Integer.parseInt(pNome);
				} catch (NumberFormatException e) {
				}
			Modalidade modalidade = new Modalidade();
			modalidade.setNome(pNome);
			modalidade.setOuro(pOuro);
			modalidade.setPrata(pPrata);
			modalidade.setBronze(pBronze);

			//instanciar o service
			OlimpiadaService os = new OlimpiadaService();
			RequestDispatcher view = null;
			HttpSession session = request.getSession();

			if (pAcao.equals("Criar")) {
				os.criar(modalidade);
				ArrayList<Modalidade>lista = new ArrayList<>();
				lista.add(modalidade);
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarModalidade.jsp");
				} else if (pAcao.equals("Excluir")) {
				os.excluir(modalidade.getId());
				ArrayList<Modalidade> lista =
				(ArrayList<Modalidade>)session.getAttribute("lista");
				lista.remove(busca(modalidade, lista));
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarModalidade.jsp");
				} else if (pAcao.equals("Alterar")) {
				os.atualizar1(modalidade);
				ArrayList<Modalidade> lista =
				(ArrayList<Modalidade>)session.getAttribute("lista");
				int pos = busca(modalidade, lista);
				lista.remove(pos);
				lista.add(pos, modalidade);
				session.setAttribute("lista", lista);
				request.setAttribute("modalidade", modalidade);
				view = request.getRequestDispatcher("VisualizarModalidade.jsp");
				} else if (pAcao.equals("Visualizar")) {
					modalidade = os.carregar(modalidade.getId());
				request.setAttribute("modalidade", modalidade);
				view = request.getRequestDispatcher("VisualizarModalidade.jsp");
				} else if (pAcao.equals("Editar")) {
					modalidade = os.carregar(modalidade.getId());
				request.setAttribute("modalidade", modalidade);
				view = request.getRequestDispatcher("AlterarModalidade.jsp");
				}
				view.forward(request, response);
				}
				public int busca(Modalidade mod, ArrayList<Modalidade> lista) {
				Modalidade to;
				for(int i = 0; i < lista.size(); i++){
				to = lista.get(i);
				if(to.getId() == mod.getId()){
				return i;
				}
				}
				return -1;
				}
			}