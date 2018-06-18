package zadanie1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

public class ColorChangingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Random r = new Random();
	private int red;
	private int green;
	private int blue;
	
	public ColorChangingPanel() {
		this.setBackground(Color.BLUE);
		this.setPreferredSize(new Dimension(200, 200));
		new Thread(() -> {
			while (true) {
				Toolkit.getDefaultToolkit().sync();
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					red = r.nextInt(255);
					green = r.nextInt(255);
					blue = r.nextInt(255);
					
					setBackground(new Color(red, green, blue));
					repaint();
			}

		}).start();

	}
}