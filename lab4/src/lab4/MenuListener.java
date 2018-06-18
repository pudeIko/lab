package lab4;

import java.awt.BasicStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener{

	CentralPanel centralpanel;
	Menu menu;

	public MenuListener(CentralPanel centralpanel, Menu menu) {
		this.centralpanel = centralpanel;
		this.menu = menu;
	}
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu.line1px) {
			centralpanel.stroke = new BasicStroke(1);
		} 
		else if (e.getSource() == menu.line5px) {
			centralpanel.stroke = new BasicStroke(5);
		} 
		else if (e.getSource() == menu.line10px) {
			centralpanel.stroke = new BasicStroke(10);
		}
		centralpanel.g2d.setStroke(centralpanel.stroke);
		centralpanel.repaint();
		}
}