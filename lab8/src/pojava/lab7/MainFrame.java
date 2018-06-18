package pojava.lab7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDHT = 800;
	public static final int HEIGHT = 600;

	private MenuBar menubar;
	private TextPanel textpanel;
	
	public MainFrame() throws IOException  {
		super("DYKTANDO");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(WIDHT, HEIGHT));
		this.setMinimumSize(getPreferredSize());
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension size = getSize();
				Dimension min = getMinimumSize();
				if (size.getWidth() < min.getWidth()) {
					setSize((int) min.getWidth(), (int) size.getHeight());
				}
				if (size.getHeight() < min.getHeight()) {
					setSize((int) size.getWidth(), (int) min.getHeight());
				}
			}
		});
		this.setSize(WIDHT, HEIGHT);
		this.setLocationRelativeTo(null);

		menubar = new MenuBar();
		textpanel = new TextPanel();
		new MenuListener(menubar, textpanel);
		this.setJMenuBar(menubar);
		this.add(textpanel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainFrame().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}