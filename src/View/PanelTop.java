package View;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PanelTop {
	
	private final JPanel panelTop;
	private final Buttons button = new Buttons();

	public PanelTop() {
		// TODO Auto-generated constructor stub
		this.panelTop = new JPanel(new BorderLayout());
		this.panelTop.add(button.getInsert(), BorderLayout.WEST);
	}
	
	public JPanel getPenelTop(){
		return this.panelTop;
	}

}
