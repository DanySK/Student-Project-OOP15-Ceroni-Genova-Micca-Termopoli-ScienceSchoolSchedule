package ViewBy;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerWorkers;
import Controller.Reservation;
import Model.Days;
import Model.Hours;
import Model.Professor;

public class ViewByProf extends AbstractViewBy{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ControllerWorkers cntrWork = new ControllerWorkers();
	

	public ViewByProf(final Object name) {
		// TODO Auto-generated constructor stub
		super(name);
		
		this.columns = Hours.values().length + 1;
		this.rows = Days.values().length + (Days.values().length * this.cont.getObjToSave().getListRoom().size());
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
	
	protected DefaultTableModel fillCells(DefaultTableModel table, Object professor) {

		for (int r = 0; r < contr.getTable().getRowCount(); r++) {
			for (int c = 0; c < contr.getTable().getColumnCount(); c++) {
				if(r == 0 || c == 0){
					table.setValueAt(this.contr.getTable().getValueAt(r, c), r, c);
				}
			}
		}
	
		Professor prof = null;
		for (Professor p : this.cont.getObjToSave().getListProfessor()) {
			if(p.getPerson().toString().equals((String)professor)){
				System.out.println(p.getPerson().toString());
				System.out.println((String)professor);
				prof = p;
			}
		}
		System.out.println();
		
		for (Reservation res : this.cntrWork.getByProfessor(prof.getPerson())){
			table.setValueAt(res.getCourse().getName() + " \n" 
					+ res.getPerson().getSurname(),this.contr.getRow(res),
                    this.contr.getColum(res));
            table.fireTableCellUpdated(this.contr.getRow(res), this.contr.getColum(res));
		}
		
		table.fireTableDataChanged();
		return table;
	}

}
