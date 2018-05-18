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
			Modalidade mod = new Modalidade();
			mod.setNome(pNome);
			mod.setOuro(pOuro);
			mod.setPrata(pPrata);
			mod.setBronze(pBronze);

			//instanciar o service
			OlimpiadaService os = new OlimpiadaService();
			RequestDispatcher view = null;
			HttpSession session = request.getSession();

			if (pAcao.equals("Criar")) {
				os.criar1(mod);
				ArrayList<Modalidade>lista = new ArrayList<>();
				lista.add(mod);
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarModalidade.jsp");
				} else if (pAcao.equals("Excluir")) {
				os.excluir(mod.getId());
				ArrayList<Modalidade> lista =
				(ArrayList<Modalidade>)session.getAttribute("lista");
				lista.remove(busca(mod, lista));
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarModalidade.jsp");
				} else if (pAcao.equals("Alterar")) {
				os.atualizar1(mod);
				ArrayList<Modalidade> lista =
				(ArrayList<Modalidade>)session.getAttribute("lista");
				int pos = busca(mod, lista);
				lista.remove(pos);
				lista.add(pos, mod);
				session.setAttribute("lista", lista);
				request.setAttribute("modalidade", mod);
				view = request.getRequestDispatcher("VisualizarModalidade.jsp");
				} else if (pAcao.equals("Visualizar")) {
				mod = os.carregar(mod.getId());
				request.setAttribute("modalidade", mod);
				view = request.getRequestDispatcher("VisualizarModalidade.jsp");
				} else if (pAcao.equals("Editar")) {
				mod = os.carregar(mod.getId());
				request.setAttribute("modalidade", mod);
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