package view;

import javax.swing.JPanel;

public class EditPanel extends JPanel {

	private MainView view;
	
	/* Constructor
	 * @param v main view object
	 */
	public EditPanel(MainView v){
		view = v;
		
		this.setLayout(null);
		
		// Draws grid
		Grid grid = new Grid(680, 570, 48, 48, view);
			this.add(grid);
			grid.setBounds(0, 0, 624, 624);
	}
	
}
