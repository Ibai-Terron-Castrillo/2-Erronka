package formularioak;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import mantenimendua.GlobalaKudeatu;
import mantenimendua.GlobalaTaula;
import mantenimendua.GlobalaTaula.CustomCellRenderer;

public class GlobalaAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private GlobalaKudeatu dao;

	public GlobalaAdmin() {
		setTitle("Globala - Administratzaileak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1006, 780);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Aukerak");
		menuBar.add(menu);

		JMenuItem bueltatu = new JMenuItem("Sarrerara Bueltatu");
		bueltatu.addActionListener(e -> {
			SarreraAdmin sarrera = new SarreraAdmin();
			sarrera.setExtendedState(JFrame.MAXIMIZED_BOTH);
			sarrera.setVisible(true);
			dispose();
		});
		menu.add(bueltatu);

		JMenuItem filtratu = new JMenuItem("Bilaketa Filtroak Aplikatu");
		filtratu.addActionListener(e -> {
			String irizpidea = JOptionPane.showInputDialog(GlobalaAdmin.this,
					"Sartu bilaketa irizpidea (Izena, Data, etab...):");
			if (irizpidea != null && !irizpidea.trim().isEmpty()) {
				List<klaseak.Global> filtratutakoLista = dao.filtratuGlobala(irizpidea);
				table.setModel(new GlobalaTaula(filtratutakoLista));
			} else {
				table.setModel(new GlobalaTaula(dao.lortuGlobala()));
			}
			aplicarRenderizadores();
			ajustarAlturaFilas();
		});
		menu.add(filtratu);

		JMenuItem birkargatu = new JMenuItem("Taula Birkargatu");
		birkargatu.addActionListener(e -> taulaBirkargatu());
		menu.add(birkargatu);

		JMenuItem deskargatuFaktura = new JMenuItem("Deskargatu Faktura");
		deskargatuFaktura.addActionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				String eskaeraID = table.getValueAt(selectedRow, 0).toString();
				String bezeroa = table.getValueAt(selectedRow, 1).toString();
				String email = table.getValueAt(selectedRow, 2).toString();
				String telefonoa = table.getValueAt(selectedRow, 3).toString();
				String data = table.getValueAt(selectedRow, 4).toString();
				String helbidea = table.getValueAt(selectedRow, 5).toString();
				String produktuak = table.getValueAt(selectedRow, 6).toString();
				String guztira = table.getValueAt(selectedRow, 7).toString();
				String garraiolaria = table.getValueAt(selectedRow, 8).toString();

				PDF.fakturaSortu(eskaeraID, bezeroa, email, telefonoa, data, helbidea, produktuak, guztira,
						garraiolaria);
			} else {
				JOptionPane.showMessageDialog(null, "Aukeratu errenkada bat faktura sortzeko.");
			}
		});
		menu.add(deskargatuFaktura);

		JMenuItem saioaItxi = new JMenuItem("Saioa Itxi");
		saioaItxi.addActionListener(e -> {
			Login login = new Login();
			login.setVisible(true);
			dispose();
		});
		menu.add(saioaItxi);

		setJMenuBar(menuBar);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		dao = new GlobalaKudeatu();
		table = new JTable(new GlobalaTaula(dao.lortuGlobala()));

		table.setDefaultRenderer(Object.class, new GlobalaTaula.CustomCellRenderer());

		aplicarRenderizadores();
		ajustarAlturaFilas();

		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	private void taulaBirkargatu() {
		table.setModel(new GlobalaTaula(dao.lortuGlobala()));
		aplicarRenderizadores();
		ajustarAlturaFilas();
	}

	private void aplicarRenderizadores() {
		GlobalaTaula.CustomCellRenderer renderer = new GlobalaTaula.CustomCellRenderer();
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}
	}

	private void ajustarAlturaFilas() {
		for (int row = 0; row < table.getRowCount(); row++) {
			int alturaMax = table.getRowHeight();
			for (int column = 0; column < table.getColumnCount(); column++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				alturaMax = Math.max(alturaMax, comp.getPreferredSize().height);
			}
			table.setRowHeight(row, alturaMax);
		}
	}
}
