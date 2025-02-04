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

public class BezeroaSortu extends JDialog {

    private JTextField txtIzena, txtAbizenak, txtErabiltzailea, txtEmail, txtTelefonoa, txtNan;
    private JPasswordField txtPasahitza;
    private BezeroakKudeatu dao;

    public BezeroaSortu(JFrame parent, BezeroakKudeatu dao) {
        super(parent, "Bezeroa Sortu", true);
        this.dao = dao;

        getContentPane().setLayout(new GridLayout(8, 2));
        setSize(400, 350);
        setLocationRelativeTo(parent);

        getContentPane().add(new JLabel("     Izena:"));
        txtIzena = new JTextField();
        getContentPane().add(txtIzena);

        getContentPane().add(new JLabel("     Abizenak:"));
        txtAbizenak = new JTextField();
        getContentPane().add(txtAbizenak);

        getContentPane().add(new JLabel("     Erabiltzailea:"));
        txtErabiltzailea = new JTextField();
        getContentPane().add(txtErabiltzailea);

        getContentPane().add(new JLabel("     Email:"));
        txtEmail = new JTextField();
        getContentPane().add(txtEmail);

        getContentPane().add(new JLabel("     Telefonoa:"));
        txtTelefonoa = new JTextField();
        getContentPane().add(txtTelefonoa);

        getContentPane().add(new JLabel("     NAN:"));
        txtNan = new JTextField();
        getContentPane().add(txtNan);

        getContentPane().add(new JLabel("     Pasahitza:"));
        txtPasahitza = new JPasswordField();
        getContentPane().add(txtPasahitza);

        JButton btnSave = new JButton("Gorde");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pasahitza = new String(txtPasahitza.getPassword());
                Bezeroa bezeroa = new Bezeroa(0, txtIzena.getText(), txtAbizenak.getText(), txtErabiltzailea.getText(),
                        pasahitza, txtEmail.getText(), txtTelefonoa.getText(), txtNan.getText());
                dao.sortuBezeroa(bezeroa);
                JOptionPane.showMessageDialog(BezeroaSortu.this, "Bezeroa sortu da!");
                dispose();
            }
        });
        getContentPane().add(btnSave);

        setVisible(true);
    }
}

