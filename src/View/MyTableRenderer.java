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
	private static final long serialVersionUID = 1L;
	private ControllerGui contr = new ControllerGui();
	private Set<Reservation> setReservation = contr.getSetReservation();
	
	public MyTableRenderer(){
		this.setOpaque(true);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
    	
    	this.setText((String)value);
    	String str = (String) value;
        this.setHorizontalAlignment(CENTER);
        this.setHorizontalAlignment(CENTER);
        ListCourses list;
        isSelected = false;
       
        if (row == 0 || column == 0 || ((row % (contr.getCont().getObjToSave().getListRoom().size() + 1)==0))) {
            //this.setBackground(Color.GRAY);
            //setForeground(Color.BLACK);
            //setFont(new Font("Helvetica",Font.BOLD,14));
            setBackground(Color.LIGHT_GRAY);
            setBorder(null);
            
        } else {
            Color c = Color.white;
            boolean isColored = false;
            
            for(Reservation res : this.setReservation){
            	if((String) value == res.getCourse().getName())
            	{
            		isColored = true;
            		c = res.getCourse().getType().getColor();
            	}
            		
            }
            /*for(int i=0; i < ListCourses.values().length && !isColored; i++){
            	list = ListCourses.values()[i];
            	
            	c = list.getType().getColor();
            		
            }*/
            this.setBackground(c);
        }
        return this;
	}

}
