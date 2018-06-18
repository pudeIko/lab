package zadanie1;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ChangingSlider extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int value = 50;
	public JSlider slider;

	public ChangingSlider() {
		this.setLayout(new BorderLayout());
		slider = new JSlider(JSlider.VERTICAL, value, 0, value);
		/*new Thread(() -> {
			while (true) {
				Toolkit.getDefaultToolkit().sync();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					slider.setValue(value);
					value++;
					this.add(slider, BorderLayout.CENTER);
			}

		}).start();*/
		this.add(slider);
		
	}
}


