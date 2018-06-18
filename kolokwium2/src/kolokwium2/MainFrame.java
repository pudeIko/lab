package kolokwium2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int dimX = 700;
	public static final int dimY = 600;
	static ControlPanel controlPanel;
	static GraphPanel graphPanel;
	

	public MainFrame() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.setMinimumSize(getPreferredSize());
		
		controlPanel = new ControlPanel();
		graphPanel = new GraphPanel(controlPanel);
		
		this.add(controlPanel, BorderLayout.PAGE_END);
		this.add(graphPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}
}
