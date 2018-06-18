package zadanie1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class FiveFunctionsChart extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static final int WIDHT = 500;
	public static final int HEIGHT = 100;
	
	List<Double> values;
	JPanel options;
	private Random r = new Random();
	String function;
	
	JButton sinus;
	JButton cosinus;
	JButton sqrt;
	JButton exponent;
	JButton linear;
	
	public FiveFunctionsChart() {
		super("Five Functions");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(WIDHT, HEIGHT));
		this.setMinimumSize(getPreferredSize());
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension size = getSize();
				Dimension min = getMinimumSize();
				if (size.getWidth() < min.getWidth()) {
					setSize((int) min.getWidth(), (int) size.getHeight());
				}
				if (size.getHeight() < min.getHeight()) {
					setSize((int) size.getWidth(), (int) min.getHeight());
				}
			}
		});
		this.setSize(WIDHT, HEIGHT);
		this.setLocationRelativeTo(null);
		
		options = new JPanel();
		options.setLayout(new FlowLayout());
		
		sinus = new JButton("Sinus");
		cosinus = new JButton("Cosinus");
		sqrt = new JButton("Square root");
		exponent = new JButton("Exponent");
		linear = new JButton("Linear");
		
		sinus.addActionListener(this);
		cosinus.addActionListener(this);
		sqrt.addActionListener(this);
		exponent.addActionListener(this);
		linear.addActionListener(this);
		
		options.add(sinus);
		options.add(cosinus);
		options.add(sqrt);
		options.add(exponent);
		options.add(linear);
		
		this.add(options);
	}	
		
	private XYSeries createDataset() {
		XYSeries series = new XYSeries(function);
		for (int i = 0; i < values.size(); i++) {
			series.add(i, values.get(i));
		}
		return series;
	}
	
	private List<Double> Sinus(double step) {
		List<Double> tmp = new ArrayList<>();
		for (double i = 0; i < 10; i+=step) {
			tmp.add(Math.sin(i));
		}
		return tmp;
	}
	
	private List<Double> Cosinus(double step) {
		List<Double> tmp = new ArrayList<>();
		for (double i = 0; i < 10; i+=step) {
			tmp.add(Math.cos(i));
		}
		return tmp;
	}
	
	private List<Double> SquareRoot(double step) {
		List<Double> tmp = new ArrayList<>();
		for (double i = 0; i < 10; i+=step) {
			tmp.add(Math.sqrt(i));
		}
		return tmp;
	}
	
	private List<Double> Exponent(double step) {
		List<Double> tmp = new ArrayList<>();
		for (double i = 0; i < 10; i+=step) {
			tmp.add(Math.exp(i));
		}
		return tmp;
	}
	
	private List<Double> Linear(double step) {
		List<Double> tmp = new ArrayList<>();
		float a = r.nextFloat();
		float b= r.nextFloat();
		for (double i = 0; i < 10; i+=step) {
			tmp.add(a*i+b);
		}
		return tmp;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(sinus)) {
			values = Sinus(0.1);
			function = "Sinus";
		}
		if (o.equals(cosinus)) {
			values = Cosinus(0.1);
			function = "Cosinus";
		}
		if (o.equals(sqrt)) {
			values = SquareRoot(0.1);
			function = "Square root";
		}
		if (o.equals(exponent)) {
			values = Exponent(0.1);
			function = "Exponent";
		}
		if (o.equals(linear)) {
			values = Linear(0.1);
			function = "Linear";
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(createDataset());
		JFreeChart chart = ChartFactory.createXYLineChart(function, "x", "y", dataset);
		ChartFrame frame = new ChartFrame("Graph of the function", chart);
		frame.setPreferredSize(new Dimension(600, 400));
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new FiveFunctionsChart().setVisible(true);
			}
		});
	}
}
