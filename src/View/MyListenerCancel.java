package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MyListenerCancel implements ActionListener{
    MainGUI mainGUI ;
	public MyListenerCancel(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		
		//JButton button = (JButton) e.getSource();
		try {
			new FrameCancel(mainGUI);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
}
