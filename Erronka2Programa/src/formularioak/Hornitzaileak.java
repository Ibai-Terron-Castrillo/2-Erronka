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

import klaseak.Hornitzailea;
import mantenimendua.HornitzaileakKudeatu;
import mantenimendua.HornitzaileakTaula;

public class Hornitzaileak extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private HornitzaileakKudeatu dao;

    public Hornitzaileak() {
        setTitle("Hornitzaileak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1006, 780);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Aukerak");
        menuBar.add(menu);

        JMenuItem sortu = new JMenuItem("Hornitzailea Sortu");
        sortu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HornitzaileaSortu formulario = new HornitzaileaSortu(Hornitzaileak.this, dao);
                formulario.setVisible(true);
            }
        });
        menu.add(sortu);
        
        JMenuItem eguneratu = new JMenuItem("Hornitzailea Eguneratu");
        eguneratu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    Hornitzailea seleccionado = ((HornitzaileakTaula) table.getModel()).getHornitzaileaAt(filaSeleccionada);
                    HornitzaileaEguneratu formulario = new HornitzaileaEguneratu(Hornitzaileak.this, dao, seleccionado);
                    formulario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(Hornitzaileak.this, "Ezarri Hornitzaile bat lehenik");
                }
            }
        });
        menu.add(eguneratu);

        JMenuItem ezabatu = new JMenuItem("Hornitzailea Ezabatu");
        ezabatu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    int idHornitzailea = (int) table.getValueAt(row, 0);
                    int confirm = JOptionPane.showConfirmDialog(Hornitzaileak.this, 
                            "Ziur zaude Hornitzaile hau ezabatu nahi duzula?", "Hornitzailea Ezabatu", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        dao.ezabatuHornitzailea(idHornitzailea);
                        taulaBirkargatu();
                        JOptionPane.showMessageDialog(Hornitzaileak.this, "Hornitzailea ezabatua!");
                    }
                } else {
                    JOptionPane.showMessageDialog(Hornitzaileak.this, "Lehenik Hornitzaile bat aukeratu!");
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
                String irizpidea = JOptionPane.showInputDialog(Hornitzaileak.this, 
                        "Sartu bilaketa irizpidea (Izena, NAN-a, etab...):");
                if (irizpidea != null && !irizpidea.trim().isEmpty()) {
                    List<Hornitzailea> filtratutakoLista = dao.filtratuHornitzaileak(irizpidea);
                    HornitzaileakTaula newModel = new HornitzaileakTaula(filtratutakoLista);
                    table.setModel(newModel);
                } else {
                    List<Hornitzailea> listaOriginal = dao.lortuHornitzaileak();
                    table.setModel(new HornitzaileakTaula(listaOriginal));
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
		        List<Hornitzailea> lista = dao.lortuHornitzaileak();
		        HornitzaileakTaula model = new HornitzaileakTaula(lista);
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

        dao = new HornitzaileakKudeatu();
        List<Hornitzailea> lista = dao.lortuHornitzaileak();
        HornitzaileakTaula model = new HornitzaileakTaula(lista);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

    protected void taulaBirkargatu() {
        List<Hornitzailea> lista = dao.lortuHornitzaileak();
        HornitzaileakTaula model = new HornitzaileakTaula(lista);
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
            Hornitzaileak frame = new Hornitzaileak();
            frame.setVisible(true);
        });
    }
}
