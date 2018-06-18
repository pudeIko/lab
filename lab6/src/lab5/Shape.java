package lab5;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public abstract class Shape extends JPanel{
	
	protected List<Integer> xList; // x coordinates list
	protected List<Integer> yList; // y coordinate list
	int lineWidth;
	Color color;

	public Shape() {
		xList = new ArrayList<Integer>();
		yList = new ArrayList<Integer>();
		this.lineWidth = DrawingPanel.lineWidth;
		this.color = BottomPanel.lnColor;
	}

	public void setxy(int x,int y) {
		xList.add(x);
		yList.add(y);
	}

	abstract void draw(Graphics2D g2d);

}
