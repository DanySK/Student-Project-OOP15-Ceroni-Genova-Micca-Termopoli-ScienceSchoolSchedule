package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Controller.Reservation;

public class MainGUI {

    private JFrame frame = new JFrame("Science School Schedule");
    private PanelButton panelButton = new PanelButton(this);
    private PanelTable panelTable = new PanelTable();

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

    public void update(Reservation s, Integer row, Integer colum) {
        this.panelTable.setNew(s, row, colum);
    }

    public void removeRes(Integer row, Integer colum) {
        this.panelTable.remove(row, colum);
    }
    
    public void resetTable() {
        this.panelTable = new PanelTable();
    }

    public static void main(String[] args) {
        new MainGUI();
    }

}
