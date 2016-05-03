package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

import Model.*;

public class PanelLegend {
	
	private final JPanel panelLegend;

	public PanelLegend() {
		// TODO Auto-generated constructor stub
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 0;
		this.panelLegend = new JPanel(new GridBagLayout());
		this.panelLegend.setBorder(new TitledBorder("LEGENDA"));
		for (final Type t : Type.values()){
			c.gridx = 0;
			final JLabel rect = new JLabel("   ");
			rect.setOpaque(true);
			rect.setBackground(t.getColor());
			this.panelLegend.add(rect, c);
			c.gridx++;
			this.panelLegend.add(new JLabel(t.getCharacter()),c);
			c.gridy++;
		
		
			
		}
	}

	public JPanel getPanelLegend() {
		return panelLegend;
	}

}
