package lab5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {
	
	static DrawingPanel drawingpanel;
	public ToolsPanel toolspanel;
	BottomPanel bottompanel;
	MenuBar menubar;
	public static final int dimX = 700;
	public static final int dimY = 600;
	

	public MainFrame() throws IOException {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.setMinimumSize(getPreferredSize());
		
		menubar = new MenuBar(this);
		bottompanel = new BottomPanel(this);
		drawingpanel = new DrawingPanel(this);
		
		this.add(drawingpanel,BorderLayout.CENTER);
		this.setJMenuBar(menubar);
		this.validate();
		this.repaint();
		toolspanel = new ToolsPanel(this);
		this.add(toolspanel,BorderLayout.WEST);
		this.add(bottompanel, BorderLayout.PAGE_END);

	}

	public static void main(String[] args) throws IOException {
		new MainFrame().setVisible(true);

	}

}