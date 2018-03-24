package service;
import dao.OlimpiadaDAO;
import model.Olimpiada;
 
 public class OlimpiadaService {
	 OlimpiadaDAO dao = new OlimpiadaDAO();
   
   public int criar(Olimpiada olimpiada) {
		return dao.criar(olimpiada);
	}
	
	public void atualizar(Olimpiada Olimpiada){
		dao.atualizar(Olimpiada);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Olimpiada carregar(int id){
		return dao.carregar(id);
	}
}

