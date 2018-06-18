package lab3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MultiListenerFrame extends JFrame implements ChangeListener, KeyListener, ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int slider_min = 0;
	static final int slider_max = 55;
	static final int slider_start = 10;
	JSlider slider;
	JLabel label2;
	JPanel panel1 = new JPanel(); JPanel panel2 = new JPanel(); JPanel panel3 = new JPanel();
	JButton button;
	int napis = 1;
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	JRadioButton radioButton3;
	static final String[] COLOR_NAMES = {"red", "green", "blue"};
	static final Color[] COLORS = {Color.red, Color.green, Color.blue};
	static final Color INIT_COLOR = COLORS[0];
	
	
	public MultiListenerFrame() throws HeadlessException 
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600,300);
		this.setLayout(new GridLayout(4, 1));
		
		this.add(panel1); this.add(panel2); this.add(panel3);
		
		slider = new JSlider(JSlider.HORIZONTAL, slider_min, slider_max, slider_start);
		panel3.add(slider);
		
		label2 = new JLabel (String.format("%d", slider.getValue()));
		label2.setFont(new Font(label2.getName(), Font.ITALIC, 25));
		panel2.add(label2);
		slider.addChangeListener(new SliderChangeListener());
		Paint paint = null;
		Border border1 = BorderFactory.createDashedBorder(paint);
		Border border2 = BorderFactory.createLineBorder(null);
		Border border3 = BorderFactory.createTitledBorder("Slider");
		panel3.setBorder(border3); panel2.setBorder(border2); panel2.setBorder(border1);
		button = new JButton("Close");
		ActionListener pressListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);						
			}		
		};
		button.addActionListener(pressListener);
		panel1.add(button);
		
		String[] colors = {"red", "green", "blue"};
		JComboBox<String> colorList = new JComboBox<String>(colors);
		//colorlist.addItemListener(new OuterClassListenerFrame;)
		colorList.addItemListener(new ComboBoxItemListener((JPanel)this.getContentPane()));
		panel1.add(colorList, BorderLayout.PAGE_START);
        this.getContentPane().setBackground(Color.red);
        
        radioButton1 = new JRadioButton(COLOR_NAMES[0]);
		radioButton1.setActionCommand("0");
		radioButton1.setBackground(INIT_COLOR);
		radioButton1.addActionListener(this);
		radioButton1.setSelected(true);
		panel2.add(radioButton1);
		
		radioButton2 = new JRadioButton(COLOR_NAMES[1]);
		radioButton2.setActionCommand("1");
		radioButton2.setBackground(INIT_COLOR);
		radioButton2.addActionListener(this);
		panel2.add(radioButton2);
		
		radioButton3 = new JRadioButton(COLOR_NAMES[2]);
		radioButton3.setActionCommand("2");
		radioButton3.setBackground(INIT_COLOR);
		radioButton3.addActionListener(this);
		panel2.add(radioButton3);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
	}
	
	/*@Override
	public void actionPerformed(ActionEvent arg0) {
		Color newColor;
		int colorNumber = Integer.parseInt(arg0.getActionCommand());
		this.getContentPane().setBackground(COLORS[colorNumber]);
		radioButton1.setBackground(COLORS[colorNumber]);
		radioButton2.setBackground(COLORS[colorNumber]);
		radioButton3.setBackground(COLORS[colorNumber]);
	}*/
	
	public class SliderChangeListener implements ChangeListener
	{			
			@Override
			public void stateChanged(ChangeEvent arg0) 
			{
				String value = String.format("%d", slider.getValue());
				label2.setText(value);
			}
	}
	
	

	public static void main(String[] args) {
		MultiListenerFrame frame = new MultiListenerFrame();
		frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
