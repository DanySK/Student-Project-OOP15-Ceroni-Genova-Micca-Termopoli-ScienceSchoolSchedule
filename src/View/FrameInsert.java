package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.TableModel;

import Controller.ControllerWorkers;
import Controller.ControllerWorkersInterface;
import Controller.Reservation;
import Controller.SaveController;
import Controller.SaveControllerInterface;
import Controller.ValidateError;
import Controller.ValidateWarning;
import Model.ErrorException;
import Model.WarningException;

public class FrameInsert {

	private final JFrame frameInsert = new JFrame("Inserimento nuovo elemento nella tabella");
	private ComboBoxesViews combo = new ComboBoxesViews();
	private Labels label = new Labels();
	private ControllerWorkersInterface cntr = new ControllerWorkers();
	private SaveControllerInterface controller = new SaveController();
	private ControllerGui c = new ControllerGui();

	public FrameInsert(MainGUI mainGUI) {

		this.frameInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frameInsert.setVisible(true);
		this.frameInsert.setSize(400, 200);
		this.frameInsert.setResizable(false);

		final JPanel panelInsert = new JPanel(new GridLayout(6, 2));

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

		/*
		 * final JTextField text = new JTextField(7); final JLabel labelText =
		 * new JLabel("Descrizione: ");
		 * 
		 * panelInsert.add(labelText); panelInsert.add(text);
		 */

		this.combo.LisenerCombo(this.combo.getcProfessor(), this.combo.getcCorses());

		final JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		final JButton apply = new JButton("Applica");
		apply.addActionListener(l -> {
			try {
				Reservation res = c.matchString(this.combo.getcProfessor().getSelectedItem().toString(), this.combo
						.getcCorses().getSelectedItem().toString(), this.combo.getcDays().getSelectedItem().toString(),
						this.combo.getcHours().getSelectedItem().toString(), this.combo.getcRooms().getSelectedItem()
								.toString());
				ValidateError error = new ValidateError();
				error.validateErrore(res);
				ValidateWarning warning = new ValidateWarning();
				warning.validateWARNING(res);
				cntr.addRes(res);
				controller.getObjToSave().setListReservation(cntr.getListReservation());
				controller.save(controller.getObjToSave());

				Integer row = c.getRow(res);
				Integer colum = c.getColum(res);
				mainGUI.update(res.getCourse().getName() + " \n" + res.getPerson().getSurname(), row, colum);
				this.frameInsert.setVisible(false);
			} catch (Exception e) {
				if (e instanceof WarningException) {
					int i = JOptionPane.showConfirmDialog(null, e.getMessage(), "Warning", JOptionPane.YES_NO_OPTION);
					if (i == JOptionPane.YES_OPTION) {
						Reservation res = c.matchString(this.combo.getcProfessor().getSelectedItem().toString(),
								this.combo.getcCorses().getSelectedItem().toString(), this.combo.getcDays()
										.getSelectedItem().toString(), this.combo.getcHours().getSelectedItem()
										.toString(), this.combo.getcRooms().getSelectedItem().toString());
						try {
							cntr.addRes(res);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						controller.getObjToSave().setListReservation(cntr.getListReservation());
						controller.save(controller.getObjToSave());

						Integer row = c.getRow(res);
						Integer colum = c.getColum(res);
						mainGUI.update(res.getCourse().getName() + " \n" + res.getPerson().getSurname(), row, colum);
						this.frameInsert.setVisible(false);
					}

				} else if (e instanceof ErrorException) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.OK_OPTION);
				} else {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error non previsto", JOptionPane.OK_OPTION);
				}

			}
		});
		panelButton.add(apply);

		this.frameInsert.add(panelInsert);
		this.frameInsert.add(panelButton, BorderLayout.SOUTH);
	}

	public TableModel getTableUp() {
		return new ControllerGui().getTable();
	}
}
