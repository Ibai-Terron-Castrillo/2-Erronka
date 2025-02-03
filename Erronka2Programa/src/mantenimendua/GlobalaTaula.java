package mantenimendua;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import klaseak.Global;

import java.awt.*;
import java.util.List;

public class GlobalaTaula extends AbstractTableModel {
    private List<Global> lista;
    private String[] columnNames = {"ESKAERA ID", "BEZEROA", "EMAIL", "TELEFONOA", "DATA", "HELBIDEA", "ESKATUTAKO PRODUKTUAK", "GUZTIRA", "GARRAIOLARIA", "ESKAERA EGOERA"};

    public GlobalaTaula(List<Global> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Global b = lista.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return b.getEskaeraID();
            case 1:
                return b.getBezeroa();
            case 2:
                return b.getEmail();
            case 3:
                return b.getTelefonoa();
            case 4:
                return b.getEskaeraData();
            case 5:
                return b.getHelbidea();
            case 6:
                return b.getProduktuak();
            case 7:
                return b.getGuztira();
            case 8:
                return b.getGarraiolaria();
            case 9:
                return b.getEskaeraEgoera();
            default:
                return null;
        }
    }

    // Renderizador para la columna de "ESKATUTAKO PRODUKTUAK"
    public static class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
        public MultiLineCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText(value != null ? value.toString() : "");
            setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
            if (table.getRowHeight(row) < getPreferredSize().height) {
                table.setRowHeight(row, getPreferredSize().height);
            }
            return this;
        }
    }
}
