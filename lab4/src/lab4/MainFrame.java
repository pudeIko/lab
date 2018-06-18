package lab4;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TopPanel toppanel;
	private LeftPanel leftpanel;
	private CentralPanel centralpanel;
	private BottomPanel bottompanel;
	private RightPanel rightpanel;
	private Menu menu;
	public static final int dimX = 700;
	public static final int dimY = 600;
	private MenuListener menulistener;
	//private EverythingListener everythinglistener;
	
	public MainFrame() {
		super("Draw Polygon");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(dimX, dimY));
		this.setMinimumSize(getPreferredSize());
		toppanel = new TopPanel();
		bottompanel = new BottomPanel();
		leftpanel = new LeftPanel();
		rightpanel = new RightPanel(leftpanel);
		centralpanel = new CentralPanel(rightpanel, bottompanel);
		menu = new Menu(this, centralpanel);
		menulistener = new MenuListener(centralpanel, menu);
		new EverythingListener(toppanel, bottompanel, leftpanel, rightpanel, centralpanel);

		menu.line1px.addActionListener(menulistener);
		menu.line5px.addActionListener(menulistener);
		menu.line10px.addActionListener(menulistener);

		this.add(toppanel, BorderLayout.PAGE_START);
		this.add(bottompanel, BorderLayout.PAGE_END);
		this.add(leftpanel, BorderLayout.WEST);
		this.add(rightpanel, BorderLayout.EAST);
		this.add(centralpanel, BorderLayout.CENTER);
		this.setJMenuBar(menu);
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();		
		frame.setVisible(true);
	}
}
