package zadanie1;


import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
 
public class TimeSeriesChartDemo2 {
 
	public static void main(String arg[]){
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		
		TimeSeries seria1 = new TimeSeries("Nazwa serii");
		seria1.add(new Day(1, 1, 2013), 200);
		seria1.add(new Day(2, 1, 2013), 250);
		seria1.add(new Day(3, 1, 2013), 250);
		seria1.add(new Day(4, 1, 2013), 275);
		seria1.add(new Day(5, 1, 2013), 225);
		
		
		TimeSeries seria2 = new TimeSeries("Nazwa serii2");
		seria2.add(new Year(2012), 200);
		seria2.add(new Year(2013), 250);
		seria2.add(new Year(2014), 150);
		seria2.add(new Year(2015), 300);
		seria2.add(new Year(2016), 100);
		
		
		dataset.addSeries(seria1);
		dataset.addSeries(seria2);
		//Wykres typu TimeSeries
		JFreeChart chart = ChartFactory.createTimeSeriesChart
			("Wykres","Data","Etykieta osi Y",dataset,true,true,false);
		
		
		//Wymuszanie okreslonego formatowania daty na osi:
		XYPlot plot = chart.getXYPlot();
		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("dd-MM-yyyy"));
	
		ChartFrame frame1=new ChartFrame("TimeSeries Chart",chart);
		frame1.setVisible(true);
		frame1.setSize(400,300);
	}
}
