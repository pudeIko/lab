package zadanie2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.statistics.StatisticalCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.orsonpdf.DefaultFontMapper;
import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.PDFObject;
import com.orsonpdf.Page;
import com.orsonpdf.util.GraphicsUtils;
import com.orsonpdf.util.TextAnchor;
import com.orsonpdf.util.TextUtils;

import zadanie1.FiveFunctionsChart;

/**
 * A demo/test for a pie chart.
 */
public class ThreePagesDoc2 {
    
	static List<Double> values;
	static String function;
	static List<String> valuesList;
	static BufferedImage image;
	static File file = new File("1.png");
			
	ThreePagesDoc2() throws IOException{
		
		values = Linear(0.5);
		function = "Linear";
		
		valuesList = new ArrayList<>();
		for (int i = 0; i < values.size(); i++) {
			String tmp = Double.toString(values.get(i));
			valuesList.add(tmp);
		}
			
	}

	private static XYSeries createDataset() {
		XYSeries series = new XYSeries(function);
		for (int i = 0; i < values.size(); i++) {
			series.add(i, values.get(i));
		}
		return series;
	}
	
	private static List<Double> Linear(double step) {
		List<Double> tmp = new ArrayList<>();
		float a = 2;
		float b = 3;
		for (double i = 0; i < 10; i+=step) {
			tmp.add(a*i+b);
		}
		return tmp;
	}
		
	private static void table(Graphics2D g2d, List<String> list) {
		g2d.setColor(Color.black);
		int number = 40;
		g2d.drawString("Arguments", 20, 20);
		g2d.drawString("Values", 150, 20);
		for (int i = 0; i < values.size(); i++) {
			float argument = (float) (0.5 * i);
			String tmp = Float.toString(argument);
			g2d.drawString(tmp, 20, 40+i*20);
			g2d.drawString(list.get(i), 150, 40+i*20);
		}
	}

	
    public static void main(String[] args) throws IOException {
    		
    		ThreePagesDoc2 tpd2 = new ThreePagesDoc2();
    		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(createDataset());
		JFreeChart chart = ChartFactory.createXYLineChart(function, "x", "y", dataset);
        PDFDocument pdfDoc = new PDFDocument();
        pdfDoc.setTitle("Three Pages Document");
        pdfDoc.setAuthor("Wojciech Pudelko");
        
        Page page1 = pdfDoc.createPage(new Rectangle(612, 468));
        Page page2 = pdfDoc.createPage(new Rectangle(0, 0, 612, 468));
        Page page3 = pdfDoc.createPage(new Rectangle(0, 0, 612, 468));
        
        PDFGraphics2D g1 = page1.getGraphics2D();
        PDFGraphics2D g2 = page2.getGraphics2D();
        PDFGraphics2D g3 = page3.getGraphics2D();
        
        chart.draw(g1, new Rectangle(0, 0, 612, 468));
        
        table(g2, valuesList);
        
        	g3.setColor(Color.RED);
    		image = ImageIO.read(file);
        	g3.drawImage(image, 100, 100, 426, 256, null);
        g3.drawOval(350, 200, 50, 100);
		g3.drawLine(20, 20, 48, 65);
		g3.drawLine(10, 50, 600, 400);
		
		File f = new File("Three Pages Document.pdf");
        pdfDoc.writeToFile(f);
    }
}