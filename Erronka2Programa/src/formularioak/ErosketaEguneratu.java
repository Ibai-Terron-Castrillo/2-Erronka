package formularioak;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import klaseak.Erosketa;
import mantenimendua.ErosketakKudeatu;

public class ErosketaEguneratu extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField txtKantitatea, txtData, txtPrezioa, txtIrudia, txtEgoera, txtMota, txtIzena, txtHornitzailea;
    private ErosketakKudeatu dao;
    private Erosketa erosketa;

    public ErosketaEguneratu(Erosketak frame, ErosketakKudeatu dao, Erosketa erosketa) {
        super(frame, "Erosketa Eguneratu", true);
        this.dao = dao;
        this.erosketa = erosketa;
        
        setSize(400, 400);
        setLocationRelativeTo(frame);
        
        JPanel panel = new JPanel(new GridLayout(9, 2));
        panel.add(new JLabel("Produktu Kantitatea:"));
        txtKantitatea = new JTextField(String.valueOf(erosketa.getProduktuKantitatea()));
        panel.add(txtKantitatea);
        
        panel.add(new JLabel("Data (YYYY-MM-DD):"));
        txtData = new JTextField(erosketa.getData().toString());
        panel.add(txtData);
        
        panel.add(new JLabel("Produktu Prezioa:"));
        txtPrezioa = new JTextField(String.valueOf(erosketa.getProduktuPrezioa()));
        panel.add(txtPrezioa);
        
        panel.add(new JLabel("Produktu Irudia:"));
        txtIrudia = new JTextField(erosketa.getProduktuIrudia());
        panel.add(txtIrudia);
        
        panel.add(new JLabel("Produktu Egoera:"));
        txtEgoera = new JTextField(erosketa.getProduktuEgoera());
        panel.add(txtEgoera);
        
        panel.add(new JLabel("Produktu Mota:"));
        txtMota = new JTextField(erosketa.getProduktuMota());
        panel.add(txtMota);
        
        panel.add(new JLabel("Produktu Izena:"));
        txtIzena = new JTextField(erosketa.getProduktuIzena());
        panel.add(txtIzena);
        
        panel.add(new JLabel("Hornitzaile ID:"));
        txtHornitzailea = new JTextField(String.valueOf(erosketa.getIdHornitzailea()));
        panel.add(txtHornitzailea);
        
        JButton btnEguneratu = new JButton("Eguneratu");
        btnEguneratu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eguneratuErosketa();
            }
        });
        
        JPanel botoiPanel = new JPanel();
        botoiPanel.add(btnEguneratu);
        
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(botoiPanel, BorderLayout.SOUTH);
    }

    private void eguneratuErosketa() {
        try {
            int kantitatea = Integer.parseInt(txtKantitatea.getText());
            Date data = Date.valueOf(txtData.getText());
            double prezioa = Double.parseDouble(txtPrezioa.getText());
            String irudia = txtIrudia.getText();
            String egoera = txtEgoera.getText();
            String mota = txtMota.getText();
            String izena = txtIzena.getText();
            int hornitzailea = Integer.parseInt(txtHornitzailea.getText());
            
            erosketa.setProduktuKantitatea(kantitatea);
            erosketa.setData(data);
            erosketa.setProduktuPrezioa(prezioa);
            erosketa.setProduktuIrudia(irudia);
            erosketa.setProduktuEgoera(egoera);
            erosketa.setProduktuMota(mota);
            erosketa.setProduktuIzena(izena);
            erosketa.setIdHornitzailea(hornitzailea);
            
            dao.eguneratuErosketa(erosketa);
            JOptionPane.showMessageDialog(this, "Erosketa eguneratu da!");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Errorea datuak eguneratzean", "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }
}
