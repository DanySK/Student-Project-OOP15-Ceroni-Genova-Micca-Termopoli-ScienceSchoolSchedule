package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Days;
import Model.Hours;
import Model.ListRoom;

public class CreateTable extends JTable{

	/**
	 * 
	 */
	private static int COLUMNS = Hours.values().length + 1;
    private static int ROWS = Days.values().length + (Days.values().length * ListRoom.values().length);
	private static final long serialVersionUID = 1L;
	private DefaultTableModel defTable;
	private ControllerGui controller;

	public CreateTable() {
		// TODO Auto-generated constructor stub
		this.controller = new ControllerGui();
		this.defTable = new DefaultTableModel(ROWS,COLUMNS);
		this.controller.drawTable(defTable);
		this.setTableHeader(null);
		this.setTable(defTable);
	}
	
	public DefaultTableModel getDefTable(){
		return this.defTable;
	}
	
	public void setTable(DefaultTableModel table){
		this.setModel(table);
	}
	
	public CreateTable getTable(){
		return this;
	}
}
