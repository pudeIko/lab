package pojava.lab2;

import javax.swing.*;
import java.awt.*;
import java.lang.String;

//import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

@SuppressWarnings("serial")
public class ThreeShapesPanel extends JPanel
{
    public ThreeShapesPanel() throws HeadlessException {
        this.setSize(640, 480);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.red);
	    g.fillRect(10, 10, 20, 20);
	    
	    g.setColor(Color.green);
	    g.fillRoundRect(100, 50, 70, 60, 25, 25);
			
		g.setColor(Color.white);
	 	g.fillOval(110, 250, 150, 150);
    }

    public static void main(String[] args)
    {
        CloseableFrame frame = new CloseableFrame();
        frame.setLayout(new GridLayout(1,2));
        //JLabel nazwa = new JLabel("Okno");
        //frame.add(nazwa);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4,1));
        panel1.setBackground(Color.white);
        frame.add(panel1);

        JButton przycisk1 = new JButton();
        JButton przycisk2 = new JButton();
        JButton przycisk3 = new JButton();
        JButton przycisk4 = new JButton();

        panel1.add(przycisk1);
        panel1.add(przycisk2);
        panel1.add(przycisk3);
        panel1.add(przycisk4);

        JLabel label1 = new JLabel("Przycisk 1");
        JLabel label2 = new JLabel("Przycisk 2");
        JLabel label3 = new JLabel("Przycisk 3");
        JLabel label4 = new JLabel("Przycisk 4");

        przycisk1.add(label1);
        przycisk2.add(label2);
        przycisk3.add(label3);
        przycisk4.add(label4);

        ThreeShapesPanel panel2 = new ThreeShapesPanel();
        panel2.setBackground(Color.blue);
        frame.add(panel2);

        frame.setVisible(true);
    }

}
