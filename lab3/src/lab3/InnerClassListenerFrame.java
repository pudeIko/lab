package lab3;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class InnerClassListenerFrame extends JFrame 
{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Pola klasy InnerClassListenerFrame
	static final int SLIDER_MIN = -100;
	static final int SLIDER_MAX = 100;
	static final int SLIDER_INIT = -50;
	
	    JSlider slider;
	    JLabel label;
	
	    // Konstruktor klasy InnerClassListenerFrame
	public InnerClassListenerFrame() throws HeadlessException {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600,500);
		
		slider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
		this.add(slider, BorderLayout.PAGE_START);
		
		label = new JLabel(String.format("%d", slider.getValue()));
		this.add(label);
		
		slider.addChangeListener(new SliderChangeListener());
	}
	
	    // Klasa wewnętrzna SliderChangeListener implementująca ChangeListener
	public class SliderChangeListener implements ChangeListener
	{
		
		@Override
		public void stateChanged(ChangeEvent arg0) {
			String value = String.format("%d", slider.getValue());
			label.setText(value);
		}
		
	}
	
	public static void main(String[] args) {
		InnerClassListenerFrame frame = new InnerClassListenerFrame();
		frame.setVisible(true);
	}

}