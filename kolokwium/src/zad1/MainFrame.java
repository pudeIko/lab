package zad1;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int dimX = 1200;
	public static final int dimY = 700;
	static ControlPanel controlPanel;
	private MenuBar menu;
	static ShapePanel shapePanel;
	JPanel graphicPanel;
	static GraphPanel graphPanel;
	

	public MainFrame() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.setMinimumSize(getPreferredSize());
		
		controlPanel = new ControlPanel(shapePanel);
		menu = new MenuBar(this);
		shapePanel = new ShapePanel(controlPanel, menu);
		graphPanel = new GraphPanel(controlPanel);
		graphicPanel = new JPanel(new GridLayout(1, 2));
		
		
		this.add(controlPanel, BorderLayout.WEST);
		graphicPanel.add(shapePanel, BorderLayout.CENTER);
		graphicPanel.add(graphPanel);
		this.add(graphicPanel, BorderLayout.CENTER);
		this.setJMenuBar(menu);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}
}
