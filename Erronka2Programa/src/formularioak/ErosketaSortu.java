package formularioak;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import klaseak.Erosketa;
import mantenimendua.ErosketakKudeatu;

public class ErosketaSortu extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField kantitateaField, dataField, prezioaField, irudiaField, egoeraField, motaField, izenaField, hornitzaileaField;
    private ErosketakKudeatu dao;
    private Erosketak parent;

    public ErosketaSortu(Erosketak parent, ErosketakKudeatu dao) {
        super(parent, "Erosketa Sortu", true);
        this.parent = parent;
        this.dao = dao;
        
        JPanel panel = new JPanel(new GridLayout(9, 2));
        panel.add(new JLabel("Produktu Kantitatea:"));
        kantitateaField = new JTextField();
        panel.add(kantitateaField);
        
        panel.add(new JLabel("Data (YYYY-MM-DD):"));
        dataField = new JTextField();
        panel.add(dataField);
        
        panel.add(new JLabel("Produktu Prezioa:"));
        prezioaField = new JTextField();
        panel.add(prezioaField);
        
        panel.add(new JLabel("Produktu Irudia:"));
        irudiaField = new JTextField();
        panel.add(irudiaField);
        
        panel.add(new JLabel("Produktu Egoera:"));
        egoeraField = new JTextField();
        panel.add(egoeraField);
        
        panel.add(new JLabel("Produktu Mota:"));
        motaField = new JTextField();
        panel.add(motaField);
        
        panel.add(new JLabel("Produktu Izena:"));
        izenaField = new JTextField();
        panel.add(izenaField);
        
        panel.add(new JLabel("Hornitzaile ID:"));
        hornitzaileaField = new JTextField();
        panel.add(hornitzaileaField);
        
        JButton btnSortu = new JButton("Sortu");
        btnSortu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortuErosketa();
            }
        });
        
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnSortu);
        
        add(panel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(parent);
    }

    private void sortuErosketa() {
        try {
            int kantitatea = Integer.parseInt(kantitateaField.getText());
            Date data = Date.valueOf(dataField.getText());
            double prezioa = Double.parseDouble(prezioaField.getText());
            String irudia = irudiaField.getText();
            String egoera = egoeraField.getText();
            String mota = motaField.getText();
            String izena = izenaField.getText();
            int hornitzailea = Integer.parseInt(hornitzaileaField.getText());
            
            Erosketa erosketa = new Erosketa(0, kantitatea, data, prezioa, irudia, egoera, mota, izena, hornitzailea);
            dao.sortuErosketa(erosketa);
            parent.taulaBirkargatu();
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Datuak okerrak dira!", "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }
}