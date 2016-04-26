package View;

import javax.swing.*;

public class Labels {
	
	private final JLabel views;
	private final JLabel lDays;
	private final JLabel lRooms;
	private final JLabel lHours;
	private final JLabel lProfessor;
	private final JLabel lCorses;
	private final JLabel lExams;

	public Labels() {
		// TODO Auto-generated constructor stub
		this.views = new JLabel("SELEZIONA VISTA: ");
		this.lDays = new JLabel("Giorno: ");
		this.lRooms = new JLabel("Aula: ");
		this.lHours = new JLabel("Orario: ");
		this.lProfessor = new JLabel("Docente: ");
		this.lCorses = new JLabel("Corso: ");
		this.lExams = new JLabel("Esame: ");
	}

	public JLabel getViews() {
		return views;
	}

	public JLabel getlDays() {
		return lDays;
	}

	public JLabel getlRooms() {
		return lRooms;
	}

	public JLabel getlHours() {
		return lHours;
	}

	public JLabel getlProfessor() {
		return lProfessor;
	}

	public JLabel getlCorses() {
		return lCorses;
	}

	public JLabel getlExams() {
		return lExams;
	}

}
