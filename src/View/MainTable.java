package View;

import javax.swing.*;


public class MainTable extends JScrollPane{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public MainTable() {
		// TODO Auto-generated constructor stub
		//createViewport
		//getViewport
		this.setViewportView(new CreateTable());
		this.setWheelScrollingEnabled(true);
	}
}
