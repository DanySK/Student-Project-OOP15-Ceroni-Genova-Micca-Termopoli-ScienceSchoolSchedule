package View;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PanelTable extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainTable table;

	public PanelTable() {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		// questo non dovrebbe essere statico
		this.setBorder(new TitledBorder(" Panel Table "));
		this.table = new MainTable();
		this.add(table);
	}

}
