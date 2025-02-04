package mantenimendua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import klaseak.Bezeroa;
import util.DatabaseConnection;

public class BezeroakKudeatu {

	public List<Bezeroa> lortuBezeroak() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Bezeroa> lista = new ArrayList<>();
		try {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM bezeroa";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("idBezeroa");
				String izena = rs.getString("izena");
				String abizenak = rs.getString("abizenak");
				String erabiltzailea = rs.getString("erabiltzailea");
				String pasahitza = rs.getString("pasahitza");
				String email = rs.getString("email");
				String telefonoa = rs.getString("telefonoa");
				String nan = rs.getString("nan");

				Bezeroa b = new Bezeroa(id, izena, abizenak, erabiltzailea, pasahitza, email, telefonoa, nan);
				lista.add(b);
			}
		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}

	public List<Bezeroa> filtratuBezeroak(String irizpidea) {
		List<Bezeroa> lista = new ArrayList<>();
		String sql = "SELECT idBezeroa, izena, abizenak, erabiltzailea, pasahitza, email, telefonoa, nan "
				+ "FROM bezeroa " + "WHERE CAST(idBezeroa AS CHAR) LIKE ? " + "OR izena LIKE ? " + "OR abizenak LIKE ? "
				+ "OR email LIKE ? " + "OR telefonoa LIKE ? " + "OR nan LIKE ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = DatabaseConnection.getConnection();
			ps = conn.prepareStatement(sql);

			String likeIrizpidea = "%" + irizpidea + "%";
			ps.setString(1, likeIrizpidea);
			ps.setString(2, likeIrizpidea);
			ps.setString(3, likeIrizpidea);
			ps.setString(4, likeIrizpidea);
			ps.setString(5, likeIrizpidea);
			ps.setString(6, likeIrizpidea);

			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idBezeroa");
				String izena = rs.getString("izena");
				String abizenak = rs.getString("abizenak");
				String erabiltzailea = rs.getString("erabiltzailea");
				String pasahitza = rs.getString("pasahitza");
				String email = rs.getString("email");
				String telefonoa = rs.getString("telefonoa");
				String nan = rs.getString("nan");

				Bezeroa b = new Bezeroa(id, izena, abizenak, erabiltzailea, pasahitza, email, telefonoa, nan);
				lista.add(b);
			}

		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}
	
	public void sortuBezeroa(Bezeroa bezeroa) {
	    String sql = "INSERT INTO bezeroa (izena, abizenak, erabiltzailea, pasahitza, email, telefonoa, nan) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, bezeroa.getIzena());
	        ps.setString(2, bezeroa.getAbizenak());
	        ps.setString(3, bezeroa.getErabiltzailea());
	        ps.setString(4, bezeroa.getPasahitza());
	        ps.setString(5, bezeroa.getEmail());
	        ps.setString(6, bezeroa.getTelefonoa());
	        ps.setString(7, bezeroa.getNan());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void eguneratuBezeroa(Bezeroa bezeroa) {
	    String sql = "UPDATE bezeroa SET izena = ?, abizenak = ?, erabiltzailea = ?, pasahitza = ?, email = ?, telefonoa = ?, nan = ? WHERE idBezeroa = ?";
	    try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, bezeroa.getIzena());
	        ps.setString(2, bezeroa.getAbizenak());
	        ps.setString(3, bezeroa.getErabiltzailea());
	        ps.setString(4, bezeroa.getPasahitza());
	        ps.setString(5, bezeroa.getEmail());
	        ps.setString(6, bezeroa.getTelefonoa());
	        ps.setString(7, bezeroa.getNan());
	        ps.setInt(8, bezeroa.getIdBezeroa());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void ezabatuBezeroa(int idBezeroa) {
	    String sql = "DELETE FROM bezeroa WHERE idBezeroa = ?";
	    try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, idBezeroa);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}



}