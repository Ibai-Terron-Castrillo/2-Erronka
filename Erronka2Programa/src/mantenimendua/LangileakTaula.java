package mantenimendua;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import klaseak.langilea;

public class LangileakTaula extends AbstractTableModel {
    private List<langilea> lista;
    private String[] columnNames = {"ID", "IZENA", "ABIZENAK", "ERABILTZAILEA", "PASAHITZA", "EMAIL", "TELEFONOA", "NAN", "HELBIDEA", "LANGILEKODEA", "ADMIN"};

    public LangileakTaula(List<langilea> lista) {
        this.lista = lista;
    }

    public langilea getLangileaAt(int rowIndex) {
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
        langilea b = lista.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return b.getIdLangilea();
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
            case 8:
                return b.getHelbidea();
            case 9:
                return b.getLangileKodea();
            case 10:
                return b.isAdmin();
            default:
                return null;
        }
    }
}

