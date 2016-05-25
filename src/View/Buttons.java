package View;

import javax.swing.JButton;

import Controller.ExportToXls;

public class Buttons {

	private final JButton insert;
	private final JButton generalView;
	private final JButton undo;
	private final JButton redo;
	private final JButton insertNew;
	private FrameInsert frame;
	private FrameModify frame1;
	private ComboBoxesViews comboBoxes = new ComboBoxesViews();
	private ExportToXls xls = new ExportToXls();

	public Buttons(MainGUI mainGUI) {

		this.insert = new JButton("INSERISCI");
		this.generalView = new JButton("VISTA GENERALE");
		this.undo = new JButton("UNDO");
		this.redo = new JButton("REDO");
		this.insertNew = new JButton("AGGIUNGI NUOVO DATO");

		this.insert.addActionListener(l -> {
			frame = new FrameInsert(mainGUI);
		});

		this.generalView.addActionListener(l -> {
		});
		this.undo.addActionListener(l->{
		    this.xls.save("Primo Semestre");
		});

		this.insertNew.addActionListener(l -> {
			frame1 = new FrameModify();

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

	public JButton getInsertNew() {
		return insertNew;
	}

}
