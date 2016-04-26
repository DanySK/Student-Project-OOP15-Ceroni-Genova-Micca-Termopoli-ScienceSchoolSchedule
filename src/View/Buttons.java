package View;

import java.awt.BorderLayout;

import javax.swing.*;

public class Buttons {

	private final JButton insert;
	private final JButton generalView;
	private final JButton undo;
	private final JButton redo;
	private final JButton save;
	
	public Buttons() {
		// TODO Auto-generated constructor stub
		this.insert = new JButton("INSERISCI");
		this.insert.setLayout(new BorderLayout());
		this.generalView = new JButton("VISTA GENERALE");
		this.undo = new JButton("UNDO");
		this.redo = new JButton("REDO");
		this.save = new JButton("SALVA");
	}

	public JButton getInsert() {
		return insert;
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

	public JButton getSave() {
		return save;
	}
	
	

}
