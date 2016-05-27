package View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ExportToXls;
import Controller.ObjToSave;
import Controller.SaveController;
import Controller.SaveControllerInterface;
import ViewBy.MyListenerView;

public class Buttons {

    private final JButton insert;
    private final JButton generalView;
    private final JButton undo;
    private final JButton redo;
    private final JButton insertNew;
    private final JButton saveInExel;
    private final JButton resetTable;
    private final JButton exit;
    private FrameInsert frame;
    private FrameModify frame1;
    private ComboBoxesViews comboBoxes = new ComboBoxesViews();
    private ExportToXls xls = new ExportToXls();
    private MyListenerView listenerViewGen = new MyListenerView();
    private SaveControllerInterface saveCntr = new SaveController();

    public Buttons(MainGUI mainGUI) {

        this.insert = new JButton("INSERISCI");
        this.generalView = new JButton("VISTA GENERALE");
        this.undo = new JButton("UNDO");
        this.redo = new JButton("REDO");
        this.insertNew = new JButton("AGGIUNGI NUOVO DATO");
        this.saveInExel = new JButton("ESPORTA IN EXCEL");
        this.resetTable = new JButton("RESETTA LA TABELLA");
        this.exit = new JButton("<<<<ESCI>>>>");

        this.insert.addActionListener(l -> {
            frame = new FrameInsert(mainGUI);
        });

        this.generalView.addActionListener(this.listenerViewGen);

        this.undo.addActionListener(l -> {

        });

        this.insertNew.addActionListener(l -> {
            frame1 = new FrameModify();
        });

        this.resetTable.addActionListener(l -> {
            int reset = JOptionPane.showConfirmDialog(null,
                    "Stai per resettare tutta la tabella! "
                            + "\nPrima di prosegure assicurati di aver salvato il file in Excel!"
                            + "\nVoui continuare comunque?",
                    "Attenzione!", JOptionPane.YES_NO_OPTION);
            if (reset == JOptionPane.YES_OPTION) {
                ObjToSave obj = this.saveCntr.getObjToSave();
                obj.setListReservation(new HashSet<>());
                this.saveCntr.save(obj);
                int mess = JOptionPane.showConfirmDialog(null, "Tutti i dati cancellati!"
                        + "\nRivavvia il programma per aggiornare la tabella." + "\nVoui prosseguire?", "Attenzione!",
                        JOptionPane.YES_NO_OPTION);
                if (mess == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        this.saveInExel.addActionListener(l -> {

            final JFrame frameSave = new JFrame("ESPORTA IN EXCEL");
            frameSave.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameSave.setVisible(true);
            frameSave.setSize(400, 150);
            frameSave.setResizable(false);
            final JPanel panelSave = new JPanel(new GridBagLayout());
            final JLabel text = new JLabel("Inserisci nome file:  ");
            final JTextField exelTitle = new JTextField(15);
            exelTitle.setToolTipText("ESEMPIO: 1° semestre 15-16");
            JPanel panelBut = new JPanel();
            final JButton save = new JButton("Salva");

            final GridBagConstraints cost = new GridBagConstraints();
            cost.gridx = 0;
            cost.gridy = 1;
            cost.fill = GridBagConstraints.BOTH;
            panelSave.add(text, cost);
            cost.gridx = 1;
            panelSave.add(exelTitle, cost);
            panelBut.add(save);

            save.addActionListener(e -> {
                String s = exelTitle.getText();
                JOptionPane.showMessageDialog(null,
                        "Il file è stato salvato nel percorso:  "
                                + (System.getProperty("user.home") + System.getProperty("file.separator") + s + ".xls"),
                        null, JOptionPane.INFORMATION_MESSAGE);

                xls.save(s);
                frameSave.setVisible(false);

            });

            frameSave.add(panelBut, BorderLayout.SOUTH);
            frameSave.add(panelSave);
            frameSave.setVisible(true);
        });

        this.exit.addActionListener(l -> {
            int mess = JOptionPane.showConfirmDialog(null, "Voui chiudere il programma?", "USCITA",
                    JOptionPane.YES_NO_OPTION);
            if (mess == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

    }

    public JButton getExit() {
        return exit;
    }

    public JButton getInsert() {
        return insert;
    }

    public JButton getSaveInExel() {
        return saveInExel;
    }

    public JButton getResetTable() {
        return resetTable;
    }

    public JButton getGeneralView() {
        return generalView;
    }

    public JButton getUndo() {
        return undo;
    }

    public JButton getRedo() {
        return redo;
    }

    public JButton getInsertNew() {
        return insertNew;
    }

}
