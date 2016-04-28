package View;

import javax.swing.table.*;

public class TableGUI extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -782099090803983602L;

	private static int COLUMNS = 7;
	private static int ROWS = 67;
	
	public TableGUI() {
		// TODO Auto-generated constructor stub
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
		return null;
	}
	
	// DA CONTROLLARE
	public boolean isCellEditable(final int row, final int col) {
		return true;
	}

}
