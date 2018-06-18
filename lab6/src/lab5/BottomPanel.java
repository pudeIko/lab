package lab5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BottomPanel extends JPanel implements ActionListener{

	static DrawingPanel drawingpanel;
	Shape shape;
	MainFrame mainframe;
	JButton BGcolor;
	JButton LNcolor;
	JLabel changeWidth;
	JTextField setWidth;
	JLabel selected;
	Color bgColor;
	public static Color lnColor;
	private int width;
	
		
	public BottomPanel(MainFrame mainframe) {
		this.setLayout(new FlowLayout());
		this.drawingpanel = drawingpanel;
		this.mainframe = mainframe;
		this.shape = shape;
		bgColor = Color.WHITE;
		BGcolor = new JButton("Change background color");
		LNcolor = new JButton("Change line color");
		changeWidth = new JLabel("Set line width");
		setWidth = new JTextField(3);
		setWidth.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	DrawingPanel.lineWidth = Integer.parseInt(setWidth.getText());
	            //shape.stroke = new BasicStroke(width);
	            drawingpanel.repaint();
	            }
	        }
	    });
		
		BGcolor.addActionListener(this);
		LNcolor.addActionListener(this);
		
		this.add(BGcolor);
		this.add(LNcolor);
		this.add(changeWidth);
		this.add(setWidth);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.BGcolor) {
			Color recievedColor = JColorChooser.showDialog(null, "Choose background color", bgColor);
			if (recievedColor != null) {
				bgColor = recievedColor;
				MainFrame.drawingpanel.setBackground(mainframe.bottompanel.getBgColor());
			}
		}
		if (e.getSource() == this.LNcolor) {
			Color recievedColor = JColorChooser.showDialog(null, "Choose line color", lnColor);
			if (recievedColor != null) {
				lnColor = recievedColor;
				mainframe.drawingpanel.repaint();
			}
		}
	}
	
	public Color getBgColor() {
		return bgColor;
	}

	public Color getLnColor() {
		return lnColor;
	}
	
}
