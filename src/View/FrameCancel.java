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
import Controller.ObjToSave;
import Controller.Reservation;
import Controller.SaveController;
import Controller.SaveControllerInterface;
import Model.WarningException;

public class FrameCancel {

    private ControllerGui cntGui = new ControllerGui();
    private final ControllerWorkers cntr = new ControllerWorkers();
    private SaveControllerInterface saveCntr = new SaveController();

    public FrameCancel(MainGUI mainGUI) throws WarningException {
        final JFrame frame = new JFrame("Seleziona dato per cancellare");
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screenSize.getWidth() / 2;
        final int height = (int) screenSize.getHeight() - 60;
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

        for (Reservation r : cntr.getListReservation()) {
            radioBut.add(new JRadioButton(r.toString()));
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

            int countSel = 0;
            for (JRadioButton jRadioButton : radioBut) {
                if (jRadioButton.isSelected()) {
                    countSel++;
                }
            }
            if (countSel > 0) {
                int b = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler cancellare i dati selezionati?",
                        "Cancelazione", JOptionPane.YES_NO_OPTION);
                if (b == JOptionPane.YES_OPTION) {
                  // if (cntr.getListReservation().size() == countSel) {
                   //     ObjToSave obj = this.saveCntr.getObjToSave();
                   //     obj.setListReservation(new ArrayList<>());
                   //     this.saveCntr.save(obj);
                       // int mess = JOptionPane.showConfirmDialog(null, "Tutti i dati cancellati!"
                       //         + "\nRiavvia il programma per aggiornare la tabella." + "\nVuoi proseguire?", "Attenzione!",
                       //         JOptionPane.YES_NO_OPTION);
                       // if (mess == JOptionPane.YES_OPTION) {
                       //     System.exit(0);
                       // }
                  //  } else {
                        for (JRadioButton but : radioBut) {
                            if (but.isSelected()) {

                                List<Reservation> temp = new ArrayList<>();
                                for (Reservation res : cntr.getListReservation()) {
                                    if (res.toString().equals(but.getText())) {
                                        temp.add(res);
                                        mainGUI.removeRes(cntGui.getRow(res), cntGui.getColum(res));
                                    }
                                }
                                try {
                                    cntr.removeAll(temp);
                                    cntr.save();
                                } catch (Exception e) {
                                    System.out.println("Ciao ciao sono sopra" + e.getMessage());
                                    e.printStackTrace();
                                }

                            }
                        }
                   // }
                    frame.dispose();
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
