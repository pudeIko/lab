package lab4;

import java.awt.*;
import javax.swing.*;

public class BottomPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton BG;
	JButton LN;
	JColorChooser bgChooser;
	JColorChooser lnChooser;
		
	public BottomPanel() {
		BG = new JButton("BG COLOR");
		LN = new JButton("LN COLOR");
		bgChooser = new JColorChooser();
		lnChooser = new JColorChooser();
		this.setLayout(new FlowLayout());	
		this.add(BG);
		this.add(LN);
	}
}
