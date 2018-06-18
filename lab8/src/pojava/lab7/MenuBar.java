package pojava.lab7;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu file;
	JMenu font;
	JMenu options;

	//JMenuItem newFile;
	JMenuItem openFile;
	JMenuItem saveFile;

	JMenuItem fontColor;
	JMenu fontSize;
	JMenu fontKind;
	
	JTextField setSize;
	
	JMenuItem fontNormal;
	JMenuItem fontItalic;
	JMenuItem fontBold;
	
	JMenuItem checkspellingitem;

	public MenuBar() {
		file = new JMenu("Plik");
		font = new JMenu("Czcionka");
		options = new JMenu("Opcje");
		checkspellingitem = new JMenuItem("Sprawdź pisownię");

		//newFile = new JMenuItem("Nowy");
		openFile = new JMenuItem("Otwórz");
		saveFile = new JMenuItem("Zapisz");

		fontColor = new JMenuItem("Kolor");
		fontKind = new JMenu("Rodzaj");
		fontSize = new JMenu("Rozmiar");
		
		setSize = new JTextField(20);
		setSize.setText("Ustaw wielkość teksu");
		fontSize.add(setSize);
		
		fontNormal = new JMenuItem("Normalna");
		fontItalic = new JMenuItem("Kusywa");
		fontBold = new JMenuItem("Pogrubiona");

		//file.add(newFile);
		file.add(openFile);
		file.add(saveFile);
		
		fontKind.add(fontNormal);
		fontKind.add(fontBold);
		fontKind.add(fontItalic);
		
		font.add(fontColor);
		font.add(fontSize);
		font.add(fontKind);
		options.add(checkspellingitem);

		this.add(file);
		this.add(font);
		this.add(options);
	}
}