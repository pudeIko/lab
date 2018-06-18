package zadanie1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import zadanie1.ChangingRadioButtons;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int MY_WIDTH = 500;
	private static final int MY_HEIGHT = 500;

	private CustomButton customButton;
	private ColorChangingPanel colorChangingPanel;
	private ChangingRadioButtons changingButton;
	//private ChangingSlider changingSlider;
	JLabel label;
	JSlider slider;
	JButton button;
	int size = 50;

	public MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(MY_WIDTH, MY_HEIGHT));
		this.setMinimumSize(getPreferredSize());
		
		this.setLocationRelativeTo(null);
		customButton = new CustomButton();
		colorChangingPanel = new ColorChangingPanel();
		changingButton = new ChangingRadioButtons();
		//changingSlider = new ChangingSlider();
		//this.add(changingSlider, BorderLayout.CENTER);
		this.add(customButton, BorderLayout.PAGE_END);
		this.add(colorChangingPanel, BorderLayout.WEST);
		this.add(changingButton, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new MainFrame().setVisible(true);
		});
	}
}