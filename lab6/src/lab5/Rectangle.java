package lab5;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Rectangle extends Shape {
	
	MainFrame mainframe;
	
	public Rectangle(MainFrame mainframe) {
		this.mainframe = mainframe;
	}
	

	@Override
	void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.drawRect(Math.min(xList.get(1), xList.get(0)), Math.min(yList.get(1), yList.get(0)),
				Math.abs(xList.get(1) - xList.get(0)), Math.abs(yList.get(1) - yList.get(0)));
		// TODO Auto-generated method stub

	}

}
