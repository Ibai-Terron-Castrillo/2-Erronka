package formularioak;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import klaseak.Garraiolaria;
import mantenimendua.GarraiolariaKudeatu;
import mantenimendua.GarraiolariaTaula;

public class GarraiolariakAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private GarraiolariaKudeatu dao;

    public GarraiolariakAdmin() {
        setTitle("Garraiolariak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1006, 780);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Aukerak");
        menuBar.add(menu);

        JMenuItem sortu = new JMenuItem("Garraiolaria Sortu");
        sortu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GarraiolariaSortu formulario = new GarraiolariaSortu(GarraiolariakAdmin.this, dao);
                formulario.setVisible(true);
            }
        });
        menu.add(sortu);
        
        JMenuItem eguneratu = new JMenuItem("Garraiolaria Eguneratu");
        eguneratu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    Garraiolaria seleccionado = ((GarraiolariaTaula) table.getModel()).getGarraiolariaAt(filaSeleccionada);
                    GarraiolariaEguneratu formulario = new GarraiolariaEguneratu(GarraiolariakAdmin.this, dao, seleccionado);
                    formulario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(GarraiolariakAdmin.this, "Ezarri Garraiolari bat lehenik");
                }
            }
        });
        menu.add(eguneratu);

        JMenuItem ezabatu = new JMenuItem("Garraiolaria Ezabatu");
        ezabatu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    int idGarraiolaria = (int) table.getValueAt(row, 0);
                    int confirm = JOptionPane.showConfirmDialog(GarraiolariakAdmin.this, 
                            "Ziur zaude Garraiolari hau ezabatu nahi duzula?", "Garraiolaria Ezabatu", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        dao.ezabatuGarraiolaria(idGarraiolaria);
                        taulaBirkargatu();
                        JOptionPane.showMessageDialog(GarraiolariakAdmin.this, "Garraiolaria ezabatua!");
                    }
                } else {
                    JOptionPane.showMessageDialog(GarraiolariakAdmin.this, "Lehenik Garraiolari bat aukeratu!");
                }
            }
        });
        menu.add(ezabatu);


        JMenuItem bueltatu = new JMenuItem("Sarrerara Bueltatu");
        bueltatu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SarreraAdmin sarrera = new SarreraAdmin();
                sarrera.setExtendedState(JFrame.MAXIMIZED_BOTH);
                sarrera.setVisible(true);
                dispose();
            }
        });
        menu.add(bueltatu);

        JMenuItem filtratu = new JMenuItem("Bilaketa Filtroak Aplikatu");
        filtratu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String irizpidea = JOptionPane.showInputDialog(GarraiolariakAdmin.this, 
                        "Sartu bilaketa irizpidea (Izena, NAN-a, etab...):");
                if (irizpidea != null && !irizpidea.trim().isEmpty()) {
                    List<Garraiolaria> filtratutakoLista = dao.filtratuGarraiolariak(irizpidea);
                    GarraiolariaTaula newModel = new GarraiolariaTaula(filtratutakoLista);
                    table.setModel(newModel);
                } else {
                    List<Garraiolaria> listaOriginal = dao.lortuGarraiolariak();
                    table.setModel(new GarraiolariaTaula(listaOriginal));
                }
            }
        });
        menu.add(filtratu);
        
        JMenuItem birkargatu = new JMenuItem("Taula Birkargatu");
        birkargatu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taulaBirkargatu();
            }

			private void taulaBirkargatu() {
		        List<Garraiolaria> lista = dao.lortuGarraiolariak();
		        GarraiolariaTaula model = new GarraiolariaTaula(lista);
		        if (table == null) {
		            table = new JTable(model);
		            JScrollPane scrollPane = new JScrollPane(table);
		            contentPane.add(scrollPane, BorderLayout.CENTER);
		        } else {
		            table.setModel(model);
		        }
		    }
        });
        menu.add(birkargatu);

        JMenuItem saioaItxi = new JMenuItem("Saioa Itxi");
        saioaItxi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        menu.add(saioaItxi);

        setJMenuBar(menuBar);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        dao = new GarraiolariaKudeatu();
        List<Garraiolaria> lista = dao.lortuGarraiolariak();
        GarraiolariaTaula model = new GarraiolariaTaula(lista);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

    protected void taulaBirkargatu() {
        List<Garraiolaria> lista = dao.lortuGarraiolariak();
        GarraiolariaTaula model = new GarraiolariaTaula(lista);
        if (table == null) {
            table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            contentPane.add(scrollPane, BorderLayout.CENTER);
        } else {
            table.setModel(model);
        }
    }

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GarraiolariakAdmin frame = new GarraiolariakAdmin();
            frame.setVisible(true);
        });
    }
}
