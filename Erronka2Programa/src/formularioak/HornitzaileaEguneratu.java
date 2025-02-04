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

public class HornitzaileaEguneratu extends JDialog {

	private JTextField txtIzena, txtDeskripzioa, txtEmail, txtTelefonoa;
	private HornitzaileakKudeatu dao;
	private Hornitzailea Hornitzailea;

	public HornitzaileaEguneratu(JFrame parent, HornitzaileakKudeatu dao, Hornitzailea Hornitzailea) {
		super(parent, "Hornitzailea Eguneratu", true);
		this.dao = dao;
		this.Hornitzailea = Hornitzailea;

		setLayout(new GridLayout(8, 2));
		setSize(400, 350);
		setLocationRelativeTo(parent);

		add(new JLabel("     Izena:"));
		txtIzena = new JTextField(Hornitzailea.getIzena());
		add(txtIzena);

		add(new JLabel("     Deskripzioa:"));
		txtDeskripzioa = new JTextField(Hornitzailea.getDeskripzioa());
		add(txtDeskripzioa);

		add(new JLabel("     Email:"));
		txtEmail = new JTextField(Hornitzailea.getEmail());
		add(txtEmail);

		add(new JLabel("     Telefonoa:"));
		txtTelefonoa = new JTextField(Hornitzailea.getTelefonoa());
		add(txtTelefonoa);

		JButton btnSave = new JButton("Eguneratu");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hornitzailea.setIzena(txtIzena.getText());
				Hornitzailea.setDeskripzioa(txtDeskripzioa.getText());
				Hornitzailea.setTelefonoa(txtTelefonoa.getText());
				Hornitzailea.setEmail(txtEmail.getText());

				dao.eguneratuHornitzailea(Hornitzailea);
				JOptionPane.showMessageDialog(HornitzaileaEguneratu.this, "Hornitzailea eguneratu da!");
				dispose();
			}
		});
		add(btnSave);

		setVisible(true);
	}
}
