package formularioak;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import klaseak.Eskaera;
import klaseak.Eskaera;
import klaseak.Eskaera;
import mantenimendua.EskaerakTaula;
import mantenimendua.EskaerakTaula;
import mantenimendua.EskaerakKudeatu;
import mantenimendua.EskaerakTaula;

public class EskaerakAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private EskaerakKudeatu dao;

    public EskaerakAdmin() {
        setTitle("Eskaerak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1006, 780);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Aukerak");
        menuBar.add(menu);
        
        JMenuItem sortu = new JMenuItem("Eskaera Sortu");
        sortu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EskaeraSortu formulario = new EskaeraSortu(EskaerakAdmin.this, dao);
                formulario.setVisible(true);
            }
        });
        menu.add(sortu);
        
        JMenuItem eguneratu = new JMenuItem("Eskaera Eguneratu");
        eguneratu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    Eskaera seleccionado = ((EskaerakTaula) table.getModel()).getEskaeraAt(filaSeleccionada);
                    EskaeraEguneratu formulario = new EskaeraEguneratu(EskaerakAdmin.this, dao, seleccionado);
                    formulario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(EskaerakAdmin.this, "Ezarri Eskaera bat lehenik");
                }
            }
        });
        menu.add(eguneratu);

        JMenuItem ezabatu = new JMenuItem("Eskaera Ezabatu");
        ezabatu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    int idEskaera = (int) table.getValueAt(row, 0);
                    int confirm = JOptionPane.showConfirmDialog(EskaerakAdmin.this, 
                            "Ziur zaude Eskaera hau ezabatu nahi duzula?", "Eskaera Ezabatu", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        dao.ezabatuEskaera(idEskaera);
                        taulaBirkargatu();
                        JOptionPane.showMessageDialog(EskaerakAdmin.this, "Eskaera ezabatua!");
                    }
                } else {
                    JOptionPane.showMessageDialog(EskaerakAdmin.this, "Lehenik eskaera bat aukeratu!");
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
                String irizpidea = JOptionPane.showInputDialog(EskaerakAdmin.this, 
                        "Sartu bilaketa irizpidea (Helbidea, Egoera, etab...):");
                if (irizpidea != null && !irizpidea.trim().isEmpty()) {
                    List<Eskaera> filtratutakoLista = dao.filtratuEskaerak(irizpidea);
                    EskaerakTaula newModel = new EskaerakTaula(filtratutakoLista);
                    table.setModel(newModel);
                } else {
                    List<Eskaera> listaOriginal = dao.lortuEskaerak();
                    table.setModel(new EskaerakTaula(listaOriginal));
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
		        List<Eskaera> lista = dao.lortuEskaerak();
		        EskaerakTaula model = new EskaerakTaula(lista);
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

        dao = new EskaerakKudeatu();
        List<Eskaera> lista = dao.lortuEskaerak();
        EskaerakTaula model = new EskaerakTaula(lista);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

    protected void taulaBirkargatu() {
        List<Eskaera> lista = dao.lortuEskaerak();
        EskaerakTaula model = new EskaerakTaula(lista);
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
            EskaerakAdmin frame = new EskaerakAdmin();
            frame.setVisible(true);
        });
    }
}
