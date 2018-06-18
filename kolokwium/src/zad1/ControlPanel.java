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
	JTextField setX1;
	JTextField setY1;
	JTextField setX2;
	JTextField setY2;
	JTextField setX3;
	JTextField setY3;
	JButton drawShapesButton;
	JButton drawGraphButton;
	ShapePanel shapePanel;
	
	public ControlPanel(ShapePanel shapePanel) {

		this.mode = 1;
		this.setLayout(new GridLayout(10,1));
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.setMinimumSize(getPreferredSize());
		this.shapePanel = shapePanel;
		setXY = new JRadioButton("Set XY");
		random = new JRadioButton("Random");
		random.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(random);
		group.add(setXY);
		drawShapesButton = new JButton("Draw shapes!");
		drawGraphButton = new JButton("Draw graph!");
		random.addActionListener(this);
		setXY.addActionListener(this);
		
		setX1 = new JTextField("set X1");
		setY1 = new JTextField("set Y1");
		setX2 = new JTextField("set X2");
		setY2 = new JTextField("set Y2");
		setX3 = new JTextField("set X3");
		setY3 = new JTextField("set Y3");
		
		this.add(random);
		this.add(setXY);
		this.add(setX1);
		this.add(setY1);
		this.add(setX2);
		this.add(setY2);
		this.add(setX3);
		this.add(setY3);
		this.add(drawShapesButton);	
		this.add(drawGraphButton);
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
