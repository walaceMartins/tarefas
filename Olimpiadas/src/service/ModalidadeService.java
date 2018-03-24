package service;
import model.Modalidade;
import model.Pais;
import dao.ModalidadeDAO;
public class ModalidadeService {
   ModalidadeDAO  dao = new ModalidadeDAO();

   public int criar(Modalidade modalidade) {
		return dao.criar(modalidade);
	}
	
	public void atualizar(Modalidade modalidade){
		dao.atualizar(modalidade);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Modalidade carregar(int id){
		return dao.carregar(id);
	}

   
}
