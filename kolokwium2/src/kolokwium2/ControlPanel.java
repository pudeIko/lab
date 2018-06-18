package kolokwium2;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ControlPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JTextField setA;
	JTextField setB;
	Dimension dim;
	JButton generate;

	public ControlPanel() {
		this.setLayout(new FlowLayout());
		dim = new Dimension(170, 20);
		
		generate = new JButton("Generate Chart");
		generate.setPreferredSize(dim);
		
		setA = new JTextField("Set slope value");
		setA.setPreferredSize(dim);
		setA.setMaximumSize(dim);
		setA.setMinimumSize(dim);
		setB = new JTextField("Set constant value");
		setB.setPreferredSize(dim);
		
		this.add(setA);
		this.add(setB);
		this.add(generate);
	}	
}
