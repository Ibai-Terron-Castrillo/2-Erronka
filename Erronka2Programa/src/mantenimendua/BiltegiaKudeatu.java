package mantenimendua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import klaseak.Biltegia;
import util.DatabaseConnection;

public class BiltegiaKudeatu {

	public List<Biltegia> lortuBiltegia() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Biltegia> lista = new ArrayList<>();
		try {
			conn = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM biltegia";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				int ProduktuId = rs.getInt("ProduktuId");
				String ProduktuIzena = rs.getString("ProduktuIzena");
				String ProduktuMota = rs.getString("ProduktuMota");
				String ProduktuEgoera = rs.getString("ProduktuEgoera");
				String ProduktuIruId = rs.getString("ProduktuIruId");
				double ProduktuPrezioa = rs.getDouble("ProduktuPrezioa");
				int ProduktuKantitatea = rs.getInt("ProduktuKantitatea");

				Biltegia b = new Biltegia(ProduktuId, ProduktuIzena, ProduktuMota, ProduktuEgoera, ProduktuIruId,
						ProduktuPrezioa, ProduktuKantitatea);
				lista.add(b);
			}
		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}

	public List<Biltegia> filtratuBiltegia(String irizpidea) {
		List<Biltegia> lista = new ArrayList<>();
		String sql = "SELECT * "
				+ "FROM biltegia " + "WHERE CAST(ProduktuId AS CHAR) LIKE ? " + "OR ProduktuIzena LIKE ? "
				+ "OR ProduktuMota LIKE ? " + "OR ProduktuEgoera LIKE ? " + "OR ProduktuIruId LIKE ? "
				+ "or CAST(ProduktuPrezioa AS CHAR) LIKE ? " + "or CAST(ProduktuKantitatea AS CHAR) LIKE ? ";
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
				int ProduktuId = rs.getInt("ProduktuId");
				String ProduktuIzena = rs.getString("ProduktuIzena");
				String ProduktuMota = rs.getString("ProduktuMota");
				String ProduktuEgoera = rs.getString("ProduktuEgoera");
				String ProduktuIruId = rs.getString("ProduktuIruId");
				double ProduktuPrezioa = rs.getDouble("ProduktuPrezioa");
				int ProduktuKantitatea = rs.getInt("ProduktuKantitatea");

				Biltegia b = new Biltegia(ProduktuId, ProduktuIzena, ProduktuMota, ProduktuEgoera, ProduktuIruId,
						ProduktuPrezioa, ProduktuKantitatea);
				lista.add(b);
			}

		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return lista;
	}
}