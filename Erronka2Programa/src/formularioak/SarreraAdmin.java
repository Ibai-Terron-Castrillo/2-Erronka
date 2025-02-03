package formularioak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SarreraAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SarreraAdmin frame = new SarreraAdmin();
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
	public SarreraAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{180, 180, 180, 180, 0};
		gbl_contentPane.rowHeights = new int[]{1, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("Bezeroak");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BezeroakAdmin bezeroak = new BezeroakAdmin();
				bezeroak.setExtendedState(JFrame.MAXIMIZED_BOTH);
				bezeroak.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Eskaerak");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eskaerak eskaerak = new Eskaerak();
				eskaerak.setExtendedState(JFrame.MAXIMIZED_BOTH);
				eskaerak.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_3_1_1 = new JButton("Erosketak");
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_3_1_1 = new GridBagConstraints();
		gbc_btnNewButton_3_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3_1_1.gridx = 1;
		gbc_btnNewButton_3_1_1.gridy = 0;
		contentPane.add(btnNewButton_3_1_1, gbc_btnNewButton_3_1_1);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Salmenten Taula Global Konjuntoa");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Globala global = new Globala();
				global.setExtendedState(JFrame.MAXIMIZED_BOTH);
                global.setVisible(true);
                dispose();
			}
		});
		
		JButton btnNewButton_2_1 = new JButton("Langileak");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_2_1 = new GridBagConstraints();
		gbc_btnNewButton_2_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2_1.gridx = 3;
		gbc_btnNewButton_2_1.gridy = 0;
		contentPane.add(btnNewButton_2_1, gbc_btnNewButton_2_1);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridwidth = 4;
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 1;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Biltegia");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Biltegia biltegia = new Biltegia();
				biltegia.setExtendedState(JFrame.MAXIMIZED_BOTH);
                biltegia.setVisible(true);
                dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 2;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Garraiolariak");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Garraiolariak Garraiolariak = new Garraiolariak();
				Garraiolariak.setExtendedState(JFrame.MAXIMIZED_BOTH);
				Garraiolariak.setVisible(true);
                dispose();
			}
		});
		
		JButton btnNewButton_3_1 = new JButton("Hornitzaileak");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_3_1 = new GridBagConstraints();
		gbc_btnNewButton_3_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3_1.gridx = 1;
		gbc_btnNewButton_3_1.gridy = 2;
		contentPane.add(btnNewButton_3_1, gbc_btnNewButton_3_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 2;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Eskaera_Biltegia");
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_2_1_1 = new GridBagConstraints();
		gbc_btnNewButton_2_1_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2_1_1.gridx = 3;
		gbc_btnNewButton_2_1_1.gridy = 2;
		contentPane.add(btnNewButton_2_1_1, gbc_btnNewButton_2_1_1);
	}
}
