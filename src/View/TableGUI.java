package View;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import Controller.SaveController;
import Controller.SaveControllerInterface;
import Model.Days;
import Model.Hours;

public class TableGUI extends DefaultTableModel {

	/**
     * 
     */
	private static final long serialVersionUID = -782099090803983602L;

	private SaveControllerInterface cont = new SaveController();
	private static int COLUMNS = Hours.values().length + 1;
	private int row = Days.values().length + (Days.values().length * this.cont.getObjToSave().getListRoom().size());

	private Map<Dimension, Object> dataTable = new HashMap<>();

	public TableGUI() {

	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return row;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMNS;
	}

	@Override
	// DA CONTROLLARE
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