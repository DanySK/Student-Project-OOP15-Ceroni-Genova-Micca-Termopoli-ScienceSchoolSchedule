package View;

import javax.swing.*;

public class ComboBoxesViews {
	
	private final JComboBox cDays;
	private final JComboBox cRooms;
	private final JComboBox cHours;
	private final JComboBox cProfessor;
	private final JComboBox cCorses;
	private final JComboBox cExams;

	public ComboBoxesViews() {
		// TODO Auto-generated constructor stub
		this.cDays = new JComboBox();
		this.cRooms = new JComboBox();
		this.cHours = new JComboBox();
		this.cProfessor = new JComboBox();
		this.cCorses = new JComboBox();
		this.cExams = new JComboBox();
	}

	public JComboBox getcDays() {
		return cDays;
	}

	public JComboBox getcRooms() {
		return cRooms;
	}

	public JComboBox getcHours() {
		return cHours;
	}

	public JComboBox getcProfessor() {
		return cProfessor;
	}

	public JComboBox getcCorses() {
		return cCorses;
	}

	public JComboBox getcExams() {
		return cExams;
	}

}
