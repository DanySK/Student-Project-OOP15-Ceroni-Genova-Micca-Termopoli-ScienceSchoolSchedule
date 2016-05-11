package View;

import java.awt.*;
import java.awt.event.WindowStateListener;

import javax.swing.*;

import Controller.Reservation;

public class FrameInsert {
	
	private final JFrame frameInsert = new JFrame("Inserimento nuovo elemento");
	private ComboBoxesViews combo = new ComboBoxesViews();
	private Labels label = new Labels();
	

	public FrameInsert() {
		// TODO Auto-generated constructor stub
		this.frameInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frameInsert.setVisible(true);
		this.frameInsert.setSize(400, 180);
		this.frameInsert.setResizable(false);
		
		final JPanel panelInsert = new JPanel(new GridLayout(5,2));
		
		panelInsert.add(this.label.getlProfessor());
		panelInsert.add(this.combo.getcProfessor());
		
		panelInsert.add(this.label.getlCorses());
		panelInsert.add(this.combo.getcCorses());
		
		panelInsert.add(this.label.getlDays());
		panelInsert.add(this.combo.getcDays());
		
		panelInsert.add(this.label.getlHours());
		panelInsert.add(this.combo.getcHours());
		
		this.combo.LisenerCombo(this.combo.getcProfessor(), this.combo.getcCorses());
		
		final JPanel panelButton= new JPanel(new FlowLayout(FlowLayout.CENTER));
		final JButton apply= new JButton("Applica");
		panelButton.add(apply);
		
		this.frameInsert.add(panelInsert);
		this.frameInsert.add(panelButton, BorderLayout.SOUTH);
	}

}
