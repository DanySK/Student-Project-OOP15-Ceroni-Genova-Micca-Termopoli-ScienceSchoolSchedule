package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.ControllerWorkers;
import Controller.ControllerWorkersInterface;
import Controller.Reservation;
import Controller.SaveController;
import Controller.SaveControllerInterface;
import Model.CoursesImpl;
import Model.Days;
import Model.Hours;
import Model.PersonImpl;
import Model.Professor;
import Model.RoomImpl;

public class FrameInsert {

    private final JFrame frameInsert = new JFrame("Inserimento nuovo elemento");
    private ComboBoxesViews combo = new ComboBoxesViews();
    private Labels label = new Labels();
    private ControllerWorkersInterface cntr = new ControllerWorkers();
    private SaveControllerInterface controller = new SaveController();

    public FrameInsert() {
        // TODO Auto-generated constructor stub
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

        this.combo.LisenerCombo(this.combo.getcProfessor(), this.combo.getcCorses());

        final JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        final JButton apply = new JButton("Applica");
        apply.addActionListener(l -> {
            PersonImpl person = null;
            CoursesImpl cours = null;
            for (Professor p : controller.getObjToSave().getListProfessor()) {

                if (p.getPerson().toString().equals(this.combo.getcProfessor().getSelectedItem())) {
                    person = new PersonImpl(p.getPerson().getName(), p.getPerson().getSurname());

                    for (CoursesImpl cous : p.getCourses()) {
                        if (cous.getName().equals(this.combo.getcCorses().getSelectedItem())) {
                            cours = new CoursesImpl(cous.getName(), cous.getType());
                        }

                    }
                }

            }
            Days day = null;
            for (Days d : Days.values()) {
                if (d.getString().equals(this.combo.getcDays().getSelectedItem())) {
                    day = d;
                }
            }
            Hours h = null;
            for (Hours ho : Hours.values()) {
                if (ho.getValue().equals(this.combo.getcHours().getSelectedItem())) {
                    h = ho;
                }
            }
            RoomImpl room = null;
            for (RoomImpl r : controller.getObjToSave().getListRoom()) {
                if (r.getNameRoom().equals(this.combo.getcRooms().getSelectedItem())) {
                    room = r;
                }
            }

            cntr.add(new Reservation(person, cours, day, h, room));
            controller.getObjToSave().setListReservation(cntr.getListReservation());
            controller.save(controller.getObjToSave());
        });
        panelButton.add(apply);

        this.frameInsert.add(panelInsert);
        this.frameInsert.add(panelButton, BorderLayout.SOUTH);
    }
}
