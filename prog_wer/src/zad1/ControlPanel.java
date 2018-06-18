package zad1;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ControlPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int mode;
	//String mode;
	public static final String RANDOM = "Regular";
	public static final String SETXY = "SETXY";
	public static final int dimX = 100;
	public static final int dimY = 600;
	JRadioButton setXY;
	JRadioButton random;
	JTextField setX;
	JTextField setY;
	JButton drawButton;
	ShapePanel shapePanel;
	
	public ControlPanel(ShapePanel shapePanel) {

		this.mode = 1;
		this.setLayout(new GridLayout(5,1));
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.setMinimumSize(getPreferredSize());
		this.shapePanel = shapePanel;
		setXY = new JRadioButton("Set XY");
		random = new JRadioButton("Random");
		random.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(random);
		group.add(setXY);
		drawButton = new JButton("DRAW!");
		random.addActionListener(this);
		setXY.addActionListener(this);
		
		setX = new JTextField("set X");
		setY = new JTextField("set Y");
		
		this.add(random);
		this.add(setXY);
		this.add(setX);
		this.add(setY);
		this.add(drawButton);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == random) 
		{
			this.mode = 1;
		} 
		else if (e.getSource() == setXY) 
		{
			this.mode = 2;
		}
	}
	
	public int getMode() {
		return mode;
	}
}
