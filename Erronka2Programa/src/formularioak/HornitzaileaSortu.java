package formularioak;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import klaseak.Hornitzailea;
import mantenimendua.HornitzaileakKudeatu;

public class HornitzaileaSortu extends JDialog {

	private JTextField txtIzena, txtDeskripzioa, txtTelefonoa, txtEmail;
	private HornitzaileakKudeatu dao;

	public HornitzaileaSortu(JFrame parent, HornitzaileakKudeatu dao) {
		super(parent, "Hornitzailea Sortu", true);
		this.dao = dao;

		getContentPane().setLayout(new GridLayout(8, 2));
		setSize(400, 350);
		setLocationRelativeTo(parent);

		getContentPane().add(new JLabel("     Izena:"));
		txtIzena = new JTextField();
		getContentPane().add(txtIzena);

		getContentPane().add(new JLabel("     Deskripzioa:"));
		txtDeskripzioa = new JTextField();
		getContentPane().add(txtDeskripzioa);

		getContentPane().add(new JLabel("     Telefonoa:"));
		txtTelefonoa = new JTextField();
		getContentPane().add(txtTelefonoa);

		getContentPane().add(new JLabel("     Email:"));
		txtEmail = new JTextField();
		getContentPane().add(txtEmail);

		JButton btnSave = new JButton("Gorde");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hornitzailea Hornitzailea = new Hornitzailea(0, txtIzena.getText(), txtDeskripzioa.getText(),
						txtTelefonoa.getText(), txtEmail.getText());
				dao.sortuHornitzailea(Hornitzailea);
				JOptionPane.showMessageDialog(HornitzaileaSortu.this, "Hornitzailea sortu da!");
				dispose();
			}
		});
		getContentPane().add(btnSave);

		setVisible(true);
	}
}
