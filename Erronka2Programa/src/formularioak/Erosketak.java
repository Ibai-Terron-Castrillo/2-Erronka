package formularioak;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import klaseak.Erosketa;
import mantenimendua.ErosketakKudeatu;
import mantenimendua.ErosketakTaula;

public class Erosketak extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private ErosketakKudeatu dao;

    public Erosketak() {
        setTitle("Erosketak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1006, 780);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Aukerak");
        menuBar.add(menu);

        JMenuItem sortu = new JMenuItem("Erosketa Sortu");
        sortu.addActionListener(e -> {
            ErosketaSortu formulario = new ErosketaSortu(Erosketak.this, dao);
            formulario.setVisible(true);
        });
        menu.add(sortu);

        JMenuItem eguneratu = new JMenuItem("Erosketa Eguneratu");
        eguneratu.addActionListener(e -> {
            int filaSeleccionada = table.getSelectedRow();
            if (filaSeleccionada != -1) {
                Erosketa seleccionado = ((ErosketakTaula) table.getModel()).getErosketaAt(filaSeleccionada);
                ErosketaEguneratu formulario = new ErosketaEguneratu(Erosketak.this, dao, seleccionado);
                formulario.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(Erosketak.this, "Ezarri erosketa bat lehenik");
            }
        });
        menu.add(eguneratu);

        JMenuItem ezabatu = new JMenuItem("Erosketa Ezabatu");
        ezabatu.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int idErosketa = (int) table.getValueAt(row, 0);
                int confirm = JOptionPane.showConfirmDialog(Erosketak.this, 
                        "Ziur zaude erosketa hau ezabatu nahi duzula?", "Erosketa Ezabatu", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dao.ezabatuErosketa(idErosketa);
                    taulaBirkargatu();
                    JOptionPane.showMessageDialog(Erosketak.this, "Erosketa ezabatua!");
                }
            } else {
                JOptionPane.showMessageDialog(Erosketak.this, "Lehenik erosketa bat aukeratu!");
            }
        });
        menu.add(ezabatu);

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
            String irizpidea = JOptionPane.showInputDialog(Erosketak.this, 
                    "Sartu bilaketa irizpidea (Izena, data, etab...):");
            if (irizpidea != null && !irizpidea.trim().isEmpty()) {
                List<Erosketa> filtratutakoLista = dao.filtratuErosketak(irizpidea);
                ErosketakTaula newModel = new ErosketakTaula(filtratutakoLista);
                table.setModel(newModel);
            } else {
                List<Erosketa> listaOriginal = dao.lortuErosketak();
                table.setModel(new ErosketakTaula(listaOriginal));
            }
        });
        menu.add(filtratu);

        JMenuItem birkargatu = new JMenuItem("Taula Birkargatu");
        birkargatu.addActionListener(e -> taulaBirkargatu());
        menu.add(birkargatu);

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

        dao = new ErosketakKudeatu();
        List<Erosketa> lista = dao.lortuErosketak();
        ErosketakTaula model = new ErosketakTaula(lista);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

    protected void taulaBirkargatu() {
        List<Erosketa> lista = dao.lortuErosketak();
        ErosketakTaula model = new ErosketakTaula(lista);
        table.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Erosketak frame = new Erosketak();
            frame.setVisible(true);
        });
    }
}
