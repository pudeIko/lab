package kolokwium2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraphPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	int a;
	int b;
	

	Color color;
	BasicStroke stroke;
	private static final long serialVersionUID = 1L;
	ControlPanel controlPanel;
	static String function;
	static List<Double> values;
	XYSeriesCollection dataset;
	

	boolean draw = false;

	private Graphics2D g2d;
	
	public GraphPanel(ControlPanel controlPanel) {
		this.controlPanel = controlPanel;
		this.setBackground(Color.WHITE);
		
		function = "Linear";

		controlPanel.generate.addActionListener(this);
		
		function = "Linear";
		
		}
		
	
	
	private static XYSeries createDataset() {
		XYSeries series = new XYSeries(function);
		for (int i = 0; i < values.size(); i++) {
			series.add(i, values.get(i));
		}
		return series;
	}
	
	private static List<Double> Linear(double a, double b) {
		List<Double> tmp = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			tmp.add(a * i + b);
		}
		return tmp;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		while(draw) {
			g2d = (Graphics2D) g;
			JFreeChart chart = ChartFactory.createXYLineChart(function, "x", "y", dataset);
			chart.draw(g2d, new Rectangle(0, 0, 700, 500));
			draw = false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == controlPanel.generate) {
			removeAll();
			draw = true;
			a = Integer.parseInt(controlPanel.setA.getText());
			b = Integer.parseInt(controlPanel.setB.getText());
			values = Linear(a, b);
			dataset = new XYSeriesCollection();
			dataset.addSeries(createDataset());
			repaint();
		}
	}
}
