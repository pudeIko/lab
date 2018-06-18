package lab4;

import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EverythingListener implements ChangeListener, ActionListener {

	TopPanel toppanel;
	BottomPanel bottompanel;
	LeftPanel leftpanel;
	RightPanel rightpanel;
	CentralPanel centralpanel;
	int counterRandom = 0;
	int counterRegular = 0;

	public EverythingListener(TopPanel toppanel, BottomPanel bottompanel, LeftPanel leftpanel, RightPanel rightpanel,
			CentralPanel centralpanel) {
		this.toppanel = toppanel;
		this.bottompanel = bottompanel;
		this.leftpanel = leftpanel;
		this.rightpanel = rightpanel;
		this.centralpanel = centralpanel;
		toppanel.slider.addChangeListener(this);
		toppanel.draw.addActionListener(this);
		leftpanel.random.addActionListener(this);
		leftpanel.regular.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == leftpanel.random) 
		{
			leftpanel.mode = LeftPanel.RANDOM;
			counterRandom++;
		} 
		else if (e.getSource() == leftpanel.regular) 
		{
			leftpanel.mode = LeftPanel.REGULAR;
			counterRegular++;
		} 
		else if (e.getSource() == toppanel.draw) 
		{
			if (TopPanel.verticles == toppanel.slider.getValue() && leftpanel.regular.isSelected()) {
				if (counterRandom > 0) {
					drawMoreVertices();
					counterRandom = 0;
				} 
				else if (counterRegular > 0) {
					centralpanel.setPolygon();
					centralpanel.repaint();
					counterRegular = 0;
				} 
				else {
					drawMoreVertices();
					counterRegular = 0;
				}
			} 
			else {
				drawMoreVertices();
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		TopPanel.verticles = toppanel.slider.getValue();
		rightpanel.changeVertices();
		rightpanel.calculate();
		centralpanel.setPolygon();
		centralpanel.repaint();
	}

	public void drawMoreVertices() {
		int length = rightpanel.getxPosList().size();
		int[] xPos = new int[length];
		int[] yPos = new int[length];
		rightpanel.changeVertices();
		rightpanel.calculate();
		for (int i = 0; i < length; i++) {
			xPos[i] = Integer.parseInt(rightpanel.getxPosList().get(i).getText());
			yPos[i] = Integer.parseInt(rightpanel.getyPosList().get(i).getText());
		}
		centralpanel.poly = new Polygon(xPos, yPos, length);
		centralpanel.repaint();
	}

}