package zad1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;


public class MainFrame extends JFrame implements ActionListener {

	JTextField textField = new JTextField(
			"SELECT Id, data, USD, EUR FROM waluty where usd > eur");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	JMenuBar menubar;
	JMenuItem perform;

	public MainFrame() {
		setPreferredSize(new Dimension(800, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		scrollPane.setSize(1000, 1000);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(textField, BorderLayout.PAGE_START);
		panel.add(scrollPane, BorderLayout.CENTER);
		menubar = new JMenuBar();
		perform = new JMenuItem("Perform query");
		menubar.add(perform);
		this.setJMenuBar(menubar);
		textArea.setEditable(false);
		this.add(panel);
		perform.addActionListener(this);
		pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(perform)) {
				try (Connection conn = DriverManager.getConnection("jdbc:h2:./data/nazwabazy", "sa", "")) {
					Statement statement = conn.createStatement();
					String text = textField.getText();
					statement.execute(text);
					ResultSet rs = statement.getResultSet();
					ResultSetMetaData md = rs.getMetaData();
					StringBuilder x = new StringBuilder();
					int column = md.getColumnCount();
					while (rs.next()) {
						for (int i = 1; i <= column; i++) {
							if (i > 1) {
								x.append(",  ");
							}
							String columnValue = rs.getString(i);
							x.append(columnValue + " " + md.getColumnName(i));
						}
						x.append('\n');
					}
					textArea.setText(x.toString());
				} 
				catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

}