package view;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class EditPanel extends JPanel {

	private MainView view;
	
	public EditPanel(MainView v){
		view = v;
		
		this.setLayout(null);
		
		Grid grid = new Grid(680, 570, 48, 48, view);
		this.add(grid);
		grid.setBounds(0, 0, 624, 624);
	}
	
}
