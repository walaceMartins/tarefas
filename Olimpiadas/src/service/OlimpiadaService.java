package service;

import java.util.ArrayList;

import dao.OlimpiadaDAO;
import model.Modalidade;
import model.Olimpiada;

public class OlimpiadaService {
static OlimpiadaDAO dao = new OlimpiadaDAO();

	//olimpiada
	public void criar(Olimpiada olimpiada) {
		dao.criar(olimpiada);
	}
	
	public void atualizar(Olimpiada olimpiada){
		dao.atualizar(olimpiada);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	

	public Olimpiada carregar(int id){
		return dao.carregar(id);
	}
	// modalidade
	public void criar(Olimpiada modalidade) {
		dao.criar(modalidade);
	}
	
	public void atualizar(Olimpiada modalidade){
		dao.atualizar(modalidade);
	}
	
	
	public static ArrayList<Modalidade> ListarModalidade() {
		return dao.listarModalidade();
	}
	public static  ArrayList<Modalidade> listarModalidade(String chave) {
		return dao.listarModalidade(chave);
		
	}
}
