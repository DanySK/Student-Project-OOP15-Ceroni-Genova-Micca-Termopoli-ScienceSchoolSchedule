package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class MyListenerCancel implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		final JFrame frame = new JFrame("Seleziona dato per cancellare");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 700);
		frame.setResizable(false);
		frame.setVisible(true);
		
		final JPanel panelR = new JPanel(new BorderLayout());
		final JPanel panelRadio = new JPanel(new GridBagLayout());
		GridBagConstraints cnst = new GridBagConstraints();
		cnst.gridy = 1;
        cnst.fill = GridBagConstraints.BOTH;
		List<JRadioButton> buttons = new ArrayList<>();
		for(int i=0; i < 55;i++){
			buttons.add(new JRadioButton(i + " informazione di reservation "));
		}
		for(JRadioButton but : buttons){
			cnst.gridy++;
			panelRadio.add(but, cnst);
		}
		
		panelRadio.setAutoscrolls(true);
		final JScrollPane scroll = new JScrollPane(panelRadio);
		final JPanel panelCancel = new JPanel(new FlowLayout());
		final JButton delete = new JButton("Cancella");
		delete.addActionListener(l -> {
			for(JRadioButton but : buttons){
				if(but.isSelected()){
					//buttons.remove(but);
					//panelRadio.remove(but);
					System.out.println(but.getText());
				}
			}
		});
		
		panelCancel.add(delete);
		panelR.add(scroll);
		frame.add(panelR);
		frame.add(panelCancel, BorderLayout.SOUTH);
		
	}

}
