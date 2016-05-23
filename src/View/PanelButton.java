package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelButton {

    private final JPanel panelButton;
    private final Labels labels = new Labels();
    private final ComboBoxesViews comboBoxes = new ComboBoxesViews();
    private final GridBagConstraints cnst = new GridBagConstraints();
    private final PanelLegend panelLegend = new PanelLegend();

    public PanelButton(MainGUI mainGUI) {
        Buttons buttons = new Buttons(mainGUI);
        this.panelButton = new JPanel(new GridBagLayout());
        this.panelButton.setBorder(new TitledBorder("Panel Button"));
        this.panelButton.setBackground(Color.pink);

        this.cnst.gridy = 1;
        this.cnst.fill = GridBagConstraints.BOTH;

        this.setCnstXOne();
        this.panelButton.add(buttons.getInsert(), cnst);
        this.incrementCnstY();
        this.incrementCnstY();
        this.incrementCnstY();
        this.panelButton.add(buttons.getGeneralView(), cnst);
        buttons.getGeneralView().addActionListener(l->{
        	buttons.getInsert().setEnabled(true);
        });
        this.setCnstXZero();
        this.incrementCnstY();
        this.panelButton.add(this.labels.getViews(), cnst);
        this.incrementCnstY();
        this.setCnstXZero();
        this.panelButton.add(this.labels.getlDays(), cnst);
        this.setCnstXOne();
        this.panelButton.add(this.comboBoxes.getcDays(), cnst);
        this.incrementCnstY();
        this.setCnstXZero();
        this.panelButton.add(this.labels.getlRooms(), cnst);
        this.setCnstXOne();
        this.panelButton.add(this.comboBoxes.getcRooms(), cnst);
        this.incrementCnstY();
        this.setCnstXZero();
        this.panelButton.add(this.labels.getlHours(), cnst);
        this.setCnstXOne();
        this.panelButton.add(this.comboBoxes.getcHours(), cnst);
        this.incrementCnstY();
        this.setCnstXZero();
        this.panelButton.add(this.labels.getlProfessor(), cnst);
        this.setCnstXOne();
        this.panelButton.add(this.comboBoxes.getcProfessor(), cnst);
        this.incrementCnstY();
        this.setCnstXZero();
        this.panelButton.add(this.labels.getlCorses(), cnst);
        this.setCnstXOne();
        this.panelButton.add(this.comboBoxes.getcCorses(), cnst);
        this.incrementCnstY();
        this.panelButton.add(buttons.getUndo(), cnst);
        this.incrementCnstY();
        this.panelButton.add(buttons.getRedo(), cnst);
        this.incrementCnstY();
        this.panelButton.add(buttons.getSave(), cnst);
        this.incrementCnstY();
        this.panelButton.add(panelLegend.getPanelLegend(), cnst);
        /*
         * DA CONCORDARE CON IL PROF SE METTERLO O MENO
         * this.comboBoxes.LisenerCombo(this.comboBoxes.getcProfessor(),
         * this.comboBoxes.getcCorses());
         */

        this.comboBoxes.FillCombobox(this.comboBoxes.getcCorses());

        this.ClearAllCombo(this.comboBoxes.getcDays());
        this.ClearAllCombo(this.comboBoxes.getcHours());
        this.ClearAllCombo(this.comboBoxes.getcCorses());
        this.ClearAllCombo(this.comboBoxes.getcProfessor());
        this.ClearAllCombo(this.comboBoxes.getcRooms());
    }

    private void ClearAllCombo(JComboBox<String> combo) {
        combo.addActionListener(l -> {
            for (JComboBox<String> jComboBox : this.comboBoxes.getSetCombo()) {
                if (!jComboBox.equals(combo)) {
                    if (!jComboBox.getSelectedItem().equals(" ")) {
                        jComboBox.setSelectedIndex(0);
                    }
                }
            }
        });
    }
    
    public void ComboLisener(JPanel panel){
    	this.comboBoxes.getcDays().addActionListener(l -> {
    		panel.removeAll();
    	});
    }

    public JPanel getPanelButton() {
        return this.panelButton;
    }

    private void incrementCnstY() {
        this.cnst.gridy++;
    }

    private void setCnstXZero() {
        this.cnst.gridx = 0;
    }

    private void setCnstXOne() {
        this.cnst.gridx = 1;
    }
}