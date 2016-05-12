package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.TableModel;

import Controller.ControllerWorkers;
import Controller.ControllerWorkersInterface;
import Controller.SaveController;
import Controller.SaveControllerInterface;
import Model.Days;
import Model.Hours;
import Model.ListRoom;

public class FrameInsert {

    private final JFrame frameInsert = new JFrame("Inserimento nuovo elemento");
    private ComboBoxesViews combo = new ComboBoxesViews();
    private Labels label = new Labels();
    private ControllerWorkersInterface cntr = new ControllerWorkers();
    private SaveControllerInterface controller = new SaveController();
    private ControllerGui c = new ControllerGui();
    // private PanelTable pan = new PanelTable();
    private TableModel table = new TableGUI();

    public FrameInsert() {
        // TODO Auto-generated constructor stub
        this.frameInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frameInsert.setVisible(true);
        this.frameInsert.setSize(400, 180);
        this.frameInsert.setResizable(false);

        // this.fillMainCells(table);
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

            cntr.add(c.matchString(this.combo.getcProfessor().getSelectedItem().toString(),
                    this.combo.getcCorses().getSelectedItem().toString(),
                    this.combo.getcDays().getSelectedItem().toString(),
                    this.combo.getcHours().getSelectedItem().toString(),
                    this.combo.getcRooms().getSelectedItem().toString()));
            controller.getObjToSave().setListReservation(cntr.getListReservation());
            controller.save(controller.getObjToSave());

            /*
             * for (Reservation res :
             * controller.getObjToSave().getListReservation()) {
             * //table.setValueAt(res.getCourse()+res.getPerson().getName(),
             * rowIndex, columnIndex); }
             */

            // this.table.setValueAt(str, 5, 5);
            // this.pan.update(table);

        });
        panelButton.add(apply);

        this.frameInsert.add(panelInsert);
        this.frameInsert.add(panelButton, BorderLayout.SOUTH);
    }

    public TableModel getTableUp() {
        return new ControllerGui().getTable();
    }

    private void fillMainCells(TableModel table) {
        int i = 0;
        for (Days days : Days.values()) {
            int y = 1;
            for (Hours hours : Hours.values()) {
                if (i == 0) {
                    table.setValueAt(hours.getValue(), 0, y++);
                } else {
                    table.setValueAt(hours.getValue(), i, y++);
                }
            }
            table.setValueAt(days.getString(), i++, 0);
            for (ListRoom room : ListRoom.values()) {
                table.setValueAt(room.getValue(), i++, 0);
            }
        }
    }
}
