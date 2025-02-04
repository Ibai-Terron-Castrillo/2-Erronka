package formularioak;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import mantenimendua.EskBilKudeatu;
import mantenimendua.EskBilTaula;

public class Eskaera_Biltegia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private EskBilKudeatu dao;

    public Eskaera_Biltegia() {
        setTitle("Eskaera_Biltegia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1006, 780);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Aukerak");
        menuBar.add(menu);

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
                String irizpidea = JOptionPane.showInputDialog(Eskaera_Biltegia.this, 
                        "Sartu bilaketa irizpidea (Kantitatea, guztira, etab...):");
                if (irizpidea != null && !irizpidea.trim().isEmpty()) {
                    List<klaseak.Eskaera_Biltegia> filtratutakoLista = dao.filtratuEskaera_Biltegiak(irizpidea);
                    EskBilTaula newModel = new EskBilTaula(filtratutakoLista);
                    table.setModel(newModel);
                } else {
                    List<klaseak.Eskaera_Biltegia> listaOriginal = dao.lortuEskaera_Biltegiak();
                    table.setModel(new EskBilTaula(listaOriginal));
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
		        List<klaseak.Eskaera_Biltegia> lista = dao.lortuEskaera_Biltegiak();
		        EskBilTaula model = new EskBilTaula(lista);
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

        dao = new EskBilKudeatu();
        List<klaseak.Eskaera_Biltegia> lista = dao.lortuEskaera_Biltegiak();
        EskBilTaula model = new EskBilTaula(lista);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Eskaera_Biltegia frame = new Eskaera_Biltegia();
            frame.setVisible(true);
        });
    }
}
