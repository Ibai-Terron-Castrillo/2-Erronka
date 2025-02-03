package mantenimendua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "SELECT idGarraiolaria, Izena, Helbidea, Abizenak, Nan, Telefonoa, Enpresa "
                + "FROM garraiolaria "
                + "WHERE CAST(idGarraiolaria AS CHAR) LIKE ? "
                + "OR Izena LIKE ? "
                + "OR Abizenak LIKE ? "
                + "OR Nan LIKE ? "
                + "OR Telefonoa LIKE ? "
                + "OR Enpresa LIKE ?";
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
            System.out.println("Errorea");
        }
        return lista;
    }
}

