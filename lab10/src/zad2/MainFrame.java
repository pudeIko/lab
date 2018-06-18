package zad2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	JTextField textField = new JTextField("Insert USD value");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	ExecutorService executorService = Executors.newCachedThreadPool();
	JMenuBar menubar;
	JMenuItem perform;

	public MainFrame() {
		super("USD exchange rate");
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
		perform.addActionListener(e -> {
			executorService.submit(this);
		});
		pack();
		setLocationRelativeTo(null);
	}

	private void getDataset(double rate, JTextArea textArea) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net/kursy_walut", "wojpud", "wojpudpwjava")) {

			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM waluty WHERE USD < ?");
			preparedStatement.setDouble(1, rate);

			ResultSet rs = preparedStatement.executeQuery();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			double rate = Double.parseDouble(textField.getText());
			getDataset(rate, textArea);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Input must be a number", "Invalid input", JOptionPane.INFORMATION_MESSAGE);
			textArea.setText(" ");
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new MainFrame().setVisible(true);
		});
	}
}