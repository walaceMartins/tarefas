package Pais;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais;
	static int id = 0;
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais(id, "japao", "231223", "231234.22" );
		System.out.println(pais);
	
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		
		Pais fixture = new Pais(1, "Brasil", "2331133", "2312134.44" );
		Pais novo = new Pais(1, null, null, null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		assertEquals("testa criacao", pais);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao("231234132");		
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		pais.excluir();
		pais.carregar();
		assertEquals("testa exclusao", pais);
	}
	@Test
	public void test04MaiorHabitantes() {
		System.out.println("Nome do pais");
		System.out.println("Nome do pais");
		pais.MaiorHabitantes();
		pais.MaiorHabitantes();
		System.out.println("testa maior populacão", pais);
		}
	public void test05MenorArea() {
		pais.MenorArea();
		System.out.println("testa maior populacão", pais);
		}
	public void test06Vetor() {
		pais.vetor();
		System.out.println("Os três Países", vetor);
		}
}