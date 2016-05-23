package View;

import javax.swing.JButton;

public class Buttons {

	private final JButton insert;
	private final JButton generalView;
	private final JButton undo;
	private final JButton redo;
	private final JButton save;
	private FrameInsert frame;
	private ComboBoxesViews comboBoxes = new ComboBoxesViews();
	
	public Buttons(MainGUI mainGUI) {
		
		this.insert = new JButton("INSERISCI");
		this.generalView = new JButton("VISTA GENERALE");
		this.undo = new JButton("UNDO");
		this.redo = new JButton("REDO");
		this.save = new JButton("SALVA");
		
		this.insert.addActionListener(l -> {
			frame = new FrameInsert(mainGUI);
			insert.setEnabled(false);
		});
		
		this.generalView.addActionListener(l -> {
		});
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
