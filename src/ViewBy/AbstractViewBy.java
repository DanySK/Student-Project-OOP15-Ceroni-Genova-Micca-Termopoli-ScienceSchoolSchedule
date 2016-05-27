package ViewBy;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Controller.SaveController;
import Controller.SaveControllerInterface;
import View.ControllerGui;

public abstract class AbstractViewBy extends JFrame {

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
	protected SaveControllerInterface cont = new SaveController();

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

	protected DefaultTableModel fillCells(DefaultTableModel table, Object day) {
		return table;
	};

	protected void resizeColumnWidth(JTable table) {

		for (int column = 0; column < table.getColumnCount(); column++) {
			final TableColumn columnModel = table.getColumnModel().getColumn(column);
			int width = columnModel.getMinWidth();

			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				int height = table.getRowHeight(row);
				width = Math.max(comp.getPreferredSize().width + 1, width);
				height = Math.max(comp.getPreferredSize().height + 1, height);
				table.setRowHeight(height);
			}
			columnModel.setPreferredWidth(width);
		}
	}

}
