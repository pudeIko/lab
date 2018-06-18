package zad1;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class ShapePanel extends JPanel implements ChangeListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color color;
	ControlPanel controlPanel;
	Graphics2D g2d;
	BasicStroke stroke;
	MenuBar menuBar;
	Random r;

	int x1 = 100;
	int y1 = 100;
	int h = 100;
	int w = 100;
	int v = 5;
	
	int x2 = 200;
	int y2 = 200;
	int x3 = 300;
	int y3 = 300;
	
	boolean animate = true;
	
	public ShapePanel(ControlPanel controlPanel, MenuBar menuBar) {
		
		this.controlPanel = controlPanel;
		this.menuBar = menuBar;
		this.setBackground(Color.WHITE);
		controlPanel.drawShapesButton.addActionListener((ActionListener) this);
		menuBar.changeColor.addActionListener(this);
		setPreferredSize(new Dimension(600, 600));
		this.setMinimumSize(getPreferredSize());
		color = Color.BLACK;
		stroke = new BasicStroke(5);		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.setStroke(stroke);
			if (menuBar.selectedShape == "rectangle") {
				g2d.drawRect(x1, y1, w, h);
				g2d.drawRect(x2, y3, w, h);
				g2d.drawRect(x3, y3, w, h);
			}
			if (menuBar.selectedShape == "oval") {
				g2d.drawOval(x1, y1, w, h);
				g2d.drawOval(x2, y2, w, h);
				g2d.drawOval(x3, y3, w, h);
			}
			if (menuBar.selectedShape == "line") {
				g2d.fillRect(x3, y3, w, h);
				g2d.fillRect(x2, y2, w, h);
				g2d.fillRect(x1, y1, w, h);
			}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == controlPanel.drawShapesButton) {
			Random r = new Random();
			color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			g2d.setColor(color);
			if(controlPanel.mode == 1) {
				Random rand = new Random();
				x1 = rand.nextInt(this.getWidth() - w);
				y1 = rand.nextInt(this.getHeight() - h);
				x2 = rand.nextInt(this.getWidth() - w);
				y2 = rand.nextInt(this.getHeight() - h);
				x3 = rand.nextInt(this.getWidth() - w);
				y3 = rand.nextInt(this.getHeight() - h);
			}
			if(controlPanel.mode == 2) {
				x1 = Integer.parseInt(controlPanel.setX1.getText());
				y1 = Integer.parseInt(controlPanel.setY1.getText());
				x2 = Integer.parseInt(controlPanel.setX2.getText());
				y2 = Integer.parseInt(controlPanel.setY2.getText());
				x3 = Integer.parseInt(controlPanel.setX3.getText());
				y3 = Integer.parseInt(controlPanel.setY3.getText());
				this.repaint();
			}
			removeAll();
			this.repaint();
		} 
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		this.removeAll();
		this.repaint();
	}
	
	// animation thread
	public void move() {
		new Thread(() ->  {
			while (animate) {
				x1 = x1 + v;
				x2 = x2 + v;
				x3 = x3 + v;
				if (x1 < 0.1 * this.getWidth() || x1 + w > 0.9 * this.getWidth()
						|| x2 < 0.1 * this.getWidth() || x2 + w > 0.9 * this.getWidth() || x3 < 0.1 * this.getWidth() || x3 + w > 0.9 * this.getWidth()) {
					v = -v;
				}
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
				Toolkit.getDefaultToolkit().sync();
			}
		}).start();
	}
}
