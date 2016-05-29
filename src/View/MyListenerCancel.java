package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Controller.ControllerWorkers;

public class MyListenerCancel implements ActionListener {
    private ControllerWorkers cntr = new ControllerWorkers();
    MainGUI mainGUI;

    public MyListenerCancel(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            cntr.isEmpty();
            new FrameCancel(mainGUI);
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2.getMessage());
        }
    }
}
