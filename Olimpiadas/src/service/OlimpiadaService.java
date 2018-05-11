package service;

import dao.OlimpiadaDAO;
import model.Olimpiada;
import model.Pais;

public class OlimpiadaService {
OlimpiadaDAO dao = new OlimpiadaDAO();
	
	public void criar(Olimpiada olim) {
		dao.criar(olim);
	}
	
	public void atualizar(Olimpiada olim){
		dao.atualizar(olim);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	

	public Olimpiada carregar(int id){
		return dao.carregar(id);
	}
}
