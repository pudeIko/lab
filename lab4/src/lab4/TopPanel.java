package lab4;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TopPanel extends JPanel implements ChangeListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel description;
	JSlider slider;
	JButton draw;
	private JLabel selected;
	public static final int slider_min = 3;
	public static final int slider_max = 21;
	public static int verticles;
	
	
	public TopPanel() {
		this.setLayout(new FlowLayout());
		description = new JLabel("No. of verticles");
		slider = new JSlider(JSlider.HORIZONTAL, slider_min, slider_max, slider_min);
		slider.setMajorTickSpacing((slider_max - slider_min) / 2);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		selected = new JLabel (String.format("Selected: %d", slider.getValue()));
		selected.setPreferredSize(new Dimension(80, 15));
		slider.addChangeListener(new SliderChangeListener());
		draw = new JButton("Draw");
		verticles = slider.getValue();

		Border border = BorderFactory.createDashedBorder(null);
		this.setBorder(border);
		
		this.add(description);
		this.add(slider);
		this.add(selected);
		this.add(draw);
		
	}
	public class SliderChangeListener implements ChangeListener
	{			
			@Override
			public void stateChanged(ChangeEvent arg0) 
			{
				String value = String.format("Selected: %d", slider.getValue());
				selected.setText(value);
			}
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
