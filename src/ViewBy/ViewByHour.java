package ViewBy;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Days;
import Model.Hours;
import Model.ListRoom;
import Model.Room;

public class ViewByHour extends AbstractViewBy{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewByHour(final Object name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.columns = 2;
		this.rows = Days.values().length + (Days.values().length * ListRoom.values().length);
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
	
	protected DefaultTableModel fillCells(DefaultTableModel table, Object hour) {
		
		int row = 0;
		for (Days day : Days.values()) {
			table.setValueAt(hour, row, 1);
			table.setValueAt(day.getString(), row++, 0);
			for (Room room : this.contr.getCont().getObjToSave().getListRoom()) {
                table.setValueAt(room.getNameRoom(), row++, 0);
            }
		}
		
		for(int c = 0; c < contr.getTable().getColumnCount(); c ++){
			if(contr.getTable().getValueAt(0, c).toString().equals(hour)){
				//System.out.println(contr.getTable().getValueAt(c, 0).toString());
				for(int r = 0; r < contr.getTable().getRowCount(); r ++){
					if(r!=0 && c!=0){
						//System.out.println(contr.getTable().getValueAt(r, c));
						Object obj = contr.getTable().getValueAt(r, c);
						table.setValueAt(obj, r, 1);
					}
				}
				table.fireTableDataChanged();
				return table;
			}	
		}
		return null;
	}

}
