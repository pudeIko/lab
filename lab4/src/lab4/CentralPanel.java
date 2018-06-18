package lab4;

import javax.swing.*;

import lab4.MainFrame;
import lab4.RightPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CentralPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public static final int RADIUS = 150;
		static final double X0 = MainFrame.dimX * 0.77 - 300;
		static final double Y0 = MainFrame.dimY * 0.77 - 230;
		public static final int MAX_VERTICLES = 21;
		Graphics2D g2d;
		Color color;
		BasicStroke stroke;
		RightPanel rightpanel;
		BottomPanel bottompanel;
		Polygon poly;

		public CentralPanel(RightPanel rightPanel, BottomPanel bottompanel) {
			this.rightpanel = rightPanel;
			this.bottompanel = bottompanel;
			bottompanel.BG.addActionListener((ActionListener) this);
			bottompanel.LN.addActionListener((ActionListener) this);
			setPreferredSize(new Dimension(590, 460));
			color = Color.BLACK;
			stroke = new BasicStroke(1);
			setPolygon();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g2d = (Graphics2D) g;
			g2d.setColor(color);
			g2d.setStroke(stroke);
			g2d.drawPolygon(poly);
		}

		public void setPolygon() {
			int length = rightpanel.getxPosList().size();
			int[] xPos = new int[length];
			int[] yPos = new int[length];

			for (int i = 0; i < length; i++) {
				try {
					xPos[i] = Integer.parseInt(rightpanel.getxPosList().get(i).getText());
					yPos[i] = Integer.parseInt(rightpanel.getyPosList().get(i).getText());
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			poly = new Polygon(xPos, yPos, length);
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.bottompanel.BG) {
				Color color = JColorChooser.showDialog(null, "Change background color", Color.WHITE);
				this.setBackground(color);
				this.repaint();
			} else if (e.getSource() == this.bottompanel.LN) {
				Color color = JColorChooser.showDialog(null, "Change line color", Color.BLACK);
				this.color = color;
				this.g2d.setColor(color);
				this.repaint();
			}
		}
}