package zadanie1;


//import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.DateAxis;
//import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
 
public class TimeSeriesChartDemo {
 
	public static void main(String arg[]){
		
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		
		TimeSeries seria1 = new TimeSeries("Nazwa serii");
		seria1.add(new Day(1, 1, 2013), 200);
		seria1.add(new Day(2, 1, 2013), 250);
		seria1.add(new Day(3, 1, 2013), 250);
		seria1.add(new Day(4, 1, 2013), 275);
		seria1.add(new Day(5, 1, 2013), 225);
		
		dataset.addSeries(seria1);
		//Wykres typu TimeSeries
		JFreeChart chart = ChartFactory.createTimeSeriesChart
			("Wykres","Data","Etykieta osi Y",dataset,true,true,false);

		ChartFrame frame1=new ChartFrame("TimeSeries Chart",chart);
		frame1.setVisible(true);
		frame1.setSize(400,300);
	}
}
