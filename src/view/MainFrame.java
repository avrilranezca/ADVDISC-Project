package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;

public class MainFrame extends JFrame {

	private JPanel container;
	private JPanel editPanel;
	private JPanel optionsPanel;
	
	private MainView   view;
	
	public MainFrame(MainView v){
		view = v;
		
		this.setVisible(true);
		this.setTitle("Computer Graphics");
		this.setSize(new Dimension(925, 657));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		container = new JPanel();
		this.add(container);
		container.setLayout(null);
		
		editPanel = new EditPanel(view);
		optionsPanel = new OptionsPanel(view);
		container.add(editPanel);
		container.add(optionsPanel);
		
		editPanel.setBounds(5, 5, 625, 625);
		editPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		optionsPanel.setBounds(635, 5, 285, 625);
	}
	
	void refreshGrid(){
		System.out.println("MainFrame.refreshGrid()");
		container.remove(editPanel);
		editPanel = new EditPanel(view);
		container.add(editPanel);
		editPanel.setBounds(5, 5, 625, 625);
		editPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	}
}
