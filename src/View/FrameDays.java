package View;

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

public class FrameDays extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int COLUMNS = Hours.values().length + 1;
	private static int ROWS = ListRoom.values().length + 1;
	private SaveControllerInterface cont = new SaveController();
	private ControllerWorkers contWork = new ControllerWorkers();
	private ControllerGui contr = new ControllerGui();

	public FrameDays(final Object name) {

		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int width = (int) screenSize.getWidth();
		final int height = (int) screenSize.getHeight();
		this.setTitle(name.toString());
		this.setSize(width, height);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		final JPanel panel = new JPanel(new BorderLayout());
		final DefaultTableModel defaultTable = new DefaultTableModel(ROWS, COLUMNS);
		this.fillCells(defaultTable, name);
		final JTable table = new JTable(defaultTable);
		final JScrollPane scroll = new JScrollPane(table);
		table.setTableHeader(null);
		table.setFillsViewportHeight(true);

		panel.add(scroll, BorderLayout.CENTER);
		this.add(panel, BorderLayout.CENTER);
	}

	public FrameDays getFrameDays() {
		return this;
	}

	private DefaultTableModel fillCells(DefaultTableModel table, Object day) {

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
				/*for (Reservation res : set) {
					table.setValueAt(res.getCourse().getName() + " \n" 
							+ res.getPerson().getSurname(),this.contr.getRow(res),
		                    this.contr.getColum(res));
					table.fireTableCellUpdated(this.contr.getRow(res), this.contr.getColum(res));
				}*/
			}
		}
		table.fireTableDataChanged();
		return table;
	}

}
