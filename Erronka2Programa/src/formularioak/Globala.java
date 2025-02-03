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

public class Globala extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private GlobalaKudeatu dao;

    public Globala() {
        setTitle("Globala");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1006, 780);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Aukerak");
        menuBar.add(menu);

        JMenuItem bueltatu = new JMenuItem("Sarrerara Bueltatu");
        bueltatu.addActionListener(e -> {
            Sarrera sarrera = new Sarrera();
            sarrera.setExtendedState(JFrame.MAXIMIZED_BOTH);
            sarrera.setVisible(true);
            dispose();
        });
        menu.add(bueltatu);

        JMenuItem filtratu = new JMenuItem("Bilaketa Filtroak Aplikatu");
        filtratu.addActionListener(e -> {
            String irizpidea = JOptionPane.showInputDialog(Globala.this,
                    "Sartu bilaketa irizpidea (Izena, D, etab...):");
            if (irizpidea != null && !irizpidea.trim().isEmpty()) {
                List<klaseak.Global> filtratutakoLista = dao.filtratuGlobala(irizpidea);
                table.setModel(new GlobalaTaula(filtratutakoLista));
                ajustarAlturaFilas();
            } else {
                table.setModel(new GlobalaTaula(dao.lortuGlobala()));
                ajustarAlturaFilas();
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

        dao = new GlobalaKudeatu();
        table = new JTable(new GlobalaTaula(dao.lortuGlobala()));
        table.setDefaultRenderer(String.class, new MultiLineCellRenderer());
        ajustarAlturaFilas();

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

    private void taulaBirkargatu() {
        table.setModel(new GlobalaTaula(dao.lortuGlobala()));
        ajustarAlturaFilas();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Globala frame = new Globala();
            frame.setVisible(true);
        });
    }

    class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
        public MultiLineCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value == null ? "" : value.toString());
            return this;
        }
    }
}
