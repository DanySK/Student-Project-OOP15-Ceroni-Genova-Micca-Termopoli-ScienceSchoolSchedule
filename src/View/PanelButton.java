package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelButton {
	
	private final JPanel panelButton;
	private final Buttons buttons = new Buttons();
	private final Labels labels = new Labels();
	private final ComboBoxesViews comboBoxes = new ComboBoxesViews();
	private final GridBagConstraints cnst = new GridBagConstraints();
	
	public PanelButton() {
		// TODO Auto-generated constructor stub
		this.panelButton = new JPanel(new GridBagLayout());
		this.panelButton.setBorder(new TitledBorder("Panel Button"));
		this.panelButton.setBackground(Color.pink);
		
		this.cnst.gridy = 1;
		this.setCnstXZero();
		this.cnst.fill = GridBagConstraints.BOTH;
		
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
		this.setCnstXZero();
		this.panelButton.add(this.labels.getlExams(), cnst);
		this.setCnstXOne();
		this.panelButton.add(this.comboBoxes.getcExams(), cnst);
		
		this.incrementCnstY();
		this.panelButton.add(this.buttons.getUndo(), cnst);
		this.incrementCnstY();
		this.panelButton.add(this.buttons.getRedo(), cnst);
		this.incrementCnstY();
		this.panelButton.add(this.buttons.getSave(), cnst);
		
		
	}
	
	public JPanel getPanelButton(){
		return this.panelButton;
	}
	
	private void incrementCnstY(){
		this.cnst.gridy++;
	}
	
	private void setCnstXZero(){
		this.cnst.gridx = 0;
	}
	
	private void setCnstXOne(){
		this.cnst.gridx = 1;
	}

}
