package View;

import javax.swing.JTable;
import javax.swing.table.*;

import Model.*;

import java.awt.Dimension;
import java.util.*;

public class TableGUI extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -782099090803983602L;

	private static int COLUMNS = Hours.values().length + 1;
	private static int ROWS = Days.values().length*ListRoom.values().length;
	
	private Map<Dimension, Object> dataTable = new HashMap<>();
	
	public TableGUI() {
		// TODO Auto-generated constructor stub
		/*final Set<String> setHours = new TreeSet<>();
		for (Hours hours : Hours.values()) {
			setHours.add(hours.getValue());
		}
		
		final Set<String> setHours = new TreeSet<>();
		for (Hours hours : Hours.values()) {
			setHours.add(hours.getValue());
		}
		this.table.setValueAt(null, 0, 0);
		int i = 1;
		for (String s : setHours){
			this.table.setValueAt(s, 0, i++);
		}
		
		System.out.println(setHours.toString());
		for (Days days : Days.values()) {
			this.dataTable.put(days.getString(), setHours);
			for (ListRoom room : ListRoom.values()) {
				this.dataTable.put(room.getValue(), new TreeSet<>());
			}
		}*/
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
	
	public void setValueAt(Object data, int row, int col)
    {
        Dimension coord = new Dimension(row, col);
        this.dataTable.put(coord, data);
        fireTableCellUpdated(row, col);
    }
	
	// DA CONTROLLARE
	public boolean isCellEditable(final int row, final int col) {
		return false;
	}

}