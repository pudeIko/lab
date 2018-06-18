package lab3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MedianFrame extends JFrame implements ActionListener{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	private JTextField textField;
	private JButton add;
	private JButton median;
	private JLabel solution;
	private JLabel allNumbers;
	private JLabel warning;
	private double number;
	List<Double> numbers;

	public MedianFrame() 
	{
		setLocationRelativeTo(null);
		setSize(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		numbers = new ArrayList<>();
		mainPanel = new JPanel(new GridLayout(3, 1));
		topPanel = new JPanel(new FlowLayout());
		middlePanel = new JPanel(new FlowLayout());
		bottomPanel = new JPanel(new BorderLayout());
		textField = new JTextField(15);
		add = new JButton("Add number");
		median = new JButton("Median");
		solution = new JLabel("Solution");
		allNumbers = new JLabel("Set of numbers: ");
		warning = new JLabel("Wrong number format.");

		add.addActionListener(this);
		median.addActionListener(this);

		topPanel.add(textField);
		topPanel.add(add);
		topPanel.add(median);
		topPanel.add(solution);
		
		middlePanel.add(warning);
		middlePanel.setVisible(false);

		bottomPanel.add(allNumbers);

		mainPanel.add(topPanel);
		mainPanel.add(middlePanel);
		mainPanel.add(bottomPanel);
		this.add(mainPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			try {
				middlePanel.setVisible(false);
				number = Double.parseDouble(textField.getText());
				numbers.add(number);
				allNumbers.setText("Set of numbers: " + numbers.toString());
			}
			catch (NumberFormatException ex) {
				//System.out.println("Wrong number format.");
				middlePanel.setVisible(true);						
			}
		}
		if (e.getSource() == median) {
			double median = 0;
			int pos;
			int pos2;
			Collections.sort(numbers);
			allNumbers.setText("Set of numbers: " + numbers.toString());
			if (numbers.size() % 2 == 0) {
				pos = numbers.size()/2-1;
				pos2 = numbers.size()/2;
				median = (numbers.get(pos)+numbers.get(pos2))/2;
			} 
			else {
				pos = (numbers.size() / 2);
				median = numbers.get(pos);
			}
			solution.setText("= " + median);
		}
	}
	
	

	public static void main(String[] args) {
		new MedianFrame().setVisible(true);
	}



}