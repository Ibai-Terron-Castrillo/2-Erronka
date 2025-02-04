package mantenimendua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import klaseak.Hornitzailea;
import util.DatabaseConnection;

public class HornitzaileakKudeatu {

	public List<Hornitzailea> lortuHornitzaileak() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Hornitzailea> lista = new ArrayList<>();
		try {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM Hornitzailea";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("idHornitzailea");
				String Izena = rs.getString("Izena");
				String Deskripzioa = rs.getString("Deskripzioa");
				String Telefonoa = rs.getString("Telefonoa");
				String Email = rs.getString("Email");

				Hornitzailea b = new Hornitzailea(id, Izena, Deskripzioa, Telefonoa, Email);
				lista.add(b);
			}
		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}

	public List<Hornitzailea> filtratuHornitzaileak(String irizpidea) {
		List<Hornitzailea> lista = new ArrayList<>();
		String sql = "SELECT * " + "FROM Hornitzailea " + "WHERE CAST(idHornitzailea AS CHAR) LIKE ? "
				+ "OR izena LIKE ? " + "OR Deskripzioa LIKE ? " + "OR telefonoa LIKE ? " + "OR email LIKE ? ";
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

			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idHornitzailea");
				String Izena = rs.getString("Izena");
				String Deskripzioa = rs.getString("Deskripzioa");
				String Telefonoa = rs.getString("Telefonoa");
				String Email = rs.getString("Email");

				Hornitzailea b = new Hornitzailea(id, Izena, Deskripzioa, Telefonoa, Email);
				lista.add(b);
			}

		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}

	public void sortuHornitzailea(Hornitzailea Hornitzailea) {
		String sql = "INSERT INTO Hornitzailea (Izena, Deskripzioa, Telefonoa, Email) VALUES (?, ?, ?, ?)";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Hornitzailea.getIzena());
			ps.setString(2, Hornitzailea.getDeskripzioa());
			ps.setString(3, Hornitzailea.getTelefonoa());
			ps.setString(4, Hornitzailea.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eguneratuHornitzailea(Hornitzailea Hornitzailea) {
		String sql = "UPDATE Hornitzailea SET Izena = ?, Deskripzioa = ?, Telefonoa = ?, Email = ? WHERE idHornitzailea = ?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Hornitzailea.getIzena());
			ps.setString(2, Hornitzailea.getDeskripzioa());
			ps.setString(3, Hornitzailea.getTelefonoa());
			ps.setString(4, Hornitzailea.getEmail());
			ps.setInt(5, Hornitzailea.getIdHornitzailea());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ezabatuHornitzailea(int idHornitzailea) {
		String sql = "DELETE FROM Hornitzailea WHERE idHornitzailea = ?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idHornitzailea);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}