package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Ano;
import service.AnoService;

FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnoTest {
	Ano ano, copia;
	AnoService AnoService;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		ano = new Ano();
		ano.setId(id);
		ano.setAno("2002");
		ano.setTipo("inverno");
		copia = new Ano);
		copia.setId(id);
		copia.setAno("2002");
		copia.setTipo("inverno");
		anoService = new AnoService();
		System.out.println(ano);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Ano fixture = new Ano();
		fixture.setId(1);
		fixture.setAno("2001");
		fixture.setTipo("verão");
		AnoService novoService = new AnoService();
		Ano novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = anoService.criar(ano);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", ano, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		ano.setAno("1999");
		copia.setAno("1999");		
		anoService.atualizar(ano);
		ano = anoService.carregar(ano.getId());
		assertEquals("testa atualizacao",ano, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setAno(0);
		copia.setTipo(null);
		anoService.excluir(id);
		ano =anoService.carregar(id);
		assertEquals("testa exclusao", ano, copia);
	}
}