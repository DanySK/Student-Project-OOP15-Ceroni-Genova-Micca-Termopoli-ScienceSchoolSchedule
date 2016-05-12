package View;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

import Model.Days;
import Model.Hours;
import Model.ListRoom;

import java.awt.*;
import java.util.Set;
import java.util.TreeSet;

public class PanelTable {

	private JPanel panelTable;
	private TableModel table;
	private JTable mainTable;
	private JScrollPane scroll;
	private FrameInsert frame = new FrameInsert();

	// private TableRenderer renderer = new TableRenderer();

	public PanelTable() {
		// TODO Auto-generated constructor stub
		this.panelTable = new JPanel(new BorderLayout());
		this.panelTable.setBorder(new TitledBorder("Panel Table"));
		this.table = frame.getTableUp();
		//this.fillMainCells(table);
		this.mainTable = new JTable(table);
		this.scroll = new JScrollPane(mainTable);
		// this.fillMainCells(mainTable, table);
		// this.mainTable.setDefaultRenderer(Object.class, new TableRenderer());

		// AUTO RESIZE MODE DINAMYC

		this.resizeColumnWidth(mainTable);
		this.mainTable.setFillsViewportHeight(true);
		mainTable.setTableHeader(null);
		mainTable.setFillsViewportHeight(true);
		this.panelTable.add(scroll);

	}

	public JPanel getPanelTable() {
		return this.panelTable;
	}

	// DA CONTROLLAREEEE
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	/*private void fillMainCells(TableModel table) {
		int i = 0;
		for (Days days : Days.values()) {
			int y = 1;
			for (Hours hours : Hours.values()) {
				if (i == 0) {
					table.setValueAt(hours.getValue(), 0, y++);
				} else {
					table.setValueAt(hours.getValue(), i, y++);
				}
			}
			table.setValueAt(days.getString(), i++, 0);
			for (ListRoom room : ListRoom.values()) {
				table.setValueAt(room.getValue(), i++, 0);
			}
		}
	}*/

	// DA CONTROLLAREEEE
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	private void resizeColumnWidth(JTable table) {

		for (int column = 0; column < table.getColumnCount(); column++) {
			final TableColumn columnModel = table.getColumnModel().getColumn(column);
			int width = columnModel.getMinWidth();
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			columnModel.setPreferredWidth(width);
		}
	}

	/*public TableModel getTable() {
		return this.table;
	}*/

	/*public TableModel update(TableModel t) {
		return this.table = t;
	}*/

}
