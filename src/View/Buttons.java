package View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ExportToXls;

public class Buttons {

	private final JButton insert;
	private final JButton generalView;
	private final JButton undo;
	private final JButton redo;
	private final JButton insertNew;
	private final JButton saveInExel;
	private final JButton resetTable;
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
		this.saveInExel = new JButton("ESPORTA IN EXEL");
		this.resetTable = new JButton("RESETTA LA TABELLA");

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
		
		this.resetTable.addActionListener(l -> {
			
		});
		
		this.saveInExel.addActionListener(l -> {
			
			final JFrame frameSave= new JFrame("ESPORTA IN EXEL");
			frameSave.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frameSave.setVisible(true);
			frameSave.setSize(400, 150);
			frameSave.setResizable(false);
			final JPanel panelSave = new JPanel(new GridBagLayout());
			final JLabel text = new JLabel("Inserisci nome file:  ");
			final JTextField exelTitle= new JTextField(15);
			exelTitle.setToolTipText("ESEMPIO: 1 semestre 15-16");
			JPanel panelBut = new JPanel();
			final JButton save = new JButton("Salva");
			
			final GridBagConstraints cost = new GridBagConstraints();
			cost.gridx = 0;
			cost.gridy = 1;
			cost.fill = GridBagConstraints.BOTH;
			panelSave.add(text,cost);
			cost.gridx = 1;
		    panelSave.add(exelTitle,cost);
		    panelBut.add(save);
		    
		    
			save.addActionListener(e->{
				String s= exelTitle.getText();
				xls.save(s);
				
				
			});
			
			frameSave.add(panelBut, BorderLayout.SOUTH);
			frameSave.add(panelSave);
			frameSave.setVisible(true);
		});

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
