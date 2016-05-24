package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import Controller.*;
import Model.*;


public class MyTableRenderer extends JLabel implements TableCellRenderer{

	/**
	 * 
	 */
	private SaveControllerInterface cont = new SaveController();
	private static final long serialVersionUID = 1L;
	private ControllerGui contr;
	private Set<Reservation> setReservation  = cont.getObjToSave().getListReservation();
	
	public MyTableRenderer(){
		this.setOpaque(true);
		contr = new ControllerGui();
		setReservation = contr.getSetReservation();
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
    	
    	this.setText((String)value);
    	String str = this.getText();
    	//System.out.println(str);
        this.setHorizontalAlignment(CENTER);
        this.setHorizontalAlignment(CENTER);
        ListCourses list;
        isSelected = false;
       
        if (row == 0 || column == 0 || ((row % (contr.getCont().getObjToSave().getListRoom().size() + 1)==0))) {
            //this.setBackground(Color.GRAY);
            //setForeground(Color.BLACK);
            //setFont(new Font("Helvetica",Font.BOLD,14));
            setBackground(new Color(171, 205, 239));
            setBorder(null);
            
        } else {
            Color c = Color.white;
            boolean isColored = false;
           
            /*for (Reservation reservation : setReservation) {
            	if((String) value == reservation.getCourse().getName()){
            		System.out.println(reservation.getCourse().getName());
            		c = reservation.getCourse().getType().getColor();
            	}
				
			}*/
            this.setBackground(c);
        }
        return this;
	}

}
