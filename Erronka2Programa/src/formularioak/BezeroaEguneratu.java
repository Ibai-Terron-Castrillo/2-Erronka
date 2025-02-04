package formularioak;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import klaseak.Bezeroa;
import mantenimendua.BezeroakKudeatu;
public class BezeroaEguneratu extends JDialog {

    private JTextField txtIzena, txtAbizenak, txtErabiltzailea, txtEmail, txtTelefonoa, txtNan;
    private JPasswordField txtPasahitza;
    private BezeroakKudeatu dao;
    private Bezeroa bezeroa;

    public BezeroaEguneratu(JFrame parent, BezeroakKudeatu dao, Bezeroa bezeroa) {
        super(parent, "Bezeroa Eguneratu", true);
        this.dao = dao;
        this.bezeroa = bezeroa;

        setLayout(new GridLayout(8, 2));
        setSize(400, 350);
        setLocationRelativeTo(parent);

        add(new JLabel("     Izena:"));
        txtIzena = new JTextField(bezeroa.getIzena());
        add(txtIzena);

        add(new JLabel("     Abizenak:"));
        txtAbizenak = new JTextField(bezeroa.getAbizenak());
        add(txtAbizenak);

        add(new JLabel("     Erabiltzailea:"));
        txtErabiltzailea = new JTextField(bezeroa.getErabiltzailea());
        add(txtErabiltzailea);

        add(new JLabel("     Email:"));
        txtEmail = new JTextField(bezeroa.getEmail());
        add(txtEmail);

        add(new JLabel("     Telefonoa:"));
        txtTelefonoa = new JTextField(bezeroa.getTelefonoa());
        add(txtTelefonoa);

        add(new JLabel("     NAN:"));
        txtNan = new JTextField(bezeroa.getNan());
        add(txtNan);

        add(new JLabel("     Pasahitza:"));
        txtPasahitza = new JPasswordField(bezeroa.getPasahitza());
        add(txtPasahitza);

        JButton btnSave = new JButton("Eguneratu");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pasahitza = new String(txtPasahitza.getPassword());
                bezeroa.setIzena(txtIzena.getText());
                bezeroa.setAbizenak(txtAbizenak.getText());
                bezeroa.setErabiltzailea(txtErabiltzailea.getText());
                bezeroa.setEmail(txtEmail.getText());
                bezeroa.setTelefonoa(txtTelefonoa.getText());
                bezeroa.setNan(txtNan.getText());
                bezeroa.setPasahitza(pasahitza);

                dao.eguneratuBezeroa(bezeroa);
                JOptionPane.showMessageDialog(BezeroaEguneratu.this, "Bezeroa eguneratu da!");
                dispose();
            }
        });
        add(btnSave);

        setVisible(true);
    }
}

