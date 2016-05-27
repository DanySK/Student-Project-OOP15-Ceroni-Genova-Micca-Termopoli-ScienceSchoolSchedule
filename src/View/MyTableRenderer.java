package View;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

import Controller.SaveController;
import Controller.SaveControllerInterface;

public class MyTableRenderer extends JTextArea implements TableCellRenderer {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	protected ControllerGui contr;
	protected SaveControllerInterface cont = new SaveController();

	public MyTableRenderer() {
		this.setOpaque(true);
		contr = new ControllerGui();
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub

		this.setText((String) value);

		if (row == 0 || column == 0 || ((row % (contr.getCont().getObjToSave().getListRoom().size() + 1) == 0))) {
			setBackground(new Color(171, 205, 239));

		} else if (value != null) {
			this.setBackground(Color.lightGray);
			table.getValueAt(row, 0).toString();
			table.getValueAt(0, column).toString();
			String str = "\n " + table.getValueAt(row, 0).toString() + "\n " + table.getValueAt(0, column).toString()
					+ "\n " + this.getText();
			this.setToolTipText(str);
		} else {
			Color c = Color.white;
			this.setBackground(c);
		}
		return this;
	}

}
