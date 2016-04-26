package View;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class PanelTable {
	
	private JPanel panelTable;
	
	public PanelTable() {
		// TODO Auto-generated constructor stub
		this.panelTable = new JPanel(new GridBagLayout());
		this.panelTable.setBorder(new TitledBorder("Panel Table"));
	}
	
	public JPanel getPanelTable(){
		return this.panelTable;
	}

}
