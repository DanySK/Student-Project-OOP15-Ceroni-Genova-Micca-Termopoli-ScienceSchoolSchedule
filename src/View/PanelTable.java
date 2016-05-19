package View;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class PanelTable {

    private JPanel panelTable;
    private JTable mainTable;
    private JScrollPane scroll;
    private TableGUI t = new TableGUI();
    private ControllerGui c = new ControllerGui();

    public PanelTable() {

        this.panelTable = new JPanel(new BorderLayout());
        this.panelTable.setBorder(new TitledBorder("Panel Table"));
        this.t = c.getTable();
        this.mainTable = new JTable(t);
        this.scroll = new JScrollPane(mainTable);
        this.resizeColumnWidth(mainTable);
        this.mainTable.setFillsViewportHeight(true);
        mainTable.setTableHeader(null);
        mainTable.setFillsViewportHeight(true);
        this.panelTable.add(scroll);

    }

    public JPanel getPanelTable() {
        return this.panelTable;
    }

    private void resizeColumnWidth(JTable table) {

        for (int column = 0; column < table.getColumnCount(); column++) {
            final TableColumn columnModel = table.getColumnModel().getColumn(column);
            int width = columnModel.getMinWidth();
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.setPreferredWidth(width);
        }
    }

    public void update(TableGUI p) {
        this.t = p;
        this.t.fireTableDataChanged();

    }

    public void Set(String i, int row, int colum) {
        t.setValueAt(i, row, colum);
    }

}
