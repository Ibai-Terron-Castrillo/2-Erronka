package mantenimendua;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import klaseak.Eskaera_Biltegia;

public class EskBilTaula extends AbstractTableModel {
    private List<Eskaera_Biltegia> lista;
    private String[] columnNames = {"IDESKAERA", "PRODUKTUID", "KANTITATEA", "GUZTIRAPREZIOA"};

    public EskBilTaula(List<Eskaera_Biltegia> lista) {
        this.lista = lista;
    }

    public Eskaera_Biltegia getEskaera_BiltegiaAt(int rowIndex) {
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
        Eskaera_Biltegia b = lista.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return b.getIdEskaera();
            case 1:
                return b.getProduktuId();
            case 2:
                return b.getKantitatea();
            case 3:
                return b.getGuztiraPrezioa();
            default:
                return null;
        }
    }
}

