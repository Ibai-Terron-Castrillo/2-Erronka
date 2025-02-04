package mantenimendua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import klaseak.Garraiolaria;
import klaseak.Garraiolaria;
import util.DatabaseConnection;

public class GarraiolariaKudeatu {

	public List<Garraiolaria> lortuGarraiolariak() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Garraiolaria> lista = new ArrayList<>();
		try {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM garraiolaria";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				int idGarraiolaria = rs.getInt("idGarraiolaria");
				String Izena = rs.getString("Izena");
				String Helbidea = rs.getString("Helbidea");
				String Abizenak = rs.getString("Abizenak");
				String Nan = rs.getString("Nan");
				String Telefonoa = rs.getString("Telefonoa");
				String Enpresa = rs.getString("Enpresa");

				Garraiolaria g = new Garraiolaria(idGarraiolaria, Izena, Helbidea, Abizenak, Nan, Telefonoa, Enpresa);
				lista.add(g);
			}
		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}

	public List<Garraiolaria> filtratuGarraiolariak(String irizpidea) {
		List<Garraiolaria> lista = new ArrayList<>();
		String sql = "SELECT idGarraiolaria, Izena, Helbidea, Abizenak, Nan, Telefonoa, Enpresa " + "FROM garraiolaria "
				+ "WHERE CAST(idGarraiolaria AS CHAR) LIKE ? " + "OR Izena LIKE ? " + "OR Helbidea LIKE ? "
				+ "OR Abizenak LIKE ? " + "OR Nan LIKE ? " + "OR Telefonoa LIKE ? " + "OR Enpresa LIKE ?";
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
			ps.setString(7, likeIrizpidea);

			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idGarraiolaria");
				String izena = rs.getString("Izena");
				String helbidea = rs.getString("Helbidea");
				String abizenak = rs.getString("Abizenak");
				String nan = rs.getString("Nan");
				String telefonoa = rs.getString("Telefonoa");
				String enpresa = rs.getString("Enpresa");

				Garraiolaria g = new Garraiolaria(id, izena, helbidea, abizenak, nan, telefonoa, enpresa);
				lista.add(g);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return lista;
	}

	public void sortuGarraiolaria(Garraiolaria Garraiolaria) {
		String sql = "INSERT INTO Garraiolaria (Izena, Helbidea, Abizenak, Nan, Telefonoa, Enpresa) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Garraiolaria.getIzena());
			ps.setString(2, Garraiolaria.getHelbidea());
			ps.setString(3, Garraiolaria.getAbizenak());
			ps.setString(4, Garraiolaria.getNan());
			ps.setString(5, Garraiolaria.getTelefonoa());
			ps.setString(6, Garraiolaria.getEnpresa());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eguneratuGarraiolaria(Garraiolaria Garraiolaria) {
		String sql = "UPDATE Garraiolaria SET Izena = ?, Helbidea = ?, Abizenak = ?, Nan = ?, Telefonoa = ?, Enpresa = ? WHERE idGarraiolaria = ?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Garraiolaria.getIzena());
			ps.setString(2, Garraiolaria.getHelbidea());
			ps.setString(3, Garraiolaria.getAbizenak());
			ps.setString(4, Garraiolaria.getNan());
			ps.setString(5, Garraiolaria.getTelefonoa());
			ps.setString(6, Garraiolaria.getEnpresa());
			ps.setInt(7, Garraiolaria.getIdGarraiolaria());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ezabatuGarraiolaria(int idGarraiolaria) {
		String sql = "DELETE FROM Garraiolaria WHERE idGarraiolaria = ?";
		try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idGarraiolaria);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}