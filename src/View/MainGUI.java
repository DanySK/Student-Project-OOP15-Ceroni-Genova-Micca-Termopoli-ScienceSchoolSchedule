package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainGUI {

	private final JFrame frame = new JFrame("Science School Schedule");
	private final PanelButton panelButton = new PanelButton();
	private final PanelTable panelTable = new PanelTable();

	public MainGUI() {
		// TODO Auto-generated constructor stub
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int width = (int)screenSize.getWidth();
		final int height = (int)screenSize.getHeight();
		
		this.frame.setSize(width, height);
		this.frame.add(panelButton.getPanelButton(), BorderLayout.WEST);
		this.frame.add(panelTable);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainGUI();
	}
	
	public JFrame getMainFrame(){
		return this.frame;
	}
	
	public PanelTable getPanelTable(){
		return this.panelTable;
	}

}
