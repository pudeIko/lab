package zadanie1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
//import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
 
public class XYLineChartDemo2 {
	public static void main(String arg[]){
		//Dane do wykresu 3d
		XYSeries series = new XYSeries("Nazwa serii 1");
		
		series.add(1, 1);
		series.add(1, 2);
		series.add(2, 4);
		series.add(3, 4);
		series.add(4, 2);
		series.add(5, 9);
		series.add(6, 10);
		
		XYSeries series2 = new XYSeries("Nazwa serii 2");
		series2.add(1,0);
		series2.add(4, 5);
		series2.add(5, 5.5);
		series2.add(5.5, -1);
		series2.add(6, 8);
		
		//Tworzenie kolekcji serii
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		//dodawanie kolejnych serii do kolekcji
		dataset.addSeries(series);
		dataset.addSeries(series2);
		
		// oczywiscie serie mozna usuwac:
		//dataset.removeSeries(series2); // stosujac nazwe serii
		//dataset.removeSeries(0); // stosujac numer serii
		//dataset.removeAllSeries(); // lub usunac wszystkie serie;
		
		//Tworzymy wykres XY
		JFreeChart chart = ChartFactory.createXYLineChart(
			"Wykres XY z dwoma seriami danych",//Tytul
			"Opis osi X", // opisy osi
			"Opis osi Y", 
			dataset, // Dane 
			PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
			true, // legenda
			true, // tooltips
			false
		);

		//Dodanie wykresu do okna
		ChartFrame frame1=new ChartFrame("XYLine Chart",chart);
		frame1.setVisible(true);
		frame1.setSize(500,400);
	}
}

