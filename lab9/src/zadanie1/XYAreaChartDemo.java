package zadanie1;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
 
public class XYAreaChartDemo {
	public static void main(String arg[]){
		//Dane do wykresu 3d
		XYSeries series = new XYSeries("Nazwa serii");
		series.add(1, 1);
		series.add(1, 2);
		series.add(2, 4);
		series.add(3, 4);
		series.add(4, 2);
		series.add(5, 9);
		series.add(6, 10);
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		//Tworzymy wykres XY
		JFreeChart chart = ChartFactory.createXYAreaChart(
			"Wykres Area XY",//Tytul
			"Opis osi X", // opisy osi
			"Opis osi Y", 
			dataset, // Dane 
			PlotOrientation.VERTICAL, // Orjentacja wykresu /HORIZONTAL
			true, // legenda
			true, // tooltips
			false
		);
 
		//Dodanie wykresu do okna
		ChartFrame frame1=new ChartFrame("XYLArea Chart",chart);
		frame1.setVisible(true);
		frame1.setSize(500,400);
	}
}

