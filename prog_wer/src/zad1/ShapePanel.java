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

	int x = 100;
	int y = 100;
	int h = 100;
	int w = 100;
	int v = 5;
	
	boolean animate = true;
	
	public ShapePanel(ControlPanel controlPanel, MenuBar menuBar) {
		
		this.controlPanel = controlPanel;
		this.menuBar = menuBar;
		this.setBackground(Color.WHITE);
		controlPanel.drawButton.addActionListener((ActionListener) this);
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
			g2d.drawRect(x, y, w, h);
		}
		if (menuBar.selectedShape == "oval") {
			g2d.drawOval(x, y, w, h);
		}
		if (menuBar.selectedShape == "line") {
			g2d.drawLine(x, y, w, h);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == controlPanel.drawButton) {
			if(controlPanel.mode == 1) {
				Random rand = new Random();
				x = rand.nextInt(500);
				y = rand.nextInt(500);
			}
			if(controlPanel.mode == 2) {
				x = Integer.parseInt(controlPanel.setX.getText());
				y = Integer.parseInt(controlPanel.setY.getText());
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
	
	public void move() {
		new Thread(() ->  {
			while (animate) {
				if (menuBar.animationMode == "horizontal") {
					x = x + v;
					w = w + v;
					h = h + v;
					if (x < 0.1 * this.getWidth() || x + w > 0.9 * this.getWidth()) {
						v = -v;
					}
				}
				if (menuBar.animationMode == "vertical") {
					y = y + v;
					w = w + v;
					h = h + v;
					if (y < 0.1 * this.getHeight() || y + h > 0.9 * this.getHeight()) {
						v = -v;
					}
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
