package lab5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ToolsPanel extends JPanel implements ActionListener {
	
	JButton rubber;
	JButton pencil;
	JButton line;
	JButton circle;
	JButton rectangle;
	MainFrame mainframe;
	public static int variable = 1;

	public ToolsPanel (MainFrame mainframe) throws IOException {
		this.mainframe = mainframe;

		this.setLayout(new GridLayout(6, 1));

		rubber = new JButton("rubber");
		pencil = new JButton("pencil");
		line = new JButton("line");
		circle = new JButton("circle");
		rectangle = new JButton("rectangle");
		pencil.addActionListener(this);
		line.addActionListener(this);
		circle.addActionListener(this);
		rectangle.addActionListener(this);
		rubber.addActionListener(this);

		this.add(pencil);
		this.add(line);
		this.add(circle);
		this.add(rectangle);
		this.add(rubber);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == pencil) {
			variable = 1;

		}
		if (ob == line) {
			variable = 2;

		}
		if (ob == rubber) {
			variable = 3;

		}
		if (ob == rectangle) {
			variable = 4;

		}
		if (ob == circle) {
			variable = 5;

		}

		// TODO Auto-generated method stub

	}

}
