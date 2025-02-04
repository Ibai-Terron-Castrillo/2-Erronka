package formularioak;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import mantenimendua.BiltegiaKudeatu;
import mantenimendua.BiltegiaTaula;
import klaseak.Biltegia;

public class BiltegiaAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private BiltegiaKudeatu dao;

    public BiltegiaAdmin() {
        setTitle("Biltegia - Administratzailea");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1006, 780);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Aukerak");
        menuBar.add(menu);

        JMenuItem sortu = new JMenuItem("Produktu berria gehitu");
        sortu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProduktuaSortu formulario = new ProduktuaSortu(BiltegiaAdmin.this, dao);
                formulario.setVisible(true);
            }
        });
        menu.add(sortu);

        JMenuItem eguneratu = new JMenuItem("Produktuaren datuak eguneratu");
        eguneratu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    Biltegia produktua = ((BiltegiaTaula) table.getModel()).getProduktuaAt(filaSeleccionada);
                    BiltegiaEguneratu formulario = new BiltegiaEguneratu(BiltegiaAdmin.this, dao, produktua);
                    formulario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(BiltegiaAdmin.this, "Aukeratu produktu bat lehenik");
                }
            }
        });
        menu.add(eguneratu);

        JMenuItem ezabatu = new JMenuItem("Produktu bat ezabatu");
        ezabatu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    int idProduktu = (int) table.getValueAt(row, 0);
                    int confirm = JOptionPane.showConfirmDialog(BiltegiaAdmin.this, 
                            "Ziur zaude produktu hau ezabatu nahi duzula?", "Ezabatu", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        dao.ezabatuProduktua(idProduktu);
                        taulaBirkargatu();
                        JOptionPane.showMessageDialog(BiltegiaAdmin.this, "Produktu ezabatua!");
                    }
                } else {
                    JOptionPane.showMessageDialog(BiltegiaAdmin.this, "Aukeratu produktu bat lehenik!");
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
                String irizpidea = JOptionPane.showInputDialog(BiltegiaAdmin.this, 
                        "Sartu bilaketa irizpidea (Izena, Mota, etab...):");
                if (irizpidea != null && !irizpidea.trim().isEmpty()) {
                    List<klaseak.Biltegia> filtratutakoLista = dao.filtratuBiltegia(irizpidea);
                    BiltegiaTaula newModel = new BiltegiaTaula(filtratutakoLista);
                    table.setModel(newModel);
                } else {
                    List<klaseak.Biltegia> listaOriginal = dao.lortuBiltegia();
                    table.setModel(new BiltegiaTaula(listaOriginal));
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
		        List<klaseak.Biltegia> lista = dao.lortuBiltegia();
		        BiltegiaTaula model = new BiltegiaTaula(lista);
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

        dao = new BiltegiaKudeatu();
        taulaBirkargatu();
    }

    protected void taulaBirkargatu() {
        List<Biltegia> lista = dao.lortuBiltegia();
        BiltegiaTaula model = new BiltegiaTaula(lista);
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
            BiltegiaAdmin frame = new BiltegiaAdmin();
            frame.setVisible(true);
        });
    }
}
