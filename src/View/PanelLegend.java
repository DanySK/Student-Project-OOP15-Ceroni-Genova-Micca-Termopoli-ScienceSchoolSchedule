package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Model.Type;

public class PanelLegend {

	private final JPanel panelLegend;

	public PanelLegend() {
		// TODO Auto-generated constructor stub
		final GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 0;
		this.panelLegend = new JPanel(new GridBagLayout());
		this.panelLegend.setBorder(new TitledBorder("LEGENDA"));
		for (final Type t : Type.values()) {
			c.gridx = 0;
			final JLabel rect = new JLabel("   ");
			rect.setOpaque(true);
			rect.setBackground(t.getColor());
			this.panelLegend.add(rect, c);
			c.gridx++;
			this.panelLegend.add(new JLabel(t.getCharacter()), c);
			c.gridy++;

		}
	}

	public JPanel getPanelLegend() {
		return panelLegend;
	}

}
