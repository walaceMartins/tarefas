package service;

import dao.AnoDAO;
import model.Ano;

public class AnoService {
	AnoDAO  dao = new AnoDAO();

	   public int Ano(Ano ano) {
			return dao.criar(ano);
		}
		
		public void atualizar(Ano ano){
			dao.atualizar(ano);
		}
		
		public void excluir(int id){
			dao.excluir(id);
		}
		
		public Ano carregar(int id){
			return dao.carregar(id);
		}
}
