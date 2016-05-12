package View;

import java.awt.Color;
import java.awt.Component;
import Model.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JTextPane text;
	private final JScrollPane scroll;
	
	public TableRenderer() {
		super();
		this.text = new JTextPane();
		this.scroll = new JScrollPane(text);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);
	}
	
	@Override
	public Component getTableCellRendererComponent(final JTable table,
			final Object value, final boolean isSelected, final boolean hasFocus,
			final int row, final int column) {
		
		boolean isColored = false;
		Type type;
		final int height = scroll.getPreferredSize().height;
		final int wight = scroll.getPreferredSize().width;
		
		for (int i = 0 ;  i < Type.values().length && !isColored; i++){
			type = Type.values()[i];
			if(value.toString().contains(type.toString())){
				isColored = true;
				text.setBackground(type.getColor());
			}
		}
		
		if(!isColored) {
			text.setBackground(Color.WHITE);
		}
		
		text.setText(value.toString());
		if(table.getColumnModel().getColumn(column).getWidth() < wight) {
			table.getColumnModel().getColumn(column).setPreferredWidth(wight + Character.SIZE);
		}
		
		if(table.getRowHeight(row) < height) {
			table.setRowHeight(row, height);
		}
		
		return scroll;
	}

}
