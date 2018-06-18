package lab4;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu changeLineSize;
	JMenuItem line1px;
	JMenuItem line5px;
	JMenuItem line10px;

	public Menu(MainFrame mainframe, CentralPanel centralpanel) {
		changeLineSize = new JMenu("Line width");
		line1px = new JMenuItem("1 px");
		line5px = new JMenuItem("5 px");
		line10px = new JMenuItem("10 px");
		changeLineSize.add(line1px);
		changeLineSize.add(line5px);
		changeLineSize.add(line10px);

		this.add(changeLineSize);
	}
}