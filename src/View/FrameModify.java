package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.lang.invoke.ConstantCallSite;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControllerWorkers;
import Model.Courses;

public class FrameModify {
	
	private final JFrame frameModify= new JFrame("Acquisizione nuovo elemento");
	private ControllerWorkers controller = new ControllerWorkers();
	
	private final JButton prof= new JButton("Professore");
	private final JButton room= new JButton("Aula");
	private final JComboBox<String> comboCourse1 = new JComboBox<String>();
	private final JComboBox<String> comboCourse2 = new JComboBox<String>();
	private final JComboBox<String> comboCourse3 = new JComboBox<String>();
	
	public FrameModify() {
		this.frameModify.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frameModify.setVisible(true);
        this.frameModify.setSize(400, 180);
        this.frameModify.setResizable(false);
        
        final JPanel panelModify = new JPanel(new GridBagLayout());
        final GridBagConstraints cnst= new GridBagConstraints();
        cnst.gridy=0;
        
        cnst.fill= GridBagConstraints.HORIZONTAL;
        panelModify.add(prof,cnst);
        cnst.gridy++;
        panelModify.add(room,cnst);
        
       prof.addActionListener(l->{
    	   
    	   this.frameModify.setVisible(false);
    	   final JFrame frameProf=new JFrame();    	   
    	   frameProf.setVisible(true);
    	   frameProf.setTitle("Inserimento nuovo professore");
    	   frameProf.setSize(800, 180);
    	   frameProf.setResizable(false);
    	   final JPanel profPanel=new JPanel(new GridBagLayout());
    	   final GridBagConstraints cost= new GridBagConstraints();
    	   final JLabel profLabel= new JLabel("Professore");
    	   final JLabel cours1Label= new JLabel("Corso 1:");
    	   final JLabel cours2Label= new JLabel("Corso 2:");
    	   final JLabel cours3Label= new JLabel("Corso 3:");
    	   
    	   final JTextField insProf= new JTextField(15);
   
    	   
    	   this.comboCourse1.addItem(" ");
    	   for (Courses courses : this.controller.getCoursesFromFile()) {
    		   this.comboCourse1.addItem( courses.getName());
		}
    	   
    	   this.comboCourse2.addItem(" ");
    	   for (Courses courses : this.controller.getCoursesFromFile()) {
    		   this.comboCourse2.addItem( courses.getName());
		}
    	 
    	   this.comboCourse3.addItem(" ");
    	   for (Courses courses : this.controller.getCoursesFromFile()) {
    		   this.comboCourse3.addItem( courses.getName());
		}
    	   
    	   cost.gridx = 0;
    	   cost.gridy = 1;
           cost.fill = GridBagConstraints.BOTH;
    	   profPanel.add(profLabel,cost);
    	   cost.gridx = 1;
    	   profPanel.add(insProf,cost);
    	   cost.gridy++;
    	   cost.gridy++;
    	   cost.gridx = 0;
    	   profPanel.add(cours1Label,cost);
    	   cost.gridx = 1;
    	   profPanel.add(this.comboCourse1,cost);
    	   cost.gridy++;
    	   cost.gridx = 0;
    	   profPanel.add(cours2Label,cost);
    	   cost.gridx = 1;
    	   profPanel.add(this.comboCourse2,cost);
    	   cost.gridy++;
    	   cost.gridx = 0;
    	   profPanel.add(cours3Label,cost);
    	   cost.gridx = 1;
    	   profPanel.add(this.comboCourse3, cost);
    	   
    	   final JButton save= new JButton("Salva");
    	   final JPanel panelSave= new JPanel();
    	   panelSave.add(save);
    	   frameProf.add(profPanel);
    	   frameProf.add(panelSave, BorderLayout.SOUTH);
    	   
       });
        
       room.addActionListener(l->{
    	    
    	   this.frameModify.setVisible(false);
    	   final JFrame frameRoom=new JFrame();    	   
    	   frameRoom.setVisible(true);
    	   frameRoom.setTitle("Inserimento nuovo professore");
    	   frameRoom.setSize(400, 180);
    	   frameRoom.setResizable(false);
    	   final JPanel roomPanel=new JPanel(new GridBagLayout());
    	   final JLabel roomLabel= new JLabel("Aula:");
    	   final JTextField insRoom= new JTextField(15);
    	   final JButton save= new JButton("Salva");
    	   final JPanel panelSave= new JPanel();
    	   panelSave.add(save);
    	   frameRoom.add(roomPanel);
    	   frameRoom.add(panelSave, BorderLayout.SOUTH);
    	   roomPanel.add(roomLabel);
    	   roomPanel.add(insRoom);
    	   
    	   frameRoom.add(roomPanel);
    	     
       }); 
        
       frameModify.add(panelModify, BorderLayout.CENTER);
       this.frameModify.setVisible(true);
		
		
	}

}
