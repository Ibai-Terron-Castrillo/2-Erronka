package mantenimendua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import klaseak.Global;
import util.DatabaseConnection;

public class GlobalaKudeatu {

	public List<Global> lortuGlobala() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Global> lista = new ArrayList<>();
		try {
		    conn = DatabaseConnection.getConnection();
		    String sql = "SELECT Eskaera.idEskaera AS EskaeraID, " +
		        "CONCAT(Bezeroa.Izena, ' ', Bezeroa.Abizenak) AS Bezeroa, " +
		        "Bezeroa.Email AS Email, " +
		        "Bezeroa.Telefonoa AS Telefonoa, " +
		        "Eskaera.data AS 'Eskaera Data', " +
		        "Eskaera.helbidea AS Helbidea, " +
		        "GROUP_CONCAT(CONCAT(biltegia.ProduktuIzena, ' (', ' x ', eskaera_biltegia.Kantitatea, ')') SEPARATOR ', ') AS Produktuak, " +
		        "CONCAT(SUM(eskaera_biltegia.Kantitatea * biltegia.ProduktuPrezioa), '€') AS Guztira, " +
		        "CONCAT(garraiolaria.Izena, ' ', garraiolaria.Abizenak, ' | ', garraiolaria.Enpresa) AS Garraiolaria, " +
		        "eskaeraEgoera AS 'Eskaera Egoera' " +
		        "FROM Bezeroa " +
		        "INNER JOIN Eskaera ON Bezeroa.idBezeroa = Eskaera.idBezeroa " +
		        "INNER JOIN eskaera_biltegia ON Eskaera.idEskaera = eskaera_biltegia.idEskaera " +
		        "INNER JOIN biltegia ON eskaera_biltegia.ProduktuId = biltegia.ProduktuId " +
		        "INNER JOIN garraiolaria ON Eskaera.idGarraiolaria = garraiolaria.idGarraiolaria " +
		        "GROUP BY Eskaera.idEskaera " +
		        "ORDER BY Eskaera.data DESC";

		    pst = conn.prepareStatement(sql);
		    rs = pst.executeQuery();

		    while (rs.next()) {
		        int eskaeraID = rs.getInt("EskaeraID");
		        String bezeroa = rs.getString("Bezeroa");
		        String email = rs.getString("Email");
		        String telefonoa = rs.getString("Telefonoa");
		        String eskaeraData = rs.getString("Eskaera Data");
		        String helbidea = rs.getString("Helbidea");
		        String produktuak = rs.getString("Produktuak");
		        String guztira = rs.getString("Guztira");
		        String garraiolaria = rs.getString("Garraiolaria");
		        String eskaeraEgoera = rs.getString("Eskaera Egoera");

		        Global b = new Global(eskaeraID, bezeroa, email, telefonoa, eskaeraData, helbidea, produktuak, guztira, garraiolaria, eskaeraEgoera);
		        lista.add(b);
		    }
		} catch (Exception e) {
		    e.printStackTrace();  // Muestra el error exacto en la consola
		} finally {
		    try {
		        if (rs != null) rs.close();
		        if (pst != null) pst.close();
		        if (conn != null) conn.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}
		return lista;
	}

	public List<Global> filtratuGlobala(String irizpidea) {
		List<Global> lista = new ArrayList<>();
		String sql = "SELECT Eskaera.idEskaera AS EskaeraID, " +
		        "CONCAT(Bezeroa.Izena, ' ', Bezeroa.Abizenak) AS Bezeroa, " +
		        "Bezeroa.Email AS Email, " +
		        "Bezeroa.Telefonoa AS Telefonoa, " +
		        "Eskaera.data AS 'Eskaera Data', " +
		        "Eskaera.helbidea AS Helbidea, " +
		        "GROUP_CONCAT(CONCAT(biltegia.ProduktuIzena, ' (', ' x ', eskaera_biltegia.Kantitatea, ')') SEPARATOR ', ') AS Produktuak, " +
		        "CONCAT(SUM(eskaera_biltegia.Kantitatea * biltegia.ProduktuPrezioa), '€') AS Guztira, " +
		        "CONCAT(garraiolaria.Izena, ' ', garraiolaria.Abizenak, ' | ', garraiolaria.Enpresa) AS Garraiolaria, " +
		        "eskaeraEgoera AS 'Eskaera Egoera' " +
		        "FROM Bezeroa " +
		        "INNER JOIN Eskaera ON Bezeroa.idBezeroa = Eskaera.idBezeroa " +
		        "INNER JOIN eskaera_biltegia ON Eskaera.idEskaera = eskaera_biltegia.idEskaera " +
		        "INNER JOIN biltegia ON eskaera_biltegia.ProduktuId = biltegia.ProduktuId " +
		        "INNER JOIN garraiolaria ON Eskaera.idGarraiolaria = garraiolaria.idGarraiolaria " +
		        "WHERE CAST(Eskaera.idEskaera AS CHAR) LIKE ? " +
		        "OR Bezeroa.Izena LIKE ? " +
		        "OR Bezeroa.Abizenak LIKE ? " +
		        "OR Bezeroa.Email LIKE ? " +
		        "OR Bezeroa.Telefonoa LIKE ? " +
		        "OR Eskaera.data LIKE ? " +
		        "OR Eskaera.helbidea LIKE ? " +
		        "OR biltegia.ProduktuIzena LIKE ? " +
		        "OR biltegia.ProduktuPrezioa LIKE ? " +
		        "OR eskaeraEgoera LIKE ? " +
		        "GROUP BY Eskaera.idEskaera " +
		        "ORDER BY Eskaera.data DESC;";
		
		
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
			ps.setString(8, likeIrizpidea);
			ps.setString(9, likeIrizpidea);
			ps.setString(10, likeIrizpidea);

			rs = ps.executeQuery();
			while (rs.next()) {
				
				int eskaeraID = rs.getInt("EskaeraID");
		        String bezeroa = rs.getString("Bezeroa");
		        String email = rs.getString("Email");
		        String telefonoa = rs.getString("Telefonoa");
		        String eskaeraData = rs.getString("Eskaera Data");
		        String helbidea = rs.getString("Helbidea");
		        String produktuak = rs.getString("Produktuak");
		        String guztira = rs.getString("Guztira");
		        String garraiolaria = rs.getString("Garraiolaria");
		        String eskaeraEgoera = rs.getString("Eskaera Egoera");

		        Global b = new Global(eskaeraID, bezeroa, email, telefonoa, eskaeraData, helbidea, produktuak, guztira, garraiolaria, eskaeraEgoera);
		        lista.add(b);
			}

		} catch (Exception e) {
		    e.printStackTrace();  // Muestra el error exacto en la consola
		} finally {
		    try {
		        if (rs != null) rs.close();
		        if (ps != null) ps.close();
		        if (conn != null) conn.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}
		return lista;
	}
}