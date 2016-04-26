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
		this.panelButton.setBorder(new TitledBorder("Panel Botton"));
		this.panelButton.setBackground(Color.pink);
		
		this.panelButton.add(this.buttons.getInsert());
		
		this.cnst.gridy = 1;
		this.setCnstXZero();
		this.cnst.fill = GridBagConstraints.BOTH;
		
		this.panelButton.add(this.labels.getViews(),cnst);
		
		// da inserire i comboBoxes
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
