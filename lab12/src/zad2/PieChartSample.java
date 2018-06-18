package zad2;

import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class PieChartSample extends Application {
 
	 ObservableList<PieChart.Data> pieChartData; 
	 BorderPane borderPane;
	 Random rand;
	 Button button;
	 Node buttonPanel;
	 private int applesNo;
	
	public void start(Stage stage) {
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(600);
        
        rand = new Random();
        applesNo = rand.nextInt(200);
        button = new Button("Set random no of apples");
       
        
        	pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", applesNo));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");        
        
        borderPane = new BorderPane();
        borderPane.setCenter(chart);
        borderPane.setBottom(button);
        
        button.setOnAction(new EventHandler <ActionEvent>() {
    		@Override
    		public void handle(ActionEvent e) {
    			applesNo = rand.nextInt(200);
    			System.out.println(applesNo);	
    			createChart(applesNo);
    		}
        });
        
        Scene scene = new Scene(borderPane, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
	
	public void createChart(int apples) {
		pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", apples));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Imported Fruits");
		borderPane.setCenter(chart);
	}
 
    public static void main(String[] args) {
        Application.launch(args);
    }
}