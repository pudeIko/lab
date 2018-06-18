package zadanie1;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class ChangingRadioButtons extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int size = 0;
	List<JRadioButton> buttons;
	JRadioButton button1;
	JRadioButton button2;

	public ChangingRadioButtons() {
		this.setLayout(new GridLayout(20, 1));
		buttons = new ArrayList<>();
		button1 = new JRadioButton("1");
		button2 = new JRadioButton("2");			
		
		new Thread(() -> {
			while (true) {
				Toolkit.getDefaultToolkit().sync();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					buttons.add(size, new JRadioButton(""+ (size+1)));
					this.add(buttons.get(size));
					size++;
			}

		}).start();
	}
}


