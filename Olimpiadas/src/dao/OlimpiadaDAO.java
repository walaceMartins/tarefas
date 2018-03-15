package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Olimpiada;
 
public class OlimpiadaDAO {
	public int criar(Olimpiada olimpiada) {
		String sqlInsert = "INSERT INTO Olimpiada(ouro,prata,bronze) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1,olimpiada.getOuro());
			stm.setInt(2,olimpiada.getPrata());
			stm.setInt(3,olimpiada.getBronze());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					olimpiada.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olimpiada.getId();
	}

	public void atualizar(Olimpiada olimpiada) {
		String sqlUpdate = "UPDATE olimpiada SET ouro=?, prata=?, bronze=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1,olimpiada.getOuro());
			stm.setInt(2,olimpiada.getPrata());
			stm.setInt(3,olimpiada.getBronze());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM olimpiada WHERE id = ?";
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
		olimpiada.setId(id);
		String sqlSelect = "SELECT ouro, prata, bronze FROM olimpiada WHERE olimpiada.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, olimpiada.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					olimpiada.setOuro(rs.getInt("ouro"));
					olimpiada.setPrata(rs.getInt("prata"));
					olimpiada.setBronze(rs.getInt("bronze"));
				} else {
					olimpiada.setId(-1);
					olimpiada.setOuro(0);
					olimpiada.setPrata(0);
					olimpiada.setBronze(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return olimpiada;
	}

}
