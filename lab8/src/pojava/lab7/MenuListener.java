package pojava.lab7;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuListener implements ActionListener {

	MenuBar menuBar;
	TextPanel textpanel;
	static int size = 20;
	int currentFontStyle = Font.PLAIN;

	public MenuListener(MenuBar menuBar, TextPanel textpanel) {
		this.menuBar = menuBar;
		this.textpanel = textpanel;
		this.menuBar.openFile.addActionListener(this);
		this.menuBar.saveFile.addActionListener(this);
		this.menuBar.checkspellingitem.addActionListener(this);
		this.menuBar.fontColor.addActionListener(this);
		this.menuBar.fontKind.addActionListener(this);
		this.menuBar.fontBold.addActionListener(this);
		this.menuBar.fontItalic.addActionListener(this);
		this.menuBar.fontNormal.addActionListener(this);
		this.menuBar.setSize.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	int size = Integer.parseInt(menuBar.setSize.getText());
	            	textpanel.textPane.setFont(new Font("Times New Roman", size, size));	            	
	            }
	        }
	    });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(menuBar.openFile)) {
			try {
				openFile(textpanel.textPane);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(menuBar.saveFile)) {
			saveToFile(textpanel.textPane);
		}
		if (o.equals(menuBar.fontColor)) {
			Color color = JColorChooser.showDialog(null, "Zmień kolor czcionki", Color.BLACK);
			textpanel.changeColor(textpanel.textPane, "Dziala ?", color);
		}
		if (o.equals(menuBar.checkspellingitem)) {
			String[] tab = textpanel.textPane.getText().split(" ");
			List<String> incorrect = new ArrayList<>();
			boolean isCorrect = true;
			for (int i = 0; i < tab.length; i++) {
				if (!tab[i].equals(textpanel.text.get(i))) {
					isCorrect = false;
					incorrect.add(tab[i]);
				}
			}
			if (isCorrect) {
				JOptionPane.showMessageDialog(null, "Brak błędów!", "Gotowe", JOptionPane.INFORMATION_MESSAGE);
			}
			JOptionPane.showMessageDialog(null, incorrect, "Do poprawy!", JOptionPane.INFORMATION_MESSAGE);
		}
		if (o.equals(menuBar.fontBold)) {
			currentFontStyle = Font.BOLD;
			textpanel.textPane.setFont(new Font("Times New Roman", currentFontStyle, size));
		}
		if (o.equals(menuBar.fontItalic)) {
			currentFontStyle = Font.ITALIC;
			textpanel.textPane.setFont(new Font("Times New Roman", currentFontStyle, size));
		}
		if (o.equals(menuBar.fontNormal)) {
			currentFontStyle = Font.PLAIN;
			textpanel.textPane.setFont(new Font("Times New Roman", currentFontStyle, size));
		}
	}

	private void saveToFile(JTextPane textPane) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showDialog(null, "Save");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try (FileWriter fw = new FileWriter(fc.getSelectedFile() + ".txt")) {
				fw.write(textPane.getText());
				fw.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void openFile(JTextPane textPane) throws IOException {
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fc.setFileFilter(filter);
		int returnVal = fc.showDialog(null, "Open");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				textpanel.text = textpanel.readFile(fc.getSelectedFile().getAbsolutePath());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			textpanel.readAndChangeText(textpanel.textPane, fc.getSelectedFile().getAbsolutePath());
		}
	}

}