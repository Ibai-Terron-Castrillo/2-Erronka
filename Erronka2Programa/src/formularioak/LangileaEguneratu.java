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
public class LangileaEguneratu extends JDialog {

    private JTextField txtIzena, txtAbizenak, txtErabiltzailea, txtEmail, txtTelefonoa, txtNan, txtHelbidea, txtLangileKodea, txtAdmin;
    private JPasswordField txtPasahitza;
    private LangileakKudeatu dao;
    private langilea langilea;

    public LangileaEguneratu(JFrame parent, LangileakKudeatu dao, langilea langilea) {
        super(parent, "langilea Eguneratu", true);
        this.dao = dao;
        this.langilea = langilea;
        setSize(614, 882);
        setLocationRelativeTo(parent);
        getContentPane().setLayout(null);

        JLabel label = new JLabel("     Izena:");
        label.setBounds(49, 20, 253, 73);
        getContentPane().add(label);
        txtIzena = new JTextField(langilea.getIzena());
        txtIzena.setBounds(302, 20, 253, 73);
        getContentPane().add(txtIzena);

        JLabel label_1 = new JLabel("     Abizenak:");
        label_1.setBounds(49, 92, 253, 73);
        getContentPane().add(label_1);
        txtAbizenak = new JTextField(langilea.getAbizenak());
        txtAbizenak.setBounds(302, 92, 253, 73);
        getContentPane().add(txtAbizenak);

        JLabel label_2 = new JLabel("     Erabiltzailea:");
        label_2.setBounds(49, 240, 253, 73);
        getContentPane().add(label_2);
        txtErabiltzailea = new JTextField(langilea.getErabiltzailea());
        txtErabiltzailea.setBounds(302, 240, 253, 73);
        getContentPane().add(txtErabiltzailea);

        JLabel label_3 = new JLabel("     Email:");
        label_3.setBounds(49, 166, 253, 73);
        getContentPane().add(label_3);
        txtEmail = new JTextField(langilea.getEmail());
        txtEmail.setBounds(302, 166, 253, 73);
        getContentPane().add(txtEmail);

        JLabel label_4 = new JLabel("     Telefonoa:");
        label_4.setBounds(49, 314, 253, 73);
        getContentPane().add(label_4);
        txtTelefonoa = new JTextField(langilea.getTelefonoa());
        txtTelefonoa.setBounds(302, 314, 253, 73);
        getContentPane().add(txtTelefonoa);

        JLabel label_5 = new JLabel("     NAN:");
        label_5.setBounds(49, 389, 253, 73);
        getContentPane().add(label_5);
        txtNan = new JTextField(langilea.getNan());
        txtNan.setBounds(302, 389, 253, 73);
        getContentPane().add(txtNan);
        
        JLabel label_6 = new JLabel("     Helbidea:");
        label_6.setBounds(49, 533, 253, 73);
        getContentPane().add(label_6);
        txtHelbidea = new JTextField(langilea.getHelbidea());
        txtHelbidea.setBounds(302, 533, 253, 73);
        getContentPane().add(txtHelbidea);
        
        JLabel label_7 = new JLabel("     Langile Kodea:");
        label_7.setBounds(49, 460, 253, 73);
        getContentPane().add(label_7);
        txtLangileKodea = new JTextField(String.valueOf(langilea.getLangileKodea()));
        txtLangileKodea.setBounds(302, 460, 253, 73);
        getContentPane().add(txtLangileKodea);
        
        JLabel label_8 = new JLabel("     Admin:");
        label_8.setBounds(49, 608, 253, 73);
        getContentPane().add(label_8);
        txtAdmin = new JTextField(String.valueOf(langilea.isAdmin()));
        txtAdmin.setBounds(302, 608, 253, 73);
        getContentPane().add(txtAdmin);

        JLabel label_9 = new JLabel("     Pasahitza:");
        label_9.setBounds(49, 679, 253, 73);
        getContentPane().add(label_9);
        txtPasahitza = new JPasswordField(langilea.getPasahitza());
        txtPasahitza.setBounds(302, 679, 253, 73);
        getContentPane().add(txtPasahitza);

        JButton btnSave = new JButton("Eguneratu");
        btnSave.setBounds(179, 762, 253, 73);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pasahitza = new String(txtPasahitza.getPassword());
                langilea.setIzena(txtIzena.getText());
                langilea.setAbizenak(txtAbizenak.getText());
                langilea.setErabiltzailea(txtErabiltzailea.getText());
                langilea.setEmail(txtEmail.getText());
                langilea.setTelefonoa(txtTelefonoa.getText());
                langilea.setNan(txtNan.getText());
                langilea.setHelbidea(txtHelbidea.getText());
                langilea.setLangileKodea(Integer.parseInt(txtLangileKodea.getText()));
                langilea.setAdmin(Boolean.parseBoolean(txtAdmin.getText()));
                langilea.setPasahitza(pasahitza);

                dao.eguneratuLangilea(langilea);
                JOptionPane.showMessageDialog(LangileaEguneratu.this, "Langilea eguneratu da!");
                dispose();
            }
        });
        getContentPane().add(btnSave);

        setVisible(true);
    }
}

