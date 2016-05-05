package View;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

import Model.Days;
import Model.Hours;
import Model.ListRoom;

import java.awt.*;

public class PanelTable {
	
	private JPanel panelTable;
	private TableModel table;
	private JTable mainTable;
	private JScrollPane scroll;
	
	public PanelTable() {
		// TODO Auto-generated constructor stub
		this.panelTable = new JPanel(new BorderLayout());
		this.panelTable.setBorder(new TitledBorder("Panel Table"));
		this.table = new TableGUI();
		
		int i = 1;
		for (Days days : Days.values()) {
			this.table.setValueAt(days.getString(), i++, 0);
			for (ListRoom room : ListRoom.values()) {
				this.table.setValueAt(room.getValue(), i++, 0);
			}
		}
		i = 1;
		for (Hours hours : Hours.values()) {
			this.table.setValueAt(hours.getValue(), 0, i++);
		}
		
		this.mainTable = new JTable(table);
		this.scroll = new JScrollPane(mainTable);
		
		mainTable.setTableHeader(null);
		mainTable.setFillsViewportHeight(true);
		this.panelTable.add(scroll);
		
	}
	
	public JPanel getPanelTable(){
		return this.panelTable;
	}

}
