package mantenimendua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import klaseak.langilea;
import util.DatabaseConnection;

public class LangileakKudeatu {

	public langilea lortuLangilea(langilea lan) {
		
		langilea langilea = null;

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conn = DatabaseConnection.getConnection();
			String sql = "select * from langilea where Erabiltzailea=? and Pasahitza=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, lan.getErabiltzailea());
			pst.setString(2, lan.getPasahitza());

			rs = pst.executeQuery();

			while (rs.next()) {
				langilea = new langilea(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getBoolean(11));
			}
		} catch (Exception e) {
			System.out.println("Errorea");
		}
		return langilea;
	}
}
