package ViewBy;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import View.ControllerGui;

public abstract class AbstractViewBy extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int columns;
	protected int rows;
	protected JPanel panel;
	protected DefaultTableModel defaultTable;
	protected JTable table;
	protected JScrollPane scroll;
	protected ControllerGui contr = new ControllerGui();

	public AbstractViewBy(final Object name) {
		// TODO Auto-generated constructor stub
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int width = (int) screenSize.getWidth();
		final int height = (int) screenSize.getHeight();
		this.setTitle(name.toString());
		this.setSize(width, height);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	protected DefaultTableModel fillCells(DefaultTableModel table, Object day){return table;};


}
