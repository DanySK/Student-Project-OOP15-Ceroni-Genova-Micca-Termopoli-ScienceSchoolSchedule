package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import Controller.ControllerWorkers;
import Controller.Reservation;
import Model.WarningException;

public class FrameCancel {

    private ControllerGui cntGui = new ControllerGui();
    private ControllerWorkers cntr = new ControllerWorkers();

    public FrameCancel(MainGUI mainGUI) throws WarningException {
        final JFrame frame = new JFrame("Seleziona dato per cancellare");
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screenSize.getWidth() / 2;
        final int height = (int) screenSize.getHeight() - 20;
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setVisible(true);

        final JPanel panelR = new JPanel(new BorderLayout());
        final JPanel panelRadio = new JPanel(new GridBagLayout());
        GridBagConstraints cnst = new GridBagConstraints();
        cnst.gridy = 1;
        cnst.fill = GridBagConstraints.BOTH;

        List<JRadioButton> radioBut = new ArrayList<>();
        try {
            for (Reservation r : cntr.getListReservation()) {
                radioBut.add(new JRadioButton(r.toString()));
            }
        } catch (Exception e) {
            throw new WarningException(e.getMessage());
        }

        for (JRadioButton but : radioBut) {
            cnst.gridy++;
            panelRadio.add(but, cnst);
        }

        panelRadio.setAutoscrolls(true);
        final JScrollPane scroll = new JScrollPane(panelRadio);
        final JPanel panelCancel = new JPanel(new FlowLayout());
        final JButton delete = new JButton("Cancella");

        // listener delete
        delete.addActionListener(l -> {

            boolean isSelected = false;
            for (JRadioButton jRadioButton : radioBut) {
                if (jRadioButton.isSelected()) {
                    isSelected = true;
                }
            }
            if (isSelected) {
                int b = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler cancellare i dati selezionati?",
                        "Cancelazione", JOptionPane.YES_NO_OPTION);
                if (b == JOptionPane.YES_OPTION) {

                    for (JRadioButton but : radioBut) {
                        if (but.isSelected()) {

                            try {
                                for (Reservation res : cntr.getListReservation()) {
                                    Reservation tmp = res;

                                    if (tmp.toString().equals(but.getText())) {
                                        // System.out.println(but.getText());
                                        cntr.removeRes(tmp);
                                        mainGUI.removeRes(cntGui.getRow(tmp), cntGui.getColum(tmp));
                                    }

                                }
                                cntr.save();
                            } catch (Exception e) {
                                System.out.println("Ciao ciao sono sotto");
                                e.printStackTrace();

                            }
                        }
                    }

                    frame.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Non hai selezionato nessun dato!");
            }
        });

        panelCancel.add(delete);
        panelR.add(scroll);
        frame.add(panelR);
        frame.add(panelCancel, BorderLayout.SOUTH);
    }

}
