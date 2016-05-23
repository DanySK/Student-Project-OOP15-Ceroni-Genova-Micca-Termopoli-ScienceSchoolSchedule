package ViewBy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerWorkers;
import Controller.Reservation;
import Controller.SaveController;
import Controller.SaveControllerInterface;
import Model.Days;
import Model.Hours;
import Model.ListRoom;
import Model.Room;
import View.ControllerGui;

public class ViewByDay extends AbstractViewBy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SaveControllerInterface cont = new SaveController();
	private ControllerWorkers contWork = new ControllerWorkers();
	private ControllerGui contr = new ControllerGui();

	public ViewByDay(final Object name) {
		
		super(name);
		this.columns = Hours.values().length + 1;
		this.rows = ListRoom.values().length + 1;
		this.defaultTable = new DefaultTableModel(rows, columns);
		this.fillCells(defaultTable, name);
		this.panel = new JPanel(new BorderLayout());
		this.table = new JTable(defaultTable);
		this.scroll = new JScrollPane(table);
		this.table.setTableHeader(null);
		this.table.setFillsViewportHeight(true);
		this.panel.add(scroll, BorderLayout.CENTER);
		this.add(panel, BorderLayout.CENTER);
		
	}

	protected DefaultTableModel fillCells(DefaultTableModel table, Object day) {

		int i = 0;
		int y = 0;
		for (Days days : Days.values()) {
			if (days.getString().equals(day.toString())) {
				//Set<Reservation> set = this.contWork.getByDay(days);
				table.setValueAt(days.getString(), i, y);

				for (Hours hours : Hours.values()) {
					table.setValueAt(hours.getValue().toUpperCase(), i, ++y);
				}

				for (Room room : this.cont.getObjToSave().getListRoom()) {
					table.setValueAt(room.getNameRoom(), ++i, 0);
					table.fireTableCellUpdated(i, y);
				}
			}
		}
		table.fireTableDataChanged();
		return table;
	}

}
