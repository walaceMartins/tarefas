package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Modalidade;
import service.ModalidadeService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OlimpiadaTest {
	Modalidade modalidade, copia;
	ModalidadeService modalidadeService;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		modalidade = new Modalidade();
		modalidade.setId(id);
		modalidade.setNome("salto com vara");
		modalidade.setTipo("inverno");
		copia = new Modalidade();
		copia.setId(id);
		copia.setNome("salto com vara");
		copia.setTipo("inverno");
		modalidadeService = new ModalidadeService();
		System.out.println(modalidade);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Modalidade fixture = new Modalidade();
		fixture.setId(1);
		fixture.setNome("salto com vara");
		fixture.setTipo("inverno");
		ModalidadeService novoService = new ModalidadeService();
		Modalidade novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = modalidadeService.criar(modalidade);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", modalidade, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		modalidade.setnome("Ginástica Rítmica");
		copia.setnome("Ginástica Rítmica");		
		modalidadeService.atualizar(modalidade);
		modalidade = modalidadeService.carregar(modalidade.getId());
		assertEquals("testa atualizacao",modalidade, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setTipo(null);
		modalidadeService.excluir(id);
		modalidade =modalidadeService.carregar(id);
		assertEquals("testa exclusao", modalidade, copia);
	}
}