package pojava.lab2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class ThreeButtonsFrame extends JFrame implements ActionListener
{
	private Random r = new Random();
	private int red = r.nextInt(255);
	private int green = r.nextInt(255);
	private int blue = r.nextInt(255);
	int napis = 1;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JPanel panel;
	static String Nazwa = "Nazwa okna";
	
	public ThreeButtonsFrame() 
	{
		super(Nazwa);
		setLayout(new GridLayout(1,1));
		setSize(new Dimension(500, 400));
	
		panel = new JPanel();
	
		button1 = new JButton("Zamknij");
		button2 = new JButton("Zmien kolor");
		button3 = new JButton("Wcisnij przycisk");
		
		ActionListener exitListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);						
			}	
		};
		ActionListener colorListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				red = r.nextInt(255);
				green = r.nextInt(255);
				blue = r.nextInt(255);
				panel.setBackground(new Color(red, green, blue));
			}	
		};
		ActionListener pressListener = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if (napis == 1)
				{
					button3.setText("Przycisk wcisnieto 1 raz");
					napis++;
				}
				else 
				{
				button3.setText("Przycisk wcisnieto " + napis + " razy");
				napis++;	
				}
			}	
		};
	
		button1.addActionListener(exitListener);
		button2.addActionListener(colorListener);
		button3.addActionListener(pressListener);
		setBackground(Color.BLACK);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.setBackground(Color.green);
		this.add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) 
	{
		ThreeButtonsFrame frame = new ThreeButtonsFrame();
		frame.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
