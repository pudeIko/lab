package lab5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuBar extends JMenuBar implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	Color bgColor;
	public static Color lnColor;
	public static int size = 3;
	MainFrame mainframe;
	DrawingPanel drawingpanel;
	BottomPanel bottompanel;

	JMenuBar menubar;

	JMenu file;
	JMenuItem newFile;
	JMenuItem open;
	JMenuItem save;
	
	JMenu help;
	JMenuItem about;
	JFileChooser choose;

	public MenuBar (MainFrame mainframe) {
		this.mainframe = mainframe;
		menubar = new JMenuBar();

		file = new JMenu("File");
		newFile = new JMenuItem("New");
		open = new JMenuItem("Open file...");
		save = new JMenuItem("Save image");

		file.add(newFile);
		file.add(open);
		file.add(save);
		this.add(file);
		newFile.addActionListener(this);

		open.addActionListener(this);

		help = new JMenu("Help");
		about = new JMenuItem("About");
		about.addActionListener(this);
		help.add(about);
		this.add(help);
		save.addActionListener(this);
		//mainframe.addWindowListener(exitListener);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		// TODO Auto-generated method stub

		if (ob == save) {

			BufferedImage img = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			mainframe.drawingpanel.paintComponent(g);

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

		if (ob == open) {
			openFile();
		}

		if (ob == newFile)

		{
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to save?", "Exit?", JOptionPane.YES_NO_OPTION);
			if (choice == 1) {
				resetColor(drawingpanel);
				repaint();

			}

			else {

				BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics g = img.createGraphics();
				paintComponent(g);
				choose = new JFileChooser();
				int wynik = choose.showDialog(null, "Choose");
				choose.setDialogTitle("Choose");
				if (wynik == JFileChooser.APPROVE_OPTION) {
					try {
						ImageIO.write(img, "png", choose.getSelectedFile());
						System.out.println("Picture saved.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.print("SAVING FAILED!");
					}

				}
				resetColor(drawingpanel);
				repaint();

			}

		}
		if (ob == about) {
			JOptionPane.showMessageDialog(null, "It's a paint dude, what do you want me to explain?");
		}
	}

	public Color getBgColor() {
		return bgColor;
	}

	public Color getLnColor() {
		return lnColor;
	}

	public static void resetColor(DrawingPanel drawingPanel) {
		DrawingPanel.shapes.clear();
		DrawingPanel.shape = null;
		MainFrame.drawingpanel.image = null;
		MainFrame.drawingpanel.repaint();
	}

	public void openFile() {
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Graphic files", "jpg", "jpeg", "gif", "png");
		fc.addChoosableFileFilter(filter);
		int returnVal = fc.showDialog(null, "Open");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			BufferedImage image = null;
			try {
				image = ImageIO.read(fc.getSelectedFile());
				System.out.println("works");
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
			MainFrame.drawingpanel.setBackgroudImage(image);
		}
	}

}