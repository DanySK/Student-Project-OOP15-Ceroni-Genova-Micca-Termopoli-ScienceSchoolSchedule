package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import Controller.ControllerWorkers;
import Controller.ControllerWorkersInterface;
import Controller.Reservation;
import Controller.SaveController;
import Controller.SaveControllerInterface;
import Model.RoomImpl;

public class FrameInsert {

    private final JFrame frameInsert = new JFrame("Inserimento nuovo elemento");
    private ComboBoxesViews combo = new ComboBoxesViews();
    private Labels label = new Labels();
    private ControllerWorkersInterface cntr = new ControllerWorkers();
    private SaveControllerInterface controller = new SaveController();
    private ControllerGui c = new ControllerGui();
    private TableGUI table = new TableGUI();

    public FrameInsert(MainGUI mainGUI) {

        this.frameInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frameInsert.setVisible(true);
        this.frameInsert.setSize(400, 180);
        this.frameInsert.setResizable(false);

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

            Reservation res = c.matchString(this.combo.getcProfessor().getSelectedItem().toString(),
                    this.combo.getcCorses().getSelectedItem().toString(),
                    this.combo.getcDays().getSelectedItem().toString(),
                    this.combo.getcHours().getSelectedItem().toString(),
                    this.combo.getcRooms().getSelectedItem().toString());
            cntr.add(res);
            controller.getObjToSave().setListReservation(cntr.getListReservation());
            controller.save(controller.getObjToSave());

            Integer row = c.getRow(res);
            Integer colum = c.getColum(res);
            for (RoomImpl r : controller.getObjToSave().getListRoom()) {
                System.out.println(r.getNameRoom());
            }
            
            mainGUI.update( res.getCourse().getName(),row,colum );
            this.frameInsert.setVisible(false);

        });
        panelButton.add(apply);

        this.frameInsert.add(panelInsert);
        this.frameInsert.add(panelButton, BorderLayout.SOUTH);
    }
}
