package mantenimendua;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import klaseak.Hornitzailea;

public class HornitzaileakTaula extends AbstractTableModel {
    private List<Hornitzailea> lista;
    private String[] columnNames = {"ID", "IZENA", "DESKRIPZIOA", "TELEFONOA", "EMAIL"};

    public HornitzaileakTaula(List<Hornitzailea> lista) {
        this.lista = lista;
    }

    public Hornitzailea getHornitzaileaAt(int rowIndex) {
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
        Hornitzailea b = lista.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return b.getIdHornitzailea();
            case 1:
                return b.getIzena();
            case 2:
                return b.getDeskripzioa();
            case 3:
                return b.getTelefonoa();
            case 4:
                return b.getEmail();
            default:
                return null;
        }
    }
}

