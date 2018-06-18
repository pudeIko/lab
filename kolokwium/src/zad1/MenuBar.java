package zad1;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MenuBar extends JMenuBar implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu options;
	JMenu animation;
	JMenu shape;
	JMenuItem save;
	JMenuItem open;
	JMenuItem changeColor;
	JMenuItem close;
	JMenuItem moveHorizontaly;
	JMenuItem stop;
	JMenuItem restart;
	JMenuItem rectangle;
	JMenuItem oval;
	JMenuItem line;
	
	MainFrame mainFrame;
	ShapePanel shapePanel;
	ControlPanel controlPanel;
	
	JFileChooser choose;
	private BufferedReader br;
	
	String selectedShape = "rectangle";

	public MenuBar(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		options = new JMenu("Options");
		animation = new JMenu("Animation tools");
		shape = new JMenu("Change shape");
		save = new JMenuItem("Save");
		open = new JMenuItem("Open");
		changeColor = new JMenuItem("Change Color");
		close = new JMenuItem("Exit");
		moveHorizontaly = new JMenuItem("Change shapes position");
		stop = new JMenuItem("Stop animation");
		restart = new JMenuItem("Restart animation");
		rectangle = new JMenuItem("Rectangle");
		oval = new JMenuItem("Oval");
		line = new JMenuItem("Filled rectangle");
		
		close.addActionListener(this);
		save.addActionListener(this);
		changeColor.addActionListener(this);
		open.addActionListener(this);
		moveHorizontaly.addActionListener(this);
		stop.addActionListener(this);
		restart.addActionListener(this);
		rectangle.addActionListener(this);
		oval.addActionListener(this);
		line.addActionListener(this);
		

		options.add(save);
		options.add(open);
		options.add(changeColor);
		options.add(close);
		
		animation.add(moveHorizontaly);
		animation.add(stop);
		animation.add(restart);
		
		shape.add(rectangle);
		shape.add(oval);
		shape.add(line);
		
		this.add(options);
		this.add(animation);
		this.add(shape);
		
	}
	
	// menuBar listener
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(close)) {
			System.exit(0);
		}
		if (o.equals(changeColor)) {
			Color shapeColor = JColorChooser.showDialog(null, "Change shape color", Color.WHITE);
			MainFrame.shapePanel.color = shapeColor;
			MainFrame.shapePanel.removeAll();
			MainFrame.shapePanel.repaint();
		}
		if (o.equals(save)) {
			BufferedImage img = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			MainFrame.shapePanel.paintComponent(g);

			choose = new JFileChooser();
			int wynik = choose.showDialog(null, "Choose");
			choose.setDialogTitle("choose");
			if (wynik == JFileChooser.APPROVE_OPTION) {
				try {
					ImageIO.write(img, "png", choose.getSelectedFile());
					System.out.println("Saved");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.print("SAVING FAILED!");
				}

			}
		}
		if (o.equals(open)) {
			final JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			fc.setFileFilter(filter);
			int returnVal = fc.showDialog(null, "Open");
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					this.readFile(fc.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (o.equals(moveHorizontaly)) {
			MainFrame.shapePanel.move();
		}
		if (o.equals(stop)) {
			MainFrame.shapePanel.animate = false;			
		}
		if (o.equals(restart)) {
			MainFrame.shapePanel.animate = true;
			MainFrame.shapePanel.move();
		}
		if (o.equals(rectangle)) {
			selectedShape = "rectangle";
			MainFrame.shapePanel.repaint();
		}
		if (o.equals(oval)) {
			selectedShape = "oval";
			MainFrame.shapePanel.repaint();
		}
		if (o.equals(line)) {
			selectedShape = "line";
			MainFrame.shapePanel.repaint();
		}
	}
	
	// coordinates reading function
	public void readFile(String fileName) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), Charset.forName("UTF-8").newDecoder());
		br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				MainFrame.controlPanel.setX1.setText(st.nextToken());
				MainFrame.controlPanel.setY1.setText(st.nextToken());
				MainFrame.controlPanel.setX2.setText(st.nextToken());
				MainFrame.controlPanel.setY2.setText(st.nextToken());
				MainFrame.controlPanel.setX3.setText(st.nextToken());
				MainFrame.controlPanel.setY3.setText(st.nextToken());
			}
		}
	}
}
