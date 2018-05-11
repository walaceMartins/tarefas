package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Modalidade;
import model.Olimpiada;
import model.Pais;

public class OlimpiadaDAO {
	public void criar(Olimpiada olim) {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, olim.getNome());
			stm.setString(2, olim.getTipo());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Olimpiada olim) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, olim.getNome());
			stm.setString(2, olim.getTipo());
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
		Olimpiada olim = new Olimpiada();
		Pais pais = new Pais();
		Modalidade mod = new Modalidade();
		
		mod.setId(id);
		pais.setId(id);
		String sqlSelect = "SELECT oura, prata, bronze,  FROM olimpiada WHERE olimpiada.idAno = ? and olimpiada.idModalidade = ? and olimpiada.idPais = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, pais.getId());
			stm.setInt(2, mod.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					olim.setNome(rs.getString("nome"));
					olim.setTipo(rs.getString("tipo"));
				} else {
					pais.setId(-1);
					olim.setNome(null);
					olim.setTipo(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return olim;
	}
}
