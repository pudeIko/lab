package zad1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

		controlPanel.drawGraphButton.addActionListener(this);
		
		function = "Linear";
	}
		
	
	private static XYSeries createDataset() {
		XYSeries series = new XYSeries(function);
			series.add(3, 4);
			series.add(1, 2);
			series.add(2, 7);
			
		return series;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		while(draw) {
			g2d = (Graphics2D) g;
			JFreeChart chart = ChartFactory.createXYLineChart(function, "x", "y", dataset);
			chart.draw(g2d, new Rectangle(0, 0, 500, 500));
			draw = false;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == controlPanel.drawGraphButton) {
			removeAll();
			draw = true;

			//values = Linear(a, b);
			dataset = new XYSeriesCollection();
			dataset.addSeries(createDataset());
			repaint();
		}
	}
}
