package mantenimendua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import klaseak.Eskaera_Biltegia;
import util.DatabaseConnection;

public class EskBilKudeatu {

	public List<Eskaera_Biltegia> lortuEskaera_Biltegiak() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Eskaera_Biltegia> lista = new ArrayList<>();
		try {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM Eskaera_Biltegia";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				int idEskaera = rs.getInt("idEskaera");
				int ProduktuId = rs.getInt("ProduktuId");
				int Kantitatea = rs.getInt("Kantitatea");
				double GuztiraPrezioa = rs.getDouble("GuztiraPrezioa");
				Eskaera_Biltegia b = new Eskaera_Biltegia(idEskaera, ProduktuId, Kantitatea, GuztiraPrezioa);
				lista.add(b);
			}
		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}

	public List<Eskaera_Biltegia> filtratuEskaera_Biltegiak(String irizpidea) {
		List<Eskaera_Biltegia> lista = new ArrayList<>();
		String sql = "SELECT *"
				+ "FROM Eskaera_Biltegia " + "WHERE CAST(idEskaera AS CHAR) LIKE ? " + "OR CAST(ProduktuId AS CHAR) LIKE ? " + "OR CAST(Kantitatea AS CHAR) LIKE ? "
				+ "OR CAST(GuztiraPrezioa AS CHAR) LIKE ? ";
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

			rs = ps.executeQuery();
			while (rs.next()) {
				int idEskaera = rs.getInt("idEskaera");
				int ProduktuId = rs.getInt("ProduktuId");
				int Kantitatea = rs.getInt("Kantitatea");
				double GuztiraPrezioa = rs.getDouble("GuztiraPrezioa");
				Eskaera_Biltegia b = new Eskaera_Biltegia(idEskaera, ProduktuId, Kantitatea, GuztiraPrezioa);
				lista.add(b);
			}

		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}



}