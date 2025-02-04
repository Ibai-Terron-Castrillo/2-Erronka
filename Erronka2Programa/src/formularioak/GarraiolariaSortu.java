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

public class GarraiolariaSortu extends JDialog {

	private JTextField txtIzena, txtHelbidea, txtAbizenak, txtNan, txtTelefonoa, txtEnpresa;
	private GarraiolariaKudeatu dao;

	public GarraiolariaSortu(JFrame parent, GarraiolariaKudeatu dao) {
		super(parent, "Garraiolaria Sortu", true);
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

		getContentPane().add(new JLabel("     Helbidea:"));
		txtHelbidea = new JTextField();
		getContentPane().add(txtHelbidea);

		getContentPane().add(new JLabel("     Enpresa:"));
		txtEnpresa = new JTextField();
		getContentPane().add(txtEnpresa);

		getContentPane().add(new JLabel("     Telefonoa:"));
		txtTelefonoa = new JTextField();
		getContentPane().add(txtTelefonoa);

		getContentPane().add(new JLabel("     NAN:"));
		txtNan = new JTextField();
		getContentPane().add(txtNan);

		JButton btnSave = new JButton("Gorde");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Garraiolaria Garraiolaria = new Garraiolaria(0, txtIzena.getText(), txtHelbidea.getText(),
						txtAbizenak.getText(), txtNan.getText(), txtTelefonoa.getText(), txtEnpresa.getText());
				dao.sortuGarraiolaria(Garraiolaria);
				JOptionPane.showMessageDialog(GarraiolariaSortu.this, "Garraiolaria sortu da!");
				dispose();
			}
		});
		getContentPane().add(btnSave);

		setVisible(true);
	}
}
