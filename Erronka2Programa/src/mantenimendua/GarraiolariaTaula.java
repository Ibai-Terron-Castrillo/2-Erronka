package mantenimendua;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import klaseak.Garraiolaria;

public class GarraiolariaTaula extends AbstractTableModel {
    private List<Garraiolaria> lista;
    private String[] columnNames = {"ID", "IZENA", "HELBIDEA", "ABIZENAK", "NAN", "TELEFONOA", "ENPRESA"};

    public GarraiolariaTaula(List<Garraiolaria> filtratutakoLista) {
        this.lista = filtratutakoLista;
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
        Garraiolaria g = lista.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return g.getIdGarraiolaria();
            case 1:
                return g.getIzena();
            case 2:
                return g.getHelbidea();
            case 3:
                return g.getAbizenak();
            case 4:
                return g.getNan();
            case 5:
                return g.getTelefonoa();
            case 6:
                return g.getEnpresa();
            default:
                return null;
        }
    }
}


