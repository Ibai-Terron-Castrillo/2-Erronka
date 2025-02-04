package mantenimendua;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import klaseak.Bezeroa;

public class BezeroakTaula extends AbstractTableModel {
    private List<Bezeroa> lista;
    private String[] columnNames = {"ID", "Izena", "Abizenak", "Erabiltzailea", "Pasahitza", "Email", "Telefonoa", "NAN"};

    public BezeroakTaula(List<Bezeroa> lista) {
        this.lista = lista;
    }

    public Bezeroa getBezeroaAt(int rowIndex) {
        return lista.get(rowIndex);
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
        Bezeroa b = lista.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return b.getIdBezeroa();
            case 1:
                return b.getIzena();
            case 2:
                return b.getAbizenak();
            case 3:
                return b.getErabiltzailea();
            case 4:
                return b.getPasahitza();
            case 5:
                return b.getEmail();
            case 6:
                return b.getTelefonoa();
            case 7:
                return b.getNan();
            default:
                return null;
        }
    }
}

