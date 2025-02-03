package formularioak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import klaseak.langilea;
import mantenimendua.LangileakKudeatu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtErabiltzailea;
	private JPasswordField txtPasahitza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(337, 293);
		setLocationRelativeTo(null);
		setVisible(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setBounds(73, 58, 96, 39);
		contentPane.add(lblErabiltzailea);

		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(73, 107, 96, 39);
		contentPane.add(lblPasahitza);

		txtErabiltzailea = new JTextField();
		txtErabiltzailea.setBounds(155, 69, 96, 19);
		contentPane.add(txtErabiltzailea);
		txtErabiltzailea.setColumns(10);

		txtPasahitza = new JPasswordField();
		txtPasahitza.setBounds(155, 118, 96, 19);
		contentPane.add(txtPasahitza);

		JButton btnAtera = new JButton("Atera");
		btnAtera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atera();
			}
		});
		btnAtera.setBounds(73, 156, 85, 21);
		contentPane.add(btnAtera);

		JButton btnSartu = new JButton("Sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sartu();
			}
		});
		btnSartu.setBounds(168, 156, 85, 21);
		contentPane.add(btnSartu);
	}

	protected void sartu() {
		String langilea = txtErabiltzailea.getText();
		String pasahitza = String.valueOf(txtPasahitza.getPassword());

		langilea langile2 = new langilea();
		langile2.setErabiltzailea(langilea);
		langile2.setPasahitza(pasahitza);

		LangileakKudeatu langileakKudeatu = new LangileakKudeatu();
		langilea lan = langileakKudeatu.lortuLangilea(langile2);

		if (lan != null) {
			JOptionPane.showMessageDialog(contentPane, "Ongi Etorri!");
			this.dispose();
			if (lan.isAdmin()) {
				SarreraAdmin sarrera = new SarreraAdmin();
				sarrera.setExtendedState(JFrame.MAXIMIZED_BOTH);
				sarrera.setVisible(true);
			} else {
				Sarrera sarrera = new Sarrera();
				sarrera.setExtendedState(JFrame.MAXIMIZED_BOTH);
				sarrera.setVisible(true);
			}

		} else {
			JOptionPane.showMessageDialog(contentPane, "Ez da erabiltzailea aurkitu", "Errorea",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void atera() {
		System.exit(0);
	}
}