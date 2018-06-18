package lab5;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Line extends Shape{
	
	MainFrame mainframe;
	
	public Line (MainFrame mainframe) {
		
		this.mainframe = mainframe;
	}
	

	@Override
	void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(lineWidth));
		
			g2d.drawLine(xList.get(0), yList.get(0), xList.get(1), yList.get(1));
		
	}

}
