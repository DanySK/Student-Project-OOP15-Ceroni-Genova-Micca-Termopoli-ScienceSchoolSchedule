package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainGUI {

	private JFrame frame = new JFrame("Science School Schedule");
	private PanelButton panelButton = new PanelButton(this);
	private PanelTable panelTable = new PanelTable();
	private ComboBoxesViews combo = new ComboBoxesViews();

	public MainGUI() {

		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int width = (int) screenSize.getWidth();
		final int height = (int) screenSize.getHeight();

		this.frame.setSize(width, height);
		this.frame.add(panelButton.getPanelButton(), BorderLayout.WEST);
		this.frame.add(panelTable.getPanelTable());
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setVisible(true);
		this.frame.repaint();

	}

	public void update(String s, Integer row, Integer colum) {
		this.panelTable.Set(s, row, colum);

	}

	public static void main(String[] args) {
		new MainGUI();
	}

}
