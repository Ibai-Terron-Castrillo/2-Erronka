package mantenimendua;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import klaseak.Biltegia;

public class BiltegiaTaula extends AbstractTableModel {
    private List<Biltegia> lista;
    private String[] columnNames = {"ID", "PRODUKTUA", "PRODUKTU MOTA", "EGOERA", "IRUDIA", "PREZIOA", "KOPURUA"};

    public BiltegiaTaula(List<Biltegia> lista) {
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
        Biltegia b = lista.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return b.getProduktuId();
            case 1:
                return b.getProduktuIzena();
            case 2:
                return b.getProduktuMota();
            case 3:
                return b.getProduktuEgoera();
            case 4:
                return b.getProduktuIruId();
            case 5:
                return b.getProduktuPrezioa();
            case 6:
                return b.getProduktuKantitatea();
            default:
                return null;
        }
    }
}

