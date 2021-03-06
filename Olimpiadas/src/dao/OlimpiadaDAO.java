package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Modalidade;
import model.Olimpiada;
import model.Pais;

public class OlimpiadaDAO {
	public void criar(Olimpiada olimpiada) {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, olimpiada.getNome());
			stm.setString(2, olimpiada.getTipo());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Olimpiada olimpiada) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, olimpiada.getNome());
			stm.setString(2, olimpiada.getTipo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Olimpiada carregar(int id) {
		Olimpiada olimpiada = new Olimpiada();
		Pais pais = new Pais();
		Modalidade modalidade = new Modalidade();
		
		modalidade.setId(id);
		pais.setId(id);
		String sqlSelect = "SELECT oura, prata, bronze,  FROM olimpiada WHERE olimpiada.idAno = ? and olimpiada.idModalidade = ? and olimpiada.idPais = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, pais.getId());
			stm.setInt(2, modalidade.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					olimpiada.setNome(rs.getString("nome"));
					olimpiada.setTipo(rs.getString("tipo"));
				} else {
					pais.setId(-1);
					olimpiada.setNome(null);
					olimpiada.setTipo(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return olimpiada;
	}
	public ArrayList<Modalidade> listarModalidade() {
		Modalidade modaliadade;
		ArrayList<Modalidade> lista = new ArrayList<>();
		String sqlSelect = "SELECT nome,ouro,prata,bronze FROM modalidade";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		try (ResultSet rs = stm.executeQuery();) {
		while (rs.next()) {
		Modalidade modalidade = new Modalidade();
		modalidade.setId(rs.getInt("id"));
		modalidade.setNome(rs.getString("nome"));
		modalidade.setOuro(rs.getString("ouro"));
		modalidade.setPrata(rs.getString("prata"));
		modalidade.setBronze(rs.getString("bronze"));
		lista.add(modalidade);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
		}
		return lista;
		}
		public ArrayList<Modalidade> listarModalidade(String chave) {
		Modalidade mod;
		ArrayList<Modalidade> lista = new ArrayList<>();
		String sqlSelect = "SELECT nome,ouro,prta, bronze FROM modalidade where upper(nome) like ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setString(1, "%" + chave.toUpperCase() + "%");
		try (ResultSet rs = stm.executeQuery();) {
		while (rs.next()) {
		Modalidade modalidade = new Modalidade();
		modalidade.setId(rs.getInt("id"));
		modalidade.setNome(rs.getString("nome"));
		modalidade.setOuro(rs.getString("ouro"));
		modalidade.setPrata(rs.getString("prata"));
		modalidade.setBronze(rs.getString("bronze"));
		lista.add(modalidade);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
		}
		return lista;
		}
	}

