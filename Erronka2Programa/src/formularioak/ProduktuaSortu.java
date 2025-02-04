package formularioak;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import mantenimendua.BiltegiaKudeatu;
import klaseak.Biltegia;

public class ProduktuaSortu extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField izenaField, motaField, egoeraField, irudiaField, prezioaField, kantitateaField;
    private BiltegiaKudeatu dao;

    public ProduktuaSortu(JFrame parent, BiltegiaKudeatu dao) {
        setTitle("Produktu Berria Sortu");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.dao = dao;
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        
        panel.add(new JLabel("Izena:"));
        izenaField = new JTextField();
        panel.add(izenaField);
        
        panel.add(new JLabel("Mota:"));
        motaField = new JTextField();
        panel.add(motaField);
        
        panel.add(new JLabel("Egoera:"));
        egoeraField = new JTextField();
        panel.add(egoeraField);
        
        panel.add(new JLabel("Irudi ID:"));
        irudiaField = new JTextField();
        panel.add(irudiaField);
        
        panel.add(new JLabel("Prezioa:"));
        prezioaField = new JTextField();
        panel.add(prezioaField);
        
        panel.add(new JLabel("Kantitatea:"));
        kantitateaField = new JTextField();
        panel.add(kantitateaField);
        
        JButton gordeButton = new JButton("Gorde");
        gordeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gordeProduktuBerria();
            }
        });
        panel.add(gordeButton);
        
        JButton itxiButton = new JButton("Itxi");
        itxiButton.addActionListener(e -> dispose());
        panel.add(itxiButton);
        
        add(panel, BorderLayout.CENTER);
    }

    private void gordeProduktuBerria() {
        try {
            String izena = izenaField.getText();
            String mota = motaField.getText();
            String egoera = egoeraField.getText();
            String irudia = irudiaField.getText();
            double prezioa = Double.parseDouble(prezioaField.getText());
            int kantitatea = Integer.parseInt(kantitateaField.getText());
            
            if (izena.isEmpty() || mota.isEmpty() || egoera.isEmpty() || irudia.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mesedez, bete guztiak eremuak.", "Errorea", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Biltegia produktua = new Biltegia(0, izena, mota, egoera, irudia, prezioa, kantitatea);
            dao.sortuProduktua(produktua);
            JOptionPane.showMessageDialog(this, "Produktua ondo gehitu da!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sartu balio zuzenak prezio eta kantitatean.", "Errorea", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Errorea: " + ex.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }
}
