package mantenimendua;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import klaseak.Erosketa;

public class ErosketakTaula extends AbstractTableModel {
    private List<Erosketa> lista;
    private String[] columnNames = {
        "ID", "Kantitatea", "Data", "Prezioa", "Irudia", "Egoera", "Mota", "Izena", "Hornitzailea"
    };

    public ErosketakTaula(List<Erosketa> lista) {
        this.lista = lista;
    }

    public Erosketa getErosketaAt(int rowIndex) {
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
        Erosketa e = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return e.getIdErosketa();            
            case 1: return e.getProduktuKantitatea();       
            case 2: return e.getData();                     
            case 3: return e.getProduktuPrezioa();          
            case 4: return e.getProduktuIrudia();          
            case 5: return e.getProduktuEgoera();         
            case 6: return e.getProduktuMota();             
            case 7: return e.getProduktuIzena();            
            case 8: return e.getIdHornitzailea();           
            default: return null;
        }
    }

    public void setLista(List<Erosketa> nuevaLista) {
        this.lista = nuevaLista;
        fireTableDataChanged();
    }
}
