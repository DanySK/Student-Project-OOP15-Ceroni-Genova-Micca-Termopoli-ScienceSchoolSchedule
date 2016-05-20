package View;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import Controller.Reservation;
import Model.Days;
import Model.Hours;
import Model.ListRoom;

public class TableGUI extends DefaultTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = -782099090803983602L;

    private static int COLUMNS = Hours.values().length + 1;
    private static int ROWS = Days.values().length + (Days.values().length * ListRoom.values().length);

    private Map<Dimension, Object> dataTable = new HashMap<>();

    public TableGUI() {

    }
    
    public Reservation getObjAt(int row , int colum ){
        
        
        return null;
        
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return ROWS;
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return COLUMNS;
    }

    @Override // DA CONTROLLARE
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return this.dataTable.get(new Dimension(rowIndex, columnIndex));
    }

    public void setValueAt(Object data, int row, int col) {
        Dimension coord = new Dimension(row, col);
        this.dataTable.put(coord, data);
        fireTableCellUpdated(row, col);
    }
    public void update() {
        fireTableDataChanged();
    }

    // DA CONTROLLARE
    public boolean isCellEditable(final int row, final int col) {
        return false;
    }

}