package zadanie1;



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
 
public class PieChartDemo3D {
	public static void main(String arg[]){
		
	DefaultPieDataset dane = new DefaultPieDataset();
	
	dane.setValue("Nazwa 1", 10); //wartosci
	dane.setValue("Nazwa 2", 25);
	dane.setValue("Nazwa 3", 80);
	dane.setValue("Nazwa 4", 45);
	dane.setValue("Nazwa 5", 45);
 
	
	//Tworzymy wykres JFreeChart typu PieChart3D - podobnie jak PieChart
		JFreeChart chart = ChartFactory.createPieChart3D
		("Wykres typu Pie 3D", // Tytul wykresu
		dane, // dane typu PieDataset 
		true, // legenda
		true, // tooltips
		false // Configure chart to generate URLs?
	);
 
		
	PiePlot plot = (PiePlot) chart.getPlot();
	plot.setForegroundAlpha(0.7f); // dodawanie przezroczystosci
		
	ChartFrame frame=new ChartFrame("Pie Chart3D",chart);
	frame.setVisible(true);
	frame.setSize(400,400);
	
}
}


