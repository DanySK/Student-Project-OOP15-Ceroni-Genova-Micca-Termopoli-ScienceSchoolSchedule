package ViewBy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class MyListenerRoom implements ActionListener{

	private final static String EMPTYSTR= " ";
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox<String> combo = (JComboBox<String>) e.getSource();
		if(!combo.getSelectedItem().equals(EMPTYSTR)){
			new ViewByRoom(combo.getSelectedItem().toString());
		}
	}

}
