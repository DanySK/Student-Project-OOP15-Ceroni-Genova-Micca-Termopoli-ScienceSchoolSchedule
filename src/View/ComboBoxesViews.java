package View;

import javax.swing.*;

import Model.ListRoom;
import Model.Days;
import Model.Hours;
import Model.ListCourses;
import Model.ListProfessor;

public class ComboBoxesViews {
	
	private final JComboBox<String> cDays;
	private final JComboBox<String> cRooms;
	private final JComboBox<String> cHours;
	private final JComboBox<String> cProfessor;
	private final JComboBox<String> cCorses;
	private final JComboBox<String> cExams;

	public ComboBoxesViews() {
		// TODO Auto-generated constructor stub
		this.cDays = new JComboBox<String>();
		this.cRooms = new JComboBox<String>();
		this.cHours = new JComboBox<String>();
		this.cProfessor = new JComboBox<String>();
		this.cCorses = new JComboBox<String>();
		this.cExams = new JComboBox<String>();
		
		cDays.addItem(" ");
		for ( Model.Days d : Days.values()) {
			cDays.addItem(d.getString());
		}
		cRooms.addItem(" ");
		for ( Model.ListRoom r : ListRoom.values()) {
			cRooms.addItem(r.getValue());
		}
		cHours.addItem(" ");
		for ( Model.Hours h : Hours.values()) {
			cHours.addItem(h.getValue());
		}
		cProfessor.addItem(" ");
		for ( Model.ListProfessor p : ListProfessor.values()){
			cProfessor.addItem(p.getValue());
		}
		cCorses.addItem(" ");
		for ( Model.ListCourses c : ListCourses.values()){
			cCorses.addItem(c.getValue());
		}
		
	}

	public JComboBox<String> getcDays() {
		return cDays;
	}

	public JComboBox<String> getcRooms() {
		return cRooms;
	}

	public JComboBox<String> getcHours() {
		return cHours;
	}

	public JComboBox<String> getcProfessor() {
		return cProfessor;
	}

	public JComboBox<String> getcCorses() {
		return cCorses;
	}

	public JComboBox<String> getcExams() {
		return cExams;
	}

}
