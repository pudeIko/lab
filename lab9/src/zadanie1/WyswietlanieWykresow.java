package zadanie1;


import java.awt.*;
import java.awt.image.*;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class WyswietlanieWykresow   { 
  
	public static void main(String[] args)
    { 
  // definiowanie serii:
    XYSeries dataSet= new XYSeries("seria 1");
    XYSeries dataSet2= new XYSeries("seria 2");
    XYSeries dataSet3 = new XYSeries("seria 3");
 
		//"reczne" wypelnianie serii 1 - dodawanie kolejnych punktow 
        dataSet.add(0.1, 4.4); 
        dataSet.add(0.5, 12.4); 
        dataSet.add(0.9, 21.4); 
        dataSet.add(1.8, 43.2); 
        dataSet.add(2.8, 27.9); 
        dataSet.add(5.6, 3.3); 
        dataSet.add(8.8, 67.6); 
        dataSet.add(9.3, 18.2); 
        dataSet.add(14.0, 97.5); 
        dataSet.add(16.5, 79.5); 
        dataSet.add(18.4, 34.9); 
        dataSet.add(22.3, 11.1); 
        dataSet.add(23.5, 26.4); 
        dataSet.add(25.2, 1.0);
        //wypelnianie serii 2 i 3 w petli:
        for (double i=0; i <26; i+=0.05) dataSet2.add(i,i*Math.sin(i*3)+35);
        for (double i=0; i<26; i+=0.3) dataSet3.add(i,Math.tan(i)+45);
        // Tworzenie kolekcji serii zawierajacej serie dataSet
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection(dataSet); 
        // Dodanie kolejnych serii do kolekcji:
        xySeriesCollection.addSeries(dataSet2);
        xySeriesCollection.addSeries(dataSet3);        
        // tworzenie XYDataSet 
        XYDataset xyDataset = xySeriesCollection;      
        // tworzenie wykresu 
        JFreeChart lineGraph = ChartFactory.createXYLineChart 
                    ("Tytul wykresu",  // Title 
                      "Tytul osi X",           // X-Axis label 
                      "Tytul osi Y",           // Y-Axis label 
                      xyDataset,          // Dataset 
                      PlotOrientation.VERTICAL,        //Plot orientation 
                      true,                //show legend 
                      true,                // Show tooltips 
                      false               //url show 
                     ); 
        
        // szybkie wysswietlanie wykresu 
        // przy pomocy klasy ChartFrame
        ChartFrame frame = new ChartFrame("Szybkie wyswietlanie wykresu - klasa ChartFrame", lineGraph); 
        frame.pack(); 
        frame.setVisible(true); 

        // Zapisywanie wykresu do pliku JPG:
        try {
        ChartUtilities.saveChartAsJPEG(new File("LineGraph2.jpg"), lineGraph, 800, 600);
        } catch (Exception e) {
        System.out.println("Problem z zapisem wykresu do pliku");
        }
  
       // WYSWIETLANIE WYKRESOW W OKNIE SWING 
       // Tworzenie okienka Swing: 
        JFrame jframe = new JFrame("Przeskaluj okno oraz kliknij prawym klawiszem myszy na obu wykresach...");
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        jframe.getContentPane().setLayout(new GridLayout( 2,2));
        jframe.setSize(640,480);
       // Dodawanie wykresu jako obraz - klasa BufferedImage 
        BufferedImage image = lineGraph.createBufferedImage(300,200);
        JLabel lblChart = new JLabel();        
        lblChart.setIcon(new ImageIcon(image));
        jframe.getContentPane().add(lblChart);
        jframe.getContentPane().add(new JLabel("<<< wykres dodany jako obraz (Image)"));
       // Dodawanie wykresu przy pomocy klasy ChartPanel
        ChartPanel chartPanel = new ChartPanel(lineGraph);
        jframe.getContentPane().add(chartPanel);
        jframe.getContentPane().add(new JLabel("<<< wykres dodany jako ChartPanel"));
        
        jframe.setVisible(true);
        
    }
}
