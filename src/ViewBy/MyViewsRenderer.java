package ViewBy;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;

import Controller.ControllerWorkers;
import Model.Courses;
import View.MyTableRenderer;

public class MyViewsRenderer extends MyTableRenderer {

	private static final long serialVersionUID = 1L;

	private ControllerWorkers cntr = new ControllerWorkers();
	private Object name;
	public MyViewsRenderer(final Object name) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub

		this.setText((String) value);
		this.setHorizontalAlignment(CENTER);
		this.setHorizontalAlignment(CENTER);

		if (row == 0 || column == 0 || ((row % (this.contr.getCont().getObjToSave().getListRoom().size() + 1) == 0))) {
			setBackground(new Color(171, 205, 239));
			setBorder(null);

		} else if (value != null) {
			Color color = Color.white;
			for (Courses c : this.cntr.getCoursesFromFile()) {
				if(c.getName().equals(name.toString())){
					color = c.getType().getColor();
				}
			}
			this.setBackground(color);
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
