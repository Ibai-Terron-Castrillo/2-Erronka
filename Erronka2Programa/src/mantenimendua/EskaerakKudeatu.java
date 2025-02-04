package mantenimendua;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import klaseak.Eskaera;
import util.DatabaseConnection;

public class EskaerakKudeatu {

	public List<Eskaera> lortuEskaerak() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Eskaera> lista = new ArrayList<>();
		try {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM eskaera";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("idEskaera");
				Date data = rs.getDate("data");
				String helbidea = rs.getString("helbidea");
				String eskaeraEgoera = rs.getString("eskaeraEgoera");
				int idEskaera = rs.getInt("idEskaera");
				int idGarraiolaria = rs.getInt("idGarraiolaria");
				
				Eskaera b = new Eskaera(id, data, helbidea, eskaeraEgoera, idEskaera, idGarraiolaria);
				lista.add(b);
			}
		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}

	public List<Eskaera> filtratuEskaerak(String irizpidea) {
		List<Eskaera> lista = new ArrayList<>();
		String sql = "SELECT idEskaera, data, helbidea, eskaeraEgoera, idEskaera, idGarraiolaria "
				+ "FROM eskaera " + "WHERE CAST(idEskaera AS CHAR) LIKE ? " + "OR data LIKE ? " + "OR helbidea LIKE ? "
				+ "OR eskaeraEgoera LIKE ? " + "OR CAST(idEskaera AS CHAR) LIKE ? " + "OR CAST(idGarraiolaria AS CHAR) LIKE ?";
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
				int id = rs.getInt("idEskaera");
				Date data = rs.getDate("data");
				String helbidea = rs.getString("helbidea");
				String eskaeraEgoera = rs.getString("eskaeraEgoera");
				int idEskaera = rs.getInt("idEskaera");
				int idGarraiolaria = rs.getInt("idGarraiolaria");
				
				Eskaera b = new Eskaera(id, data, helbidea, eskaeraEgoera, idEskaera, idGarraiolaria);
				lista.add(b);
			}

		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}
	public void sortuEskaera(Eskaera Eskaera) {
	    String sql = "INSERT INTO Eskaera (data, helbidea, eskaeraEgoera, idBezeroa, idGarraiolaria) VALUES (?, ?, ?, ?, ?)";
	    try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setDate(1, Eskaera.getData());
	        ps.setString(2, Eskaera.getHelbidea());
	        ps.setString(3, Eskaera.getEskaeraEgoera());
	        ps.setInt(4, Eskaera.getIdBezeroa());
	        ps.setInt(5, Eskaera.getIdGarraiolaria());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void eguneratuEskaera(Eskaera Eskaera) {

	    String sql = "UPDATE Eskaera SET data = ?, helbidea = ?, eskaeraEgoera = ?, idBezeroa = ?, idGarraiolaria = ? WHERE idEskaera = ?";
	    try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, Eskaera.getData());
	        ps.setString(2, Eskaera.getHelbidea());
	        ps.setString(3, Eskaera.getEskaeraEgoera());
	        ps.setInt(4, Eskaera.getIdBezeroa());
	        ps.setInt(5, Eskaera.getIdGarraiolaria());
	        ps.setInt(6, Eskaera.getIdEskaera());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void ezabatuEskaera(int idEskaera) {
	    String sql = "DELETE FROM Eskaera WHERE idEskaera = ?";
	    try {
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, idEskaera);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}