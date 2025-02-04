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

import klaseak.langilea;
import mantenimendua.LangileakKudeatu;

public class LangileaSortu extends JDialog {
    private JTextField txtIzena, txtAbizenak, txtErabiltzailea, txtEmail, txtTelefonoa, txtNan, txtHelbidea, txtLangileKodea, txtAdmin;
    private JPasswordField txtPasahitza;
    private LangileakKudeatu dao;

    public LangileaSortu(JFrame parent, LangileakKudeatu dao) {
        super(parent, "langilea Sortu", true);
        this.dao = dao;
        setSize(296, 624);
        setLocationRelativeTo(parent);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("     Izena:");
        label.setBounds(10, 26, 128, 39);
        getContentPane().add(label);
        txtIzena = new JTextField();
        txtIzena.setBounds(138, 26, 128, 39);
        getContentPane().add(txtIzena);

        JLabel label_1 = new JLabel("     Abizenak:");
        label_1.setBounds(10, 75, 128, 39);
        getContentPane().add(label_1);
        txtAbizenak = new JTextField();
        txtAbizenak.setBounds(138, 75, 128, 39);
        getContentPane().add(txtAbizenak);

        JLabel label_2 = new JLabel("     Erabiltzailea:");
        label_2.setBounds(10, 468, 128, 39);
        getContentPane().add(label_2);
        txtErabiltzailea = new JTextField();
        txtErabiltzailea.setBounds(138, 468, 128, 39);
        getContentPane().add(txtErabiltzailea);

        JLabel label_3 = new JLabel("     Email:");
        label_3.setBounds(10, 124, 128, 39);
        getContentPane().add(label_3);
        txtEmail = new JTextField();
        txtEmail.setBounds(138, 124, 128, 39);
        getContentPane().add(txtEmail);

        JLabel label_4 = new JLabel("     Telefonoa:");
        label_4.setBounds(10, 173, 128, 39);
        getContentPane().add(label_4);
        txtTelefonoa = new JTextField();
        txtTelefonoa.setBounds(138, 173, 128, 39);
        getContentPane().add(txtTelefonoa);

        JLabel label_5 = new JLabel("     NAN:");
        label_5.setBounds(10, 222, 128, 39);
        getContentPane().add(label_5);
        txtNan = new JTextField();
        txtNan.setBounds(138, 222, 128, 39);
        getContentPane().add(txtNan);
        
        JLabel label_6 = new JLabel("     Helbidea:");
        label_6.setBounds(10, 271, 128, 39);
        getContentPane().add(label_6);
        txtHelbidea = new JTextField();
        txtHelbidea.setBounds(138, 271, 128, 39);
        getContentPane().add(txtHelbidea);
        
        JLabel label_7 = new JLabel("     Langile Kodea:");
        label_7.setBounds(10, 320, 128, 39);
        getContentPane().add(label_7);
        txtLangileKodea = new JTextField();
        txtLangileKodea.setBounds(138, 320, 128, 39);
        getContentPane().add(txtLangileKodea);
        
        JLabel label_8 = new JLabel("     Admin:");
        label_8.setBounds(10, 369, 128, 39);
        getContentPane().add(label_8);
        txtAdmin = new JTextField();
        txtAdmin.setBounds(138, 369, 128, 39);
        getContentPane().add(txtAdmin);

        JLabel label_9 = new JLabel("     Pasahitza:");
        label_9.setBounds(10, 418, 128, 39);
        getContentPane().add(label_9);
        txtPasahitza = new JPasswordField();
        txtPasahitza.setBounds(138, 418, 128, 39);
        getContentPane().add(txtPasahitza);

        JButton btnSave = new JButton("Gorde");
        btnSave.setBounds(75, 517, 128, 39);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pasahitza = new String(txtPasahitza.getPassword());
                langilea langilea = new langilea(0, txtIzena.getText(), txtAbizenak.getText(), txtErabiltzailea.getText(),
                        pasahitza, txtEmail.getText(), txtTelefonoa.getText(), txtNan.getText(), txtHelbidea.getText(), Integer.parseInt(txtLangileKodea.getText()), Boolean.parseBoolean(txtAdmin.getText()));
                dao.sortuLangilea(langilea);
                JOptionPane.showMessageDialog(LangileaSortu.this, "Langilea sortu da!");
                dispose();
            }
        });
        getContentPane().add(btnSave);

        setVisible(true);
    }
}

