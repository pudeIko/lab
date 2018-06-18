package lab5;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Rubber extends Shape {
	
	MainFrame mainframe;

	public Rubber (MainFrame mainframe) {
		this.mainframe = mainframe;
	}

	@Override

	void draw(Graphics2D g2d) {
		for (int i = 0; i < xList.size() - 1; ++i) {
			g2d.setColor(mainframe.bottompanel.getBgColor());
			g2d.setStroke(new BasicStroke(lineWidth));
			g2d.drawLine(xList.get(i), yList.get(i), xList.get(i + 1), yList.get(i + 1));
		}
	}

}
