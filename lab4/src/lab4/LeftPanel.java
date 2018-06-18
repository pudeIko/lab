package lab4;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class LeftPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mode;
	public static final String REGULAR = "Regular";
	public static final String RANDOM = "Random";
	JRadioButton regular;
	JRadioButton random;

	public LeftPanel() {
		this.mode = REGULAR;
		regular = new JRadioButton("Regular");
		random = new JRadioButton("Random");
		random.setActionCommand(RANDOM);
		regular.setSelected(true);
		regular.setActionCommand(REGULAR);
		ButtonGroup group = new ButtonGroup();
		this.setLayout(new GridLayout(2, 1));
		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Polygon");
		group.add(regular);
		group.add(random);
		this.add(regular);
		this.add(random);
		this.setBorder(border);
	}

	public String getMode() {
		return mode;
	}
}