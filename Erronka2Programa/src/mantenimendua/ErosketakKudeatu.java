package mantenimendua;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import klaseak.Erosketa;
import util.DatabaseConnection;

public class ErosketakKudeatu {

    public void sortuErosketa(Erosketa erosketa) {
        String sql = "INSERT INTO erosketa (ProduktuKantitatea, data, ProduktuPrezioa, ProduktuIrudia, ProduktuEgoera, ProduktuMota, ProduktuIzena, idHornitzailea) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, erosketa.getProduktuKantitatea());
            pst.setDate(2, erosketa.getData());
            pst.setDouble(3, erosketa.getProduktuPrezioa());
            pst.setString(4, erosketa.getProduktuIrudia());
            pst.setString(5, erosketa.getProduktuEgoera());
            pst.setString(6, erosketa.getProduktuMota());
            pst.setString(7, erosketa.getProduktuIzena());
            pst.setInt(8, erosketa.getIdHornitzailea());

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Erosketa> lortuErosketak() {
        List<Erosketa> lista = new ArrayList<>();
        String sql = "SELECT * FROM erosketa";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idErosketa = rs.getInt("idErosketa");
                int produktuKantitatea = rs.getInt("ProduktuKantitatea");
                Date data = rs.getDate("data");
                double produktuPrezioa = rs.getDouble("ProduktuPrezioa");
                String produktuIrudia = rs.getString("ProduktuIrudia");
                String produktuEgoera = rs.getString("ProduktuEgoera");
                String produktuMota = rs.getString("ProduktuMota");
                String produktuIzena = rs.getString("ProduktuIzena");
                int idHornitzailea = rs.getInt("idHornitzailea");

                Erosketa erosketa = new Erosketa(idErosketa, produktuKantitatea, data, produktuPrezioa, produktuIrudia, produktuEgoera, produktuMota, produktuIzena, idHornitzailea);
                lista.add(erosketa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Erosketa> filtratuErosketak(String irizpidea) {
        List<Erosketa> lista = new ArrayList<>();
        String sql = "SELECT * FROM erosketa WHERE ProduktuIzena LIKE ? OR ProduktuMota LIKE ? OR ProduktuEgoera LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            String likeIrizpidea = "%" + irizpidea + "%";
            pst.setString(1, likeIrizpidea);
            pst.setString(2, likeIrizpidea);
            pst.setString(3, likeIrizpidea);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int idErosketa = rs.getInt("idErosketa");
                    int produktuKantitatea = rs.getInt("ProduktuKantitatea");
                    Date data = rs.getDate("data");
                    double produktuPrezioa = rs.getDouble("ProduktuPrezioa");
                    String produktuIrudia = rs.getString("ProduktuIrudia");
                    String produktuEgoera = rs.getString("ProduktuEgoera");
                    String produktuMota = rs.getString("ProduktuMota");
                    String produktuIzena = rs.getString("ProduktuIzena");
                    int idHornitzailea = rs.getInt("idHornitzailea");

                    Erosketa erosketa = new Erosketa(idErosketa, produktuKantitatea, data, produktuPrezioa, produktuIrudia, produktuEgoera, produktuMota, produktuIzena, idHornitzailea);
                    lista.add(erosketa);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void ezabatuErosketa(int idErosketa) {
        String sql = "DELETE FROM erosketa WHERE idErosketa = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, idErosketa);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eguneratuErosketa(Erosketa erosketa) {
        String sql = "UPDATE erosketa SET ProduktuKantitatea = ?, data = ?, ProduktuPrezioa = ?, ProduktuIrudia = ?, ProduktuEgoera = ?, ProduktuMota = ?, ProduktuIzena = ?, idHornitzailea = ? WHERE idErosketa = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, erosketa.getProduktuKantitatea());
            pst.setDate(2, erosketa.getData());
            pst.setDouble(3, erosketa.getProduktuPrezioa());
            pst.setString(4, erosketa.getProduktuIrudia());
            pst.setString(5, erosketa.getProduktuEgoera());
            pst.setString(6, erosketa.getProduktuMota());
            pst.setString(7, erosketa.getProduktuIzena());
            pst.setInt(8, erosketa.getIdHornitzailea());
            pst.setInt(9, erosketa.getIdErosketa());

            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
