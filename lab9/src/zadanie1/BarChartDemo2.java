package zadanie1;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
 
public class BarChartDemo2 {
 
	public static void main(String arg[]){
		// Dane
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.setValue(6, "Seria1", "Kategoria1");
		dataset.setValue(7, "Seria1", "Kategoria2");
		dataset.setValue(8, "Seria1", "Kategoria3");
		dataset.setValue(5, "Seria1", "Kategoria4");
		dataset.setValue(12, "Seria1", "Kategoria5");
		
		dataset.setValue(4, "Seria2", "Kategoria1");
		dataset.setValue(6, "Seria2", "Kategoria2");
		dataset.setValue(2, "Seria2", "Kategoria3");
		dataset.setValue(4, "Seria2", "Kategoria4");
		dataset.setValue(10, "Seria2", "Kategoria5");
		
		// Tworzy wykres typu Bar - slupkowy
		JFreeChart chart = ChartFactory.createBarChart("Wykres typu Bar z dwoma seriami",
			"Opis osi X", "Opis osi Y", dataset, PlotOrientation.VERTICAL,
			true, true, false);
			//parametry podobnie jak w poprzednich przykladach
 
		ChartFrame frame1=new ChartFrame("Bar Chart",chart);
		frame1.setVisible(true);
		frame1.setSize(500,400);
	}
}

