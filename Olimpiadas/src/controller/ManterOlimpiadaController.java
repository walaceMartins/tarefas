package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Olimpiada;
import service.OlimpiadaService;



/**
 * Servlet implementation class ManterModalidadeController
 */
@WebServlet("/ManterModalidadeController.do")
public class ManterOlimpiadaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
			doPost(request, response);
			}

			protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {

			String pNome = request.getParameter("Nome");
            String pTipo = request.getParameter("Tipo");
			//instanciar o javabean
			Olimpiada olimpiada = new Olimpiada();
			olimpiada.setNome(pNome);
			olimpiada.setTipo(pTipo);

			//instanciar o service
			OlimpiadaService os = new OlimpiadaService();
			os.criar(olimpiada);
			olimpiada = os.carregar(olimpiada.getId());

			//enviar para o jsp
			request.setAttribute("modalidade", olimpiada);

			RequestDispatcher view =
			request.getRequestDispatcher("Modalidade.jsp");
			view.forward(request, response);
			}
			}