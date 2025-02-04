package mantenimendua;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import klaseak.Bezeroa;
import klaseak.Eskaera;

public class EskaerakTaula extends AbstractTableModel {
    private List<Eskaera> lista;
    private String[] columnNames = {"ID", "ESKAERA DATA", "HELBIDEA", "ESKAERAREN EGOERA", "idBezeroa", "idGarraiolaria"};

    public EskaerakTaula(List<Eskaera> lista) {
        this.lista = lista;
    }

    public Eskaera getEskaeraAt(int rowIndex) {
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
        Eskaera b = lista.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return b.getIdEskaera();
            case 1:
                return b.getData();
            case 2:
                return b.getHelbidea();
            case 3:
                return b.getEskaeraEgoera();
            case 4:
                return b.getIdBezeroa();
            case 5:
                return b.getIdGarraiolaria();
            default:
                return null;
        }
    }
}

