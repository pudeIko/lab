package lab4;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class RightPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel xPos;
	JLabel yPos;
	List<JTextField> xPosList;
	List<JTextField> yPosList;
	JPanel labelPanel;
	JPanel textPanel;
	LeftPanel leftpanel;

	public RightPanel(LeftPanel leftpanel) {
		this.leftpanel = leftpanel;
		init();
		calculate();
	}

	public void init() {
		xPos = new JLabel("X pos.");
		yPos = new JLabel("Y pos.");
		this.setLayout(new BorderLayout());
		labelPanel = new JPanel();
		textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(TopPanel.verticles, 2));
		xPosList = new ArrayList<>(TopPanel.verticles);
		yPosList = new ArrayList<>(TopPanel.verticles);
		labelPanel.add(xPos);
		labelPanel.add(yPos);
		this.add(labelPanel, BorderLayout.PAGE_START);
		this.add(textPanel, BorderLayout.CENTER);
	}

	public void calculate() {
		if (leftpanel.getMode() == LeftPanel.REGULAR) {
			for (int i = 0; i < TopPanel.verticles; i++) 
			{
				xPosList.add(i, new JTextField(
						(int) (CentralPanel.RADIUS * Math.cos((Math.PI / 2 + 2 * Math.PI * i) / TopPanel.verticles)+ CentralPanel.X0) + ""));
				yPosList.add(i, new JTextField(
						(int) (CentralPanel.RADIUS * Math.sin((Math.PI / 2 + 2 * Math.PI * i) / TopPanel.verticles)+ CentralPanel.Y0) + ""));
				textPanel.add(xPosList.get(i));
				textPanel.add(yPosList.get(i));
			}
		} else {
			for (int i = 0; i < TopPanel.verticles; i++) {
				Random r = new Random();
				xPosList.add(i, new JTextField((int) (r.nextInt(300) - 150 + CentralPanel.X0) + ""));
				yPosList.add(i, new JTextField((int) (r.nextInt(300) - 150 + CentralPanel.Y0) + ""));
				textPanel.add(xPosList.get(i));
				textPanel.add(yPosList.get(i));
			}
		}
	}

	public void changeVertices() {
		removeAll();
		xPosList.clear();
		yPosList.clear();
		init();
	}

	List<JTextField> getxPosList() {
		return xPosList;
	}

	List<JTextField> getyPosList() {
		return yPosList;
	}
}