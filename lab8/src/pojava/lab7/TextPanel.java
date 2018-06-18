package pojava.lab7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class TextPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextPane textPane;
	List<String> text;
	String fileName = "dyktando-short.txt";
	private BufferedReader br;

	public TextPanel() throws IOException {
		this.setLayout(new BorderLayout());
		textPane = new JTextPane();
		try {
			text = readFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// przykładowy tekst
		
		readAndChangeText(textPane, fileName);
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, MenuListener.size));
		textPane.setBackground(Color.WHITE);
		this.add(textPane, BorderLayout.CENTER);
	}

	// load from file
	public List<String> readFile(String fileName) throws IOException {
		List<String> list = new ArrayList<>();
		InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), Charset.forName("UTF-8").newDecoder());
		br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st= new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
		}
		return list;
	}

	// to change words
	private List<String> formatList(List<String> src) {
		List<String> newList = new ArrayList<>();
		for (String s : src) {
			newList.add(formatString(s));
		}
		return newList;
	}

	private String formatString(String s) {
		return s.replaceAll("ch", "?").replaceAll("ó", "?").replaceAll("u", "?").replaceAll("ż", "?")
				.replaceAll("h", "?").replaceAll("rz", "?");
	}

	// loadFileAndFormat
	public void readAndChangeText(JTextPane textPane, String fileName) {
		List<String> list = new ArrayList<>();
		try {
			list = readFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		list = formatList(list);
		final String joined = list.stream().collect(Collectors.joining(" "));
		textPane.setText(joined);
	}

	public void changeColor(JTextPane tp, String msg, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
		String tmp = tp.getText();
		tp.setText("");
		tp.setCharacterAttributes(aset, false);
		tp.setCaretPosition(0);
		tp.replaceSelection(tmp);
	}

}