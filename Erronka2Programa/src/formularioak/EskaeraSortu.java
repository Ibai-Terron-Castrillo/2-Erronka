package formularioak;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import klaseak.Eskaera;
import mantenimendua.EskaerakKudeatu;
import javax.swing.*;
import java.text.ParseException;
import java.sql.*;

public class EskaeraSortu extends JDialog {

	private JTextField txtData, txtHelbidea, txtEskaeraEgoera, txtIdBezeroa, txtIdGarraiolaria;
	private EskaerakKudeatu dao;

	public EskaeraSortu(JFrame parent, EskaerakKudeatu dao) {
		super(parent, "Eskaera Sortu", true);
		this.dao = dao;

		getContentPane().setLayout(new GridLayout(8, 2));
		setSize(400, 350);
		setLocationRelativeTo(parent);

		getContentPane().add(new JLabel("     Data:"));
		txtData = new JTextField();
		getContentPane().add(txtData);

		getContentPane().add(new JLabel("     Helbidea:"));
		txtHelbidea = new JTextField();
		getContentPane().add(txtHelbidea);

		getContentPane().add(new JLabel("     Eskaera Egoera:"));
		txtEskaeraEgoera = new JTextField();
		getContentPane().add(txtEskaeraEgoera);

		getContentPane().add(new JLabel("     idBezeroa:"));
		txtIdBezeroa = new JTextField();
		getContentPane().add(txtIdBezeroa);

		getContentPane().add(new JLabel("     idGarraiolaria:"));
		txtIdGarraiolaria = new JTextField();
		getContentPane().add(txtIdGarraiolaria);

		JButton btnSave = new JButton("Gorde");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        Date fechaUtil = null;
				try {
					fechaUtil = (Date) dateFormat.parse(txtData.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
	            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());
				Eskaera Eskaera = new Eskaera(0, fechaSQL, txtHelbidea.getText(), txtEskaeraEgoera.getText(),
						Integer.parseInt(txtIdBezeroa.getText()), Integer.parseInt(txtIdGarraiolaria.getText()));
				dao.sortuEskaera(Eskaera);
				JOptionPane.showMessageDialog(EskaeraSortu.this, "Eskaera sortu da!");
				dispose();
			}
		});
		getContentPane().add(btnSave);

		setVisible(true);
	}
}
