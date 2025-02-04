
package formularioak;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import mantenimendua.BiltegiaKudeatu;
import klaseak.Biltegia;

public class BiltegiaEguneratu extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField idField, izenaField, motaField, egoeraField, irudiaField, prezioaField, kantitateaField;
    private BiltegiaKudeatu dao;
    private Biltegia biltegia;
    public BiltegiaEguneratu(JFrame parent, BiltegiaKudeatu dao, Biltegia biltegia) {
    	super("Produktua Eguneratu");
        this.dao = dao;
        this.biltegia = biltegia;
        setTitle("Produktu Eguneratu");
        setSize(400, 350);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        dao = new BiltegiaKudeatu();
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        
        panel.add(new JLabel("Produktu ID:"));
        idField = new JTextField(String.valueOf(biltegia.getProduktuId()));
        panel.add(idField);
        
        panel.add(new JLabel("Izena:"));
        izenaField = new JTextField(biltegia.getProduktuIzena());
        panel.add(izenaField);
        
        panel.add(new JLabel("Mota:"));
        motaField = new JTextField(biltegia.getProduktuMota());
        panel.add(motaField);
        
        panel.add(new JLabel("Egoera:"));
        egoeraField = new JTextField(biltegia.getProduktuEgoera());
        panel.add(egoeraField);
        
        panel.add(new JLabel("Irudia:"));
        irudiaField = new JTextField(biltegia.getProduktuIruId());
        panel.add(irudiaField);
        
        panel.add(new JLabel("Prezioa:"));
        prezioaField = new JTextField(String.valueOf(biltegia.getProduktuPrezioa()));
        panel.add(prezioaField);
        
        panel.add(new JLabel("Kantitatea:"));
        kantitateaField = new JTextField(String.valueOf(biltegia.getProduktuKantitatea()));
        panel.add(kantitateaField);
        
        JButton eguneratuButton = new JButton("Eguneratu");
        eguneratuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eguneratuProduktu();
            }
        });
        panel.add(eguneratuButton);
        
        JButton itxiButton = new JButton("Itxi");
        itxiButton.addActionListener(e -> dispose());
        panel.add(itxiButton);
        
        add(panel, BorderLayout.CENTER);
    }

    private void eguneratuProduktu() {
        try {
            int id = Integer.parseInt(idField.getText());
            String izena = izenaField.getText();
            String mota = motaField.getText();
            String egoera = egoeraField.getText();
            String irudia = irudiaField.getText();
            double prezioa = Double.parseDouble(prezioaField.getText());
            int kantitatea = Integer.parseInt(kantitateaField.getText());
            
            Biltegia produktua = new Biltegia(id, izena, mota, egoera, irudia, prezioa, kantitatea);
            dao.eguneratuBiltegia(produktua);
            JOptionPane.showMessageDialog(this, "Produktua ondo eguneratu da!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Sartu balio zuzenak ID, prezio eta kantitatean.", "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }
}