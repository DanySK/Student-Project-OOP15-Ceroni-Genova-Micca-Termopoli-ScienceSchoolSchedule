package ViewBy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * The class implements ActionListener and override the actionPerformed method
 * that calls the frame ViewGeneral
 * 
 * @author Galya Genova
 *
 */
public class MyListenerView implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		new ViewGeneral("Tabella principale");
	}

}
