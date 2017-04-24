
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.ConectarMySQL;
import Control.Semaforo;

public class DAOsemaforo {

	public DAOsemaforo() {	}

	public Semaforo pegarTempos(String nomeSinal) throws SQLException {
		Semaforo semaforo = new Semaforo();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConectarMySQL.getConnection();
			String sql = "SELECT tempoverde, tempoamarelo, tempovermelho from "+nomeSinal;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				semaforo = new Semaforo(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			rs.close();
			pstmt.close();
			conn.rollback();
			e.printStackTrace();
		} finally {
			ConectarMySQL.devolveconexao(conn);
		}
		return semaforo;
	}
	
	public int quantidadeCarros(String rua) throws SQLException {
		int qtd = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConectarMySQL.getConnection();
			String sql = "SELECT "+rua+" from ruas";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				qtd = rs.getInt(1);
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			rs.close();
			pstmt.close();
			conn.rollback();
			e.printStackTrace();
		} finally {
			ConectarMySQL.devolveconexao(conn);
		}
		return qtd;
	}

	public int atualiza(String nomeSinal, Semaforo semaforo) throws SQLException {
		String sql;
		int a = 0;
		sql = "UPDATE "+nomeSinal+" SET tempoverde = ?, tempoamarelo = ?, tempovermelho = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConectarMySQL.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, semaforo.getTempoverde());
			pstmt.setInt(2, semaforo.getTempoamarelo());
			pstmt.setInt(3, semaforo.getTempovermelho());
			a = pstmt.executeUpdate();
			pstmt.close();
			return a;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			ConectarMySQL.devolveconexao(conn);
		}
	}

}
