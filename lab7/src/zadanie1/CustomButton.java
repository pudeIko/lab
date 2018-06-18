package zadanie1;

import javax.swing.JButton;

public class CustomButton extends JButton implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static long START_TIME;
	private static long FINAL_TIME = 20000;
	public static boolean isTime = true;
	int counter = 20;
	Thread thread;

	public CustomButton() {
		this.setText("Hello");
		thread = new Thread(this);
		thread.start();
		this.setEnabled(false);
	}

	@Override
	public void run() {
		START_TIME = System.currentTimeMillis();
		while (isTime) {
			if (System.currentTimeMillis() - START_TIME > FINAL_TIME) {
				isTime = false;
				System.exit(0);
			}
			try {
				Thread.sleep(1000);
				this.setText("Countdown: " + counter);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			counter = counter - 1;
		}
	}

}