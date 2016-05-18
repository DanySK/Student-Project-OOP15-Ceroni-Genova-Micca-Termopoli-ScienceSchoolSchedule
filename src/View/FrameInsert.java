package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.ControllerWorkers;
import Controller.ControllerWorkersInterface;
import Controller.SaveController;
import Controller.SaveControllerInterface;

public class FrameInsert extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboBoxesViews combo = new ComboBoxesViews();
	private Labels label = new Labels();
	private ControllerWorkersInterface cntr = new ControllerWorkers();
	private SaveControllerInterface controller = new SaveController();
	private ControllerGui c = new ControllerGui();
	private CreateTable table = new CreateTable();

	// private MainTable table = new MainTable();

	public FrameInsert() {
		// TODO Auto-generated constructor stub
		this.setTitle("Inserimento nouvo elemento");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400, 180);
		this.setResizable(false);

		final JPanel panelInsert = new JPanel(new GridLayout(5, 2));

		panelInsert.add(this.label.getlProfessor());
		panelInsert.add(this.combo.getcProfessor());

		panelInsert.add(this.label.getlCorses());
		panelInsert.add(this.combo.getcCorses());

		panelInsert.add(this.label.getlDays());
		panelInsert.add(this.combo.getcDays());

		panelInsert.add(this.label.getlHours());
		panelInsert.add(this.combo.getcHours());

		panelInsert.add(this.label.getlRooms());
		panelInsert.add(this.combo.getcRooms());

		this.combo.LisenerCombo(this.combo.getcProfessor(), this.combo.getcCorses());

		final JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		final JButton apply = new JButton("Applica");
		apply.addActionListener(l -> {
			
			
			cntr.add(c.matchString(this.combo.getcProfessor().getSelectedItem().toString(), this.combo.getcCorses()
					.getSelectedItem().toString(), this.combo.getcDays().getSelectedItem().toString(), this.combo
					.getcHours().getSelectedItem().toString(), this.combo.getcRooms().getSelectedItem().toString()));
			controller.getObjToSave().setListReservation(cntr.getListReservation());
			controller.save(controller.getObjToSave());
			
			c.drawTableDynamic(table.getDefTable());
			table.setModel(table.getDefTable());
			table.repaint();
			table.revalidate();
			
		});
		panelButton.add(apply);

		this.add(panelInsert);
		this.add(panelButton, BorderLayout.SOUTH);
	}
	
	/*
	 * MainTable table = new MainTable();
			DefaultTableModel defTable  = (DefaultTableModel) table.getTable().getModel();
			defTable.fireTableDataChanged();
			table.getTable().setModel(defTable);
			
			final String str = combo.getcCorses().getSelectedItem().toString()
					+ combo.getcRooms().getSelectedItem().toString();

			for (int c = 0; c < table.getTableModel().getColumnCount(); c++) {
				if ((table.getTableModel().getValueAt(0, c).toString()).equals(this.combo.getcHours().getSelectedItem()
						.toString())) {
					for (int r = 0; r < table.getTableModel().getRowCount(); r++) {
						if (table.getTableModel().getValueAt(r, 0).equals(this.combo.getcDays().getSelectedItem())) {
							for (int a = r; a <= r + controller.getObjToSave().getListRoom().size(); a++) {
								if ((table.getTableModel().getValueAt(a, 0).toString()).equals(this.combo.getcRooms()
										.getSelectedItem().toString())) {
									table.getTableModel().setValueAt(str, a, c);
								}
							}
						}
					}
				}
			}
			*/
}
