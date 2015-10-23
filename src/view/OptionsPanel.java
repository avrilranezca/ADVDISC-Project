package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.Controller;

public class OptionsPanel extends JPanel {
	
	JLabel  labelSelect;
	JButton buttonPrev;
	JButton buttonNext;
	
	JLabel  labelAdd;
	JButton buttonPoint;
	JButton buttonLine;
	JButton buttonEllipse;
	JButton buttonPolygon;
	JButton buttonParabola;
	JButton buttonHyperbola;
	
	JLabel  labelEdit;
	JButton buttonTranslate;
	JButton buttonRotate;
	JButton buttonShear;
	JButton buttonScale;
	JButton buttonReflect;
	JButton buttonDelete;
	
	JTextField   field1;
	JTextField   field2;
	JTextField   field3;
	JTextField   field4;
	JComboBox    dropdown;
	JButton      buttonAdd;
	JButton		 buttonCancel;
	
	JPanel  panelInput;
	
	ArrayList<Integer> polygonXCoords;
	ArrayList<Integer> polygonYCoords;
	
	int currentlyEditing;
	GraphicObject previousObject;
	
	int editing;
	
	MainView   view;
	
	public OptionsPanel(MainView v){
		view = v;
		currentlyEditing = view.getSelectedObject();
		editing = 0;
		
		this.setLayout(null);
		
		// Panel Input
		
		panelInput = new JPanel();
			this.add(panelInput);
			panelInput.setLayout(new BorderLayout());
			panelInput.setBounds(10, 320, 265, 300);
		
		// Select Object
		
		labelSelect = new JLabel("Select Object");
			this.add(labelSelect);
			labelSelect.setBounds(102, 0, 275, 30);
		
		buttonPrev  = new JButton("< Previous");
			this.add(buttonPrev);
			buttonPrev.setBounds(0, 30, 145, 30);
			buttonPrev.addActionListener(new selectPrevListener());
		
		buttonNext  = new JButton("Next >");
			this.add(buttonNext);
			buttonNext.setBounds(140, 30, 145, 30);
			buttonNext.addActionListener(new selectNextListener());
		
		// Add Object
		
		labelAdd        = new JLabel("Add Object");
			this.add(labelAdd);
			labelAdd.setBounds(108, 70, 275, 30);
		
		buttonPoint     = new JButton("Point");
			this.add(buttonPoint);
			buttonPoint.setBounds(0, 100, 145, 30);
			buttonPoint.addActionListener(new addPointListener(panelInput));
		
		buttonLine      = new JButton("Line Segment");
			this.add(buttonLine);
			buttonLine.setBounds(140, 100, 145, 30);
			buttonLine.addActionListener(new addLineListener(panelInput));
		
		buttonEllipse   = new JButton("Ellipse");
			this.add(buttonEllipse);
			buttonEllipse.setBounds(0, 125, 145, 30);
			buttonEllipse.addActionListener(new addEllipseListener(panelInput));
		
		buttonPolygon   = new JButton("Polygon");
			this.add(buttonPolygon);
			buttonPolygon.setBounds(140, 125, 145, 30);
			buttonPolygon.addActionListener(new addPolygonListener(panelInput));
		
		buttonParabola  = new JButton("Parabola");
			this.add(buttonParabola);
			buttonParabola.setBounds(0, 150, 145, 30);
			buttonParabola.addActionListener(new addParabolaListener(panelInput));
		
		buttonHyperbola = new JButton("Hyperbola");
			this.add(buttonHyperbola);
			buttonHyperbola.setBounds(140, 150, 145, 30);
			buttonHyperbola.addActionListener(new addHyperbolaListener(panelInput));
		
		// Edit Object
		
		labelEdit       = new JLabel("Edit Object");
			this.add(labelEdit);
			labelEdit.setBounds(107, 190, 275, 30);
		
		buttonTranslate = new JButton("Translate");
			this.add(buttonTranslate);
			buttonTranslate.setBounds(0, 220, 145, 30);
			buttonTranslate.addActionListener(new editListener(panelInput, MainView.EDIT_TRANSLATE));
		
		buttonRotate    = new JButton("Rotate");
			this.add(buttonRotate);
			buttonRotate.setBounds(140, 220, 145, 30);
			buttonRotate.addActionListener(new editListener(panelInput, MainView.EDIT_ROTATE));
		
		buttonShear     = new JButton("Shear");
			this.add(buttonShear);
			buttonShear.setBounds(0, 245, 145, 30);
			buttonShear.addActionListener(new editListener(panelInput, MainView.EDIT_SHEAR));
		
		buttonScale     = new JButton("Scale");
			this.add(buttonScale);
			buttonScale.setBounds(140, 245, 145, 30);
			buttonScale.addActionListener(new editListener(panelInput, MainView.EDIT_SCALE));
		
		buttonReflect   = new JButton("Reflect");
			this.add(buttonReflect);
			buttonReflect.setBounds(0, 270, 145, 30);
			buttonReflect.addActionListener(new editListener(panelInput, MainView.EDIT_REFLECT));
		
		buttonDelete    = new JButton("Delete");
			this.add(buttonDelete);
			buttonDelete.setBounds(140, 270, 145, 30);
			buttonDelete.addActionListener(new editListener(panelInput, MainView.EDIT_DELETE));
	}
	
// ERROR CHECKING
	
	private boolean isValid(String input){
		try{
		  Double.parseDouble(input);
		}
		catch(NumberFormatException e){
		  return false;
		}
		return true;
	}
	
	private boolean isPositive(String input){
		System.out.println("isPositive");
		System.out.println("> input: " + input);
		if(isValid(input)){
			System.out.println("> Double.parseDouble(input): " + Double.parseDouble(input));
			if(Double.parseDouble(input) > 0){
				return true;
			}
		}
		return false;
	}
	
	private void displayError(){
		panelInput.removeAll();
		panelInput.add(new errorPanel(panelInput));
		repaint();
		revalidate();
	}
	
// INPUT PANELS (ADDING)
	
	private class addPointPanel extends JPanel {
		public addPointPanel(){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			JPanel flow1 = new JPanel();
				flow1.add(new JLabel("X Coordinate"));
				field1 = new JTextField(5);
				flow1.add(field1);
				this.add(flow1);
				
			JPanel flow2 = new JPanel();
				flow2.add(new JLabel("Y Coordinate"));
				field2 = new JTextField(5);
				flow2.add(field2);
				this.add(flow2);
				
			buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
				
			buttonAdd = new JButton("Add Point");
				buttonAdd.addActionListener(new finalAddPointListener());
				this.add(buttonAdd);
		}
	}
	
	private class addLinePanel extends JPanel {
		public addLinePanel(){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			JPanel flow1 = new JPanel();
				flow1.add(new JLabel("X Coordinate (First Point)"));
				field1 = new JTextField(5);
				flow1.add(field1);
				this.add(flow1);
				
			JPanel flow2 = new JPanel();
				flow2.add(new JLabel("Y Coordinate (First Point)"));
				field2 = new JTextField(5);
				flow2.add(field2);
				this.add(flow2);
				
			JPanel flow3 = new JPanel();
				flow3.add(new JLabel("X Coordinate (Second Point)"));
				field3 = new JTextField(5);
				flow3.add(field3);
				this.add(flow3);
				
			JPanel flow4 = new JPanel();
				flow4.add(new JLabel("Y Coordinate (Second Point)"));
				field4 = new JTextField(5);
				flow4.add(field4);
				this.add(flow4);
			
			buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
				
			buttonAdd = new JButton("Add Line");
				buttonAdd.addActionListener(new finalAddLineListener());
				this.add(buttonAdd);
		}
	}
	
	private class addEllipsePanel extends JPanel {
		public addEllipsePanel(){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			JPanel flow1 = new JPanel();
				flow1.add(new JLabel("X Coordinate (Center)"));
				field1 = new JTextField(5);
				flow1.add(field1);
				this.add(flow1);
				
			JPanel flow2 = new JPanel();
				flow2.add(new JLabel("Y Coordinate (Center)"));
				field2 = new JTextField(5);
				flow2.add(field2);
				this.add(flow2);
				
			JPanel flow3 = new JPanel();
				flow3.add(new JLabel("Width"));
				field3 = new JTextField(5);
				flow3.add(field3);
				this.add(flow3);
				
			JPanel flow4 = new JPanel();
				flow4.add(new JLabel("Height"));
				field4 = new JTextField(5);
				flow4.add(field4);
				this.add(flow4);
			
			buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
				
			buttonAdd = new JButton("Add Ellipse");
				buttonAdd.addActionListener(new finalAddEllipseListener());
				this.add(buttonAdd);
		}
	}
	
	private class addPolygonPanel extends JPanel {
		JLabel pointLabel;
		
		public addPolygonPanel(){
			polygonXCoords = new ArrayList<Integer>();
			polygonYCoords = new ArrayList<Integer>();
					
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			JPanel flow1 = new JPanel();
				pointLabel = new JLabel("Point 1");
				flow1.add(pointLabel);
				this.add(pointLabel);
				this.add(flow1);
			
			JPanel flow2 = new JPanel();
				flow2.add(new JLabel("X Coordinate"));
				field1 = new JTextField(5);
				flow2.add(field1);
				this.add(flow2);
				
			JPanel flow3 = new JPanel();
				flow3.add(new JLabel("Y Coordinate"));
				field2 = new JTextField(5);
				flow3.add(field2);
				this.add(flow3);
				
			buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
				
			JButton buttonAddPoint = new JButton("Add Point");
				buttonAddPoint.addActionListener(new addPolygonPoints(this));
				this.add(buttonAddPoint);
		}
		
		private class addPolygonPoints implements ActionListener {
			JPanel parentContainer;
			
			public addPolygonPoints(JPanel c){
				parentContainer = c;
			}
			
			public void actionPerformed(ActionEvent e) {
				String val1 = field1.getText();
				String val2 = field2.getText();
				
				if(OptionsPanel.this.isValid(val1)
					&& OptionsPanel.this.isValid(val2)){
					
					polygonXCoords.add(Integer.parseInt(val1));
					polygonYCoords.add(Integer.parseInt(val2));
					
					field1.setText("");
					field2.setText("");
					
					pointLabel.setText("Point " + (polygonXCoords.size() + 1));
					
					if(polygonXCoords.size() == 3){
						buttonAdd = new JButton("Add Polygon");
						buttonAdd.addActionListener(new finalAddPolygonListener());
						parentContainer.add(buttonAdd);
						repaint();
						revalidate();
					}
				}
				else{
					displayError();
				}
			}
		}
	}
	
	private class addParabolaPanel extends JPanel {
		public addParabolaPanel(){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			JPanel flow1 = new JPanel();
				flow1.add(new JLabel("X Coordinate (Vertex)"));
				field1 = new JTextField(5);
				flow1.add(field1);
				this.add(flow1);
				
			JPanel flow2 = new JPanel();
				flow2.add(new JLabel("Y Coordinate (Vertex)"));
				field2 = new JTextField(5);
				flow2.add(field2);
				this.add(flow2);
				
			JPanel flow3 = new JPanel();
				flow3.add(new JLabel("Focal Length"));
				field3 = new JTextField(5);
				flow3.add(field3);
				this.add(flow3);
				
			JPanel flow4 = new JPanel();
				flow4.add(new JLabel("Direction"));
				this.add(flow4);
				
			JPanel flow5 = new JPanel();
				String[] dir = {"Opening Right",
						        "Opening Left",
						        "Opening Up",
						        "Opening Down"};
				dropdown = new JComboBox(dir);
				flow5.add(dropdown);
				this.add(flow5);
				
			buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
				
			buttonAdd = new JButton("Add Parabola");
				buttonAdd.addActionListener(new finalAddParabolaListener());
				this.add(buttonAdd);
		}
	}
	
	private class addHyperbolaPanel extends JPanel {
		public addHyperbolaPanel(){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			JPanel flow1 = new JPanel();
				flow1.add(new JLabel("X Coordinate (Vertex)"));
				field1 = new JTextField(5);
				flow1.add(field1);
				this.add(flow1);
				
			JPanel flow2 = new JPanel();
				flow2.add(new JLabel("Y Coordinate (Vertex)"));
				field2 = new JTextField(5);
				flow2.add(field2);
				this.add(flow2);
				
			JPanel flow3 = new JPanel();
				flow3.add(new JLabel("Horizontal Distance"));
				field3 = new JTextField(5);
				flow3.add(field3);
				this.add(flow3);
				
			JPanel flow4 = new JPanel();
				flow4.add(new JLabel("Vertical Distance"));
				field4 = new JTextField(5);
				flow4.add(field4);
				this.add(flow4);
				
			JPanel flow5 = new JPanel();
				flow5.add(new JLabel("Direction"));
				this.add(flow5);
				
			JPanel flow6 = new JPanel();
				String[] dir = {"Opening Right & Left",
						        "Opening Up & Down"};
				dropdown = new JComboBox(dir);
				flow6.add(dropdown);
				this.add(flow6);
				
			buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
				
			buttonAdd = new JButton("Add Hyperbola");
				buttonAdd.addActionListener(new finalAddHyperbolaListener());
				this.add(buttonAdd);
		}
	}
	
// INPUT PANELS (EDITING)
	
	private class translatePanel extends JPanel {
		public translatePanel(JPanel updatePanel){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			JPanel flow1 = new JPanel();
				flow1.add(new JLabel("X-Axis Translation"));
				field1 = new JTextField(5);
				flow1.add(field1);
				this.add(flow1);
				
			JPanel flow2 = new JPanel();
				flow2.add(new JLabel("Y-Axis Translation"));
				field2 = new JTextField(5);
				flow2.add(field2);
				this.add(flow2);
				
			buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
				
			buttonAdd = new addButton("Translate",
									  view.getObject(view.getSelectedObject()),
									  updatePanel);
				this.add(buttonAdd);
		}
	}
	
	private class rotatePanel extends JPanel {
		public rotatePanel(JPanel updatePanel){
			System.out.println("rotatePanel (Constructor)");
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			GraphicObject currObj = view.getObject(view.getSelectedObject());
			
			if(currObj instanceof PointDrawer
				|| currObj instanceof LineDrawer
				|| currObj instanceof PolygonDrawer){
				
				JPanel flow1 = new JPanel();
				flow1.add(new JLabel("Rotation (Degrees)"));
					field1 = new JTextField(5);
					flow1.add(field1);
					this.add(flow1);
				
			}
			
			else if(currObj instanceof EllipseDrawer
					|| currObj instanceof ParabolaDrawer
					|| currObj instanceof HyperbolaDrawer){
				
				JPanel flow1 = new JPanel();
					flow1.add(new JLabel("Rotation (Degrees)"));
					String[] deg = {"90 degrees",
								  	"180 degrees",
								  	"270 degrees"};
					dropdown = new JComboBox(deg);
					flow1.add(dropdown);
					this.add(flow1);
				
			}
			
			buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
				
			buttonAdd = new addButton("Rotate",
									  view.getObject(view.getSelectedObject()),
									  updatePanel);
				this.add(buttonAdd);
		}
	}
	
	private class shearPanel extends JPanel {
		public shearPanel(JPanel updatePanel){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			GraphicObject currObj = view.getObject(view.getSelectedObject());
			
			if(currObj instanceof LineDrawer
				|| currObj instanceof PolygonDrawer){
					
				JPanel flow1 = new JPanel();
				flow1.add(new JLabel("Rotation (Degrees)"));
					field1 = new JTextField(5);
					flow1.add(field1);
					this.add(flow1);
				
				buttonCancel = new JButton("Cancel");
					buttonCancel.addActionListener(new cancelListener(this));
					this.add(buttonCancel);
					
				buttonAdd = new addButton("Shear",
						  view.getObject(view.getSelectedObject()),
						  updatePanel);
					this.add(buttonAdd);
			}
			
			else if(currObj instanceof PointDrawer
					|| currObj instanceof EllipseDrawer
					|| currObj instanceof ParabolaDrawer
					|| currObj instanceof HyperbolaDrawer){
				
				JPanel flow1 = new JPanel();
					flow1.add(new JLabel("This object cannot be sheared"));
					this.add(flow1);
				
				buttonCancel = new JButton("Continue");
					buttonCancel.addActionListener(new cancelListener(this));
					this.add(buttonCancel);
			}
			
		}
	}
	
	private class scalePanel extends JPanel {
		public scalePanel(JPanel updatePanel){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			GraphicObject currObj = view.getObject(view.getSelectedObject());
			
			if(currObj instanceof PointDrawer){
				JPanel flow1 = new JPanel();
				flow1.add(new JLabel("This object cannot be scaled"));
				this.add(flow1);
			
				buttonCancel = new JButton("Continue");
					buttonCancel.addActionListener(new cancelListener(this));
					this.add(buttonCancel);
			}
			else{
				JPanel flow1 = new JPanel();
					flow1.add(new JLabel("Scale Value"));
					field1 = new JTextField(5);
					flow1.add(field1);
					this.add(flow1);
				
				buttonCancel = new JButton("Cancel");
					buttonCancel.addActionListener(new cancelListener(this));
					this.add(buttonCancel);
					
				buttonAdd = new addButton("Scale",
						  view.getObject(view.getSelectedObject()),
						  updatePanel);
					this.add(buttonAdd);
			}
				
			
			
		}
	}
	
	private class reflectPanel extends JPanel {
		public reflectPanel(JPanel updatePanel){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			GraphicObject currObj = view.getObject(view.getSelectedObject());
			
			JPanel flow1 = new JPanel();
				flow1.add(new JLabel("Reflection"));
				String[] ref = {"X-Axis",
							  	"Y-Axis"};
				dropdown = new JComboBox(ref);
				flow1.add(dropdown);
				this.add(flow1);
			
			buttonAdd = new addButton("Reflect",
									  view.getObject(view.getSelectedObject()),
									  updatePanel);
				this.add(buttonAdd);
			
			buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
		}
	}
	
	private class addButton extends JButton{
		public addButton(String name, GraphicObject currObj, JPanel updatePanel){
			super(name);
			this.addActionListener(new confirmEditListener(updatePanel));
		}
	}
	
// CONFIRM EDIT PANELS
	
	private class confirmPanel extends JPanel {
		public confirmPanel(JPanel updatePanel, double[][] data){
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			GraphicObject o = view.getObject(currentlyEditing);
			
			if(o instanceof PointDrawer){
				this.add(new JLabel("PREVIOUS (Blue)"));
				this.add(new JLabel("X-Coordinate: " + ((PointDrawer)previousObject).getXCoord()));
				this.add(new JLabel("Y-Coordinate: " + ((PointDrawer)previousObject).getYCoord()));
				this.add(new JLabel("- - - - - - - - - - -"));
				this.add(new JLabel("NEW (Red)"));
				this.add(new JLabel("X-Coordinate: " + data[0][0]));
				this.add(new JLabel("Y-Coordinate: " + data[0][1]));
			}
			
			else if(o instanceof LineDrawer){
				this.add(new JLabel("PREVIOUS (Blue)"));
				this.add(new JLabel("X-Coordinate (Point 1): " + ((LineDrawer)previousObject).getX1Coord()));
				this.add(new JLabel("Y-Coordinate (Point 1): " + ((LineDrawer)previousObject).getY1Coord()));
				this.add(new JLabel("X-Coordinate (Point 2): " + ((LineDrawer)previousObject).getX2Coord()));
				this.add(new JLabel("Y-Coordinate (Point 2): " + ((LineDrawer)previousObject).getY2Coord()));
				this.add(new JLabel("- - - - - - - - - - -"));
				this.add(new JLabel("NEW (Red)"));
				this.add(new JLabel("X-Coordinate (Point 1): " + data[0][0]));
				this.add(new JLabel("Y-Coordinate (Point 1): " + data[0][1]));
				this.add(new JLabel("X-Coordinate (Point 2): " + data[1][0]));
				this.add(new JLabel("Y-Coordinate (Point 2): " + data[1][1]));
			}
			
			else if(o instanceof EllipseDrawer){
				this.add(new JLabel("PREVIOUS (Blue)"));
				this.add(new JLabel("X-Coordinate (Center): " + ((EllipseDrawer)previousObject).getXCoord()));
				this.add(new JLabel("Y-Coordinate (Center): " + ((EllipseDrawer)previousObject).getYCoord()));
				this.add(new JLabel("Width: " + ((EllipseDrawer)previousObject).getWidth()));
				this.add(new JLabel("Height: " + ((EllipseDrawer)previousObject).getHeight()));
				this.add(new JLabel("- - - - - - - - - - -"));
				this.add(new JLabel("NEW (Red)"));
				this.add(new JLabel("X-Coordinate (Center): " + data[0][0]));
				this.add(new JLabel("Y-Coordinate (Center): " + data[0][1]));
				this.add(new JLabel("Width: " + data[1][0]));
				this.add(new JLabel("Height: " + data[1][1]));
			}
			
			else if(o instanceof PolygonDrawer){
				this.add(new JLabel("PREVIOUS (Blue)"));
				for(int i = 0; i < ((PolygonDrawer)previousObject).getPointCount(); i++){
					this.add(new JLabel("X-Coordinate (Point " + (i+1) + "): " + ((PolygonDrawer)previousObject).getXCoord(i)));
					this.add(new JLabel("Y-Coordinate (Point " + (i+1) + "): " + ((PolygonDrawer)previousObject).getYCoord(i)));
				}
				this.add(new JLabel("- - - - - - - - - - -"));
				this.add(new JLabel("NEW (Red)"));
				for(int i = 0; i < data.length; i++){
					this.add(new JLabel("X-Coordinate (Point " + (i+1) + "): " + data[i][0]));
					this.add(new JLabel("Y-Coordinate (Point " + (i+1) + "): " + data[i][1]));
				}
			}
			
			else if(o instanceof ParabolaDrawer){
				this.add(new JLabel("PREVIOUS (Blue)"));
				this.add(new JLabel("X-Coordinate (Vertex): " + ((ParabolaDrawer)previousObject).getXCoord()));
				this.add(new JLabel("Y-Coordinate (Vertex): " + ((ParabolaDrawer)previousObject).getYCoord()));
				this.add(new JLabel("Focal Length: " + ((ParabolaDrawer)previousObject).getFocalLength()));
				this.add(new JLabel("Direction: " + MainView.getPDirectionString(((ParabolaDrawer)previousObject).getDirection())));
				this.add(new JLabel("- - - - - - - - - - -"));
				this.add(new JLabel("NEW (Red)"));
				this.add(new JLabel("X-Coordinate (Vertex): " + data[0][0]));
				this.add(new JLabel("Y-Coordinate (Vertex): " + data[0][1]));
				this.add(new JLabel("Focal Length: " + data[1][0]));
				this.add(new JLabel("Direction: " + MainView.getPDirectionString((int)data[1][1])));
			}
			
			else if(o instanceof HyperbolaDrawer){
				this.add(new JLabel("PREVIOUS (Blue)"));
				this.add(new JLabel("X-Coordinate (Vertex): " + ((HyperbolaDrawer)previousObject).getXCoord()));
				this.add(new JLabel("Y-Coordinate (Vertex): " + ((HyperbolaDrawer)previousObject).getYCoord()));
				this.add(new JLabel("Vertical Distance: " + ((HyperbolaDrawer)previousObject).getXDistance()));
				this.add(new JLabel("Horizontal Distance: " + ((HyperbolaDrawer)previousObject).getYDistance()));
				this.add(new JLabel("Direction: " + MainView.getHDirectionString(((HyperbolaDrawer)previousObject).getDirection())));
				this.add(new JLabel("- - - - - - - - - - -"));
				this.add(new JLabel("NEW (Red)"));
				this.add(new JLabel("X-Coordinate (Vertex): " + data[0][0]));
				this.add(new JLabel("Y-Coordinate (Vertex): " + data[0][1]));
				this.add(new JLabel("Vertical Distance: " + data[1][0]));
				this.add(new JLabel("Horizontal Distance: " + data[1][1]));
				this.add(new JLabel("Direction: " + MainView.getHDirectionString((int)data[2][0])));
			}
			
			buttonAdd = new JButton("Apply");
			buttonAdd.addActionListener(new applyEditListener(updatePanel));
			this.add(buttonAdd);
		}
	}
	
// ERROR PANEL
	
	private class errorPanel extends JPanel {
		public errorPanel(JPanel updatePanel){
			System.out.println("errorPanel (Constructor)");
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			JPanel flow1 = new JPanel();
				flow1.add(new JLabel("Invalid Input"));
				this.add(flow1);
			
			buttonCancel = new JButton("Continue");
				buttonCancel.addActionListener(new cancelListener(this));
				this.add(buttonCancel);
		}
	}
	
// SELECT BUTTON LISTENERS
	
	private class selectPrevListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(editing == 0)
				view.movePrevObject();
		}
	}
	
	private class selectNextListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(editing == 0)
				view.moveNextObject();
		}
	}
	
// ADD OBJECT BUTTON LISTENERS
	
	private class addPointListener implements ActionListener {
		JPanel updatePanel;
		
		public addPointListener(JPanel u){
			updatePanel = u;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				updatePanel.removeAll();
				updatePanel.add(new addPointPanel());
				repaint();
				revalidate();
			}
		}
	}
	
	private class addLineListener implements ActionListener {
		JPanel updatePanel;
		
		public addLineListener(JPanel u){
			updatePanel = u;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				updatePanel.removeAll();
				updatePanel.add(new addLinePanel());
				repaint();
				revalidate();
			}
		}
	}
	
	private class addEllipseListener implements ActionListener {
		JPanel updatePanel;
		
		public addEllipseListener(JPanel u){
			updatePanel = u;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				updatePanel.removeAll();
				updatePanel.add(new addEllipsePanel());
				repaint();
				revalidate();
			}
		}
	}
	
	private class addPolygonListener implements ActionListener {
		JPanel updatePanel;
		
		public addPolygonListener(JPanel u){
			updatePanel = u;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				updatePanel.removeAll();
				updatePanel.add(new addPolygonPanel());
				repaint();
				revalidate();
			}
		}
	}
	
	private class addParabolaListener implements ActionListener {
		JPanel updatePanel;
		
		public addParabolaListener(JPanel u){
			updatePanel = u;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				updatePanel.removeAll();
				updatePanel.add(new addParabolaPanel());
				repaint();
				revalidate();
			}
		}
	}
	
	private class addHyperbolaListener implements ActionListener {
		JPanel updatePanel;
		
		public addHyperbolaListener(JPanel u){
			updatePanel = u;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				updatePanel.removeAll();
				updatePanel.add(new addHyperbolaPanel());
				repaint();
				revalidate();
			}
		}
	}
	
// FINALIZING ADDING OF OBJECTS LISTENERS
	
	private class finalAddPointListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				String val1 = field1.getText();
				String val2 = field2.getText();
				
				if(isValid(val1) && isValid(val2)){
					int x = Integer.parseInt(val1);
					int y = Integer.parseInt(val2);
					if(Controller.addPoint(x, y)){
						view.addPoint(x, y);
					}
				}
				else{
					displayError();
				}
			}
		}
	}
	
	private class finalAddLineListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				String val1 = field1.getText();
				String val2 = field2.getText();
				String val3 = field3.getText();
				String val4 = field4.getText();
				
				if(isValid(val1) && isValid(val2)
					&& isValid(val3) && isValid(val4)){
					int x1 = Integer.parseInt(val1);
					int y1 = Integer.parseInt(val2);
					int x2 = Integer.parseInt(val3);
					int y2 = Integer.parseInt(val4);
					
					if(Controller.addLine(x1, y1, x2, y2)){
						view.addLine(x1, y1, x2, y2);
					}
				}
				else{
					displayError();
				}
				
			}
		}
	}
	
	private class finalAddEllipseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				String val1 = field1.getText();
				String val2 = field2.getText();
				String val3 = field3.getText();
				String val4 = field4.getText();
				
				if(isValid(val1) && isValid(val2)
					&& isPositive(val3) && isPositive(val4)){
					int x = Integer.parseInt(val1);
					int y = Integer.parseInt(val2);
					int w = Integer.parseInt(val3);
					int h = Integer.parseInt(val4);
					
					if(Controller.addEllipse(x, y, w, h)){
						view.addEllipse(x, y, w, h);
					}
				}
				else{
					displayError();
				}
			}
		}
	}
	
	private class finalAddPolygonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				double[][] points = new double[polygonXCoords.size()][2];
				
				for(int i = 0; i < polygonXCoords.size(); i++){
					points[i][0] = polygonXCoords.get(i);
					points[i][1] = polygonYCoords.get(i);
				}
				
				if(Controller.addPolygon(points)){
					view.addPolygon(points);
				}
			}
		}
	}
	
	private class finalAddParabolaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				String val1 = field1.getText();
				String val2 = field2.getText();
				String val3 = field3.getText();
				
				if(isValid(val1) && isValid(val2)
					&& isPositive(val3)){
					
					int x = Integer.parseInt(val1);
					int y = Integer.parseInt(val2);
					int f = Integer.parseInt(val3);
					int d = dropdown.getSelectedIndex() + 1;
					
					if(Controller.addParabola(x, y, f, d)){
						view.addParabola(x, y, f, d);
					}
				}
				else{
					displayError();
				}
				
			}
		}
	}
	
	private class finalAddHyperbolaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(editing == 0){
				String val1 = field1.getText();
				String val2 = field2.getText();
				String val3 = field3.getText();
				String val4 = field4.getText();
				
				if(isValid(val1) && isValid(val2)
					&& isPositive(val3) && isPositive(val4)){
					
					int x  = Integer.parseInt(val1);
					int y  = Integer.parseInt(val2);
					int xd = Integer.parseInt(val3);
					int yd = Integer.parseInt(val4);
					int d  = dropdown.getSelectedIndex() + 1;
					
					if(Controller.addHyperbola(x, y, xd, yd, d)){
						view.addHyperbola(x, y, xd, yd, d);
					}
				}
				else{
					displayError();
				}
				
			}
		}
	}
	
// EDIT OBJECT BUTTON LISTENERS
	
	private class editListener implements ActionListener {
		JPanel updatePanel;
		int    editType;
		
		public editListener(JPanel u, int e){
			updatePanel = u;
			editType    = e;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(view.getObjectCount() > 0){
				System.out.println("editListener: editType = " + editType);
				if(editing == 0 ){
					editing = editType;
					currentlyEditing = view.getSelectedObject();
					previousObject = view.getObject(currentlyEditing);
					updatePanel.removeAll();
					
					if(editType == MainView.EDIT_TRANSLATE){
						updatePanel.add(new translatePanel(updatePanel));
					}
					else if(editType == MainView.EDIT_ROTATE){
						updatePanel.add(new rotatePanel(updatePanel));
					}
					else if(editType == MainView.EDIT_SHEAR){
						updatePanel.add(new shearPanel(updatePanel));
					}
					else if(editType == MainView.EDIT_SCALE){
						updatePanel.add(new scalePanel(updatePanel));
					}
					else if(editType == MainView.EDIT_REFLECT){
						updatePanel.add(new reflectPanel(updatePanel));
					}
					else if(editType == MainView.EDIT_DELETE){
						if(Controller.deleteObject(currentlyEditing)){
							view.deleteObject(currentlyEditing);
							editing = 0;
						}
					}
					
					repaint();
					revalidate();
				}
			}
		}
	}
	
	
// CONFIRM EDIT LISTENERS
	
	private class confirmEditListener implements ActionListener {
		JPanel updatePanel;
		
		public confirmEditListener(JPanel u){
			updatePanel = u;
		}
		
		public void actionPerformed(ActionEvent e) {
			
			GraphicObject o = view.getObject(currentlyEditing);
			double[][] data = null;
			
			if(editing == MainView.EDIT_TRANSLATE){
				String val1 = field1.getText();
				String val2 = field1.getText();
				
				if(isValid(val1) && isValid(val2)){
					double x = Double.parseDouble(val1);
					double y = Double.parseDouble(val2);
					
					data = Controller.translateObject(currentlyEditing, x, y);
				}
			}
			
			else if(editing == MainView.EDIT_ROTATE){
				double d = 0;
				
				if(o instanceof PointDrawer
					|| o instanceof LineDrawer
					|| o instanceof PolygonDrawer){
					
					String val = field1.getText();
					
					if(isValid(val)){
						d = Double.parseDouble(val);
						data = Controller.rotateObject(currentlyEditing, d);
					}
				}
				
				else{
					int selected = dropdown.getSelectedIndex() + 1;
					
					if(selected == MainView.ROTATE_90){
						d = 90;
					}
					else if(selected == MainView.ROTATE_180){
						d = 180;
					}
					else{
						d = 270;
					}
					
					data = Controller.rotateObject(currentlyEditing, d);
				}
				
				
			}
			
			else if(editing == MainView.EDIT_SHEAR){
				double d = 0;
				
				if(o instanceof PointDrawer
					|| o instanceof LineDrawer
					|| o instanceof PolygonDrawer){
					String val = field1.getText();
					
					if(isValid(val)){
						d = Double.parseDouble(field1.getText());
						data = Controller.shearObject(currentlyEditing, d);
					}
				}
			}
			
			else if(editing == MainView.EDIT_SCALE){
				double d = 0;
				
				String val = field1.getText();
				
				if(isValid(val)){
					d = Double.parseDouble(field1.getText());
					data = Controller.scaleObject(currentlyEditing, d);
				}
			}
			
			else if(editing == MainView.EDIT_REFLECT){
				int type = dropdown.getSelectedIndex() + 1;
				
				data = Controller.reflectObject(currentlyEditing, type);
			}
			
			if(data != null){
				view.updateObject(previousObject, currentlyEditing, data);
				updatePanel.removeAll();
				updatePanel.add(new confirmPanel(updatePanel, data));
				
			}
			else{
				displayError();
			}
			editing = 0;
			repaint();
			revalidate();
		}
	}
	
// APPLY EDIT LISTENER
	
	private class applyEditListener implements ActionListener {
		JPanel updatePanel;
		
		public applyEditListener(JPanel u){
			updatePanel = u;
		}
		
		public void actionPerformed(ActionEvent e) {
			updatePanel.removeAll();
			view.applyEdit();
			editing = 0;
		}
	}
	
// CANCEL LISTENER
	
	private class cancelListener implements ActionListener {
		JPanel updatePanel;
		
		public cancelListener(JPanel u){
			updatePanel = u;
		}
		
		public void actionPerformed(ActionEvent e) {
			updatePanel.removeAll();
			editing = 0;
			repaint();
			revalidate();
		}
	}
}