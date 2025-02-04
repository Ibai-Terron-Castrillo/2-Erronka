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

import klaseak.Garraiolaria;
import mantenimendua.GarraiolariaKudeatu;
public class GarraiolariaEguneratu extends JDialog {

	private JTextField txtIzena, txtHelbidea, txtAbizenak, txtNan, txtTelefonoa, txtEnpresa;
    private GarraiolariaKudeatu dao;
    private Garraiolaria Garraiolaria;

    public GarraiolariaEguneratu(JFrame parent, GarraiolariaKudeatu dao, Garraiolaria Garraiolaria) {
        super(parent, "Garraiolaria Eguneratu", true);
        this.dao = dao;
        this.Garraiolaria = Garraiolaria;

        setLayout(new GridLayout(8, 2));
        setSize(400, 350);
        setLocationRelativeTo(parent);

        getContentPane().add(new JLabel("     Izena:"));
		txtIzena = new JTextField(Garraiolaria.getIzena());
		getContentPane().add(txtIzena);

		getContentPane().add(new JLabel("     Abizenak:"));
		txtAbizenak = new JTextField(Garraiolaria.getAbizenak());
		getContentPane().add(txtAbizenak);

		getContentPane().add(new JLabel("     Helbidea:"));
		txtHelbidea = new JTextField(Garraiolaria.getHelbidea());
		getContentPane().add(txtHelbidea);

		getContentPane().add(new JLabel("     Enpresa:"));
		txtEnpresa = new JTextField(Garraiolaria.getEnpresa());
		getContentPane().add(txtEnpresa);

		getContentPane().add(new JLabel("     Telefonoa:"));
		txtTelefonoa = new JTextField(Garraiolaria.getTelefonoa());
		getContentPane().add(txtTelefonoa);

		getContentPane().add(new JLabel("     NAN:"));
		txtNan = new JTextField(Garraiolaria.getNan());
		getContentPane().add(txtNan);

        JButton btnSave = new JButton("Eguneratu");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Garraiolaria.setIzena(txtIzena.getText());
                Garraiolaria.setAbizenak(txtAbizenak.getText());
                Garraiolaria.setHelbidea(txtHelbidea.getText());
                Garraiolaria.setEnpresa(txtEnpresa.getText());
                Garraiolaria.setTelefonoa(txtTelefonoa.getText());
                Garraiolaria.setNan(txtNan.getText());

                dao.eguneratuGarraiolaria(Garraiolaria);
                JOptionPane.showMessageDialog(GarraiolariaEguneratu.this, "Garraiolaria eguneratu da!");
                dispose();
            }
        });
        add(btnSave);

        setVisible(true);
    }
}

