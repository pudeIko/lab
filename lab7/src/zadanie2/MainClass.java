package zadanie2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 600;
	public static int height = 600;
	static PanelRysowania panel;
	
	
	public MainClass() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainClass.panel = new PanelRysowania();

		panel.dodajProstokat(100, 100, 100, 100, Color.GREEN);
		panel.dodajProstokat(100, 100, 100, 100, Color.GREEN);

		for (int i = 1; i < 20; i++) {
			panel.dodajLosowyProstokat();
		}

		new Thread(panel).start();

		this.add(panel);
		this.setSize(width, height);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MainClass frame = new MainClass();
			frame.setVisible(true);
		});

	}

}