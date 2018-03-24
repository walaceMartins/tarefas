package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Olimpiada;
import service.OlimpiadaService;


FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModalidadeTest {
	Olimpiada olimpiada, copia;
	OlimpiadaService olimpiadaService;
	static int id = 0;
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		Olimpiada = new Olimpiada();
		olimpiada.setId(id);
		olimpiada.setOuro("1");
		olimpiada.setPrata("2");
		olimpiada.setBronze("3");
		copia = new Olimpiada();
		copia.setId(id);
		copia.setOuro("1");
		copia.setPrata("2");
		copia.setBronze("3");
		OlimpiadaService = new OlimpiadaService();
		System.out.println(olimpiada);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Olimpiada fixture = new Olimpiada();
		fixture.setId(1);
		fixture.setOuro("2");
		fixture.setPrata("3");
		fixture.setBronze("1");
		OlimpiadaService novoService = new OlimpiadaService();
		Olimpiada novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = olimpiadaService.criar(olimpiada);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", olimpiada, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		olimpiada.setBronze("12");
		copia.setBronze("12");		
		olimpiadaService.atualizar(olimpiada);
		olimpiada = olimpiadaService.carregar(olimpiada.getId());
		assertEquals("testa atualizacao",olimpiada, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setOuro(0);
		copia.setPrata(0);
		copia.setBronze(0);
		olimpiadaService.excluir(id);
		olimpiada =olimpiadaService.carregar(id);
		assertEquals("testa exclusao", olimpiada, copia);
	}
}