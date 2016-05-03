package View;

import java.awt.*;
import java.awt.event.WindowStateListener;

import javax.swing.*;

public class FrameInsert {
	
	private final JFrame frameInsert = new JFrame("Inserimento nuovo elemento");
	private ComboBoxesViews combo = new ComboBoxesViews();
	private Labels label = new Labels();

	public FrameInsert() {
		// TODO Auto-generated constructor stub
		this.frameInsert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frameInsert.setVisible(true);
		this.frameInsert.setSize(550, 180);
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
		
		panelInsert.add(new JButton("Applica"), BorderLayout.SOUTH);
		
		this.frameInsert.add(panelInsert);
	}

}
