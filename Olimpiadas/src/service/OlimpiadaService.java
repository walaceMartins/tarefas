package service;

import java.util.ArrayList;

import dao.OlimpiadaDAO;
import model.Modalidade;
import model.Olimpiada;

public class OlimpiadaService {
static OlimpiadaDAO dao = new OlimpiadaDAO();

	//olimpiada
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
	// modalidade
	public void criar1(Olimpiada mod) {
		dao.criar(mod);
	}
	
	public void atualizar1(Olimpiada mod){
		dao.atualizar(mod);
	}
	
	
	public static ArrayList<Modalidade> ListarModalidade() {
		return dao.listarModalidade();
	}
	public static  ArrayList<Modalidade> listarModalidade(String chave) {
		return dao.listarModalidade(chave);
		
	}
}
