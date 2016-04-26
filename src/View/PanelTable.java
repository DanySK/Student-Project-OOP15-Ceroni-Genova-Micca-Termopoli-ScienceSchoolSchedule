package View;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class PanelTable {
	
	private JPanel panelTable;
	private TableGUI table;
	private JTable mainTable;
	private JScrollPane scroll;
	
	public PanelTable() {
		// TODO Auto-generated constructor stub
		this.panelTable = new JPanel(new BorderLayout());
		this.panelTable.setBorder(new TitledBorder("Panel Table"));
		this.table = new TableGUI();
		this.mainTable = new JTable(table);
		this.scroll = new JScrollPane(mainTable);
		
		mainTable.setFillsViewportHeight(true);
		this.panelTable.add(scroll);
	}
	
	public JPanel getPanelTable(){
		return this.panelTable;
	}

}
