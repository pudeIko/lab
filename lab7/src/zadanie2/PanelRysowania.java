package zadanie2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class PanelRysowania extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	List<Prostokat> prostakaty = new ArrayList<>();
	BufferedImage[] bufferedImage;
	File file = new File("1.png");
	BufferedImage image;

	public PanelRysowania() {
		this.setBackground(Color.WHITE);
		
		//image-rectangular reading and displaying
		bufferedImage = new BufferedImage[7];
		int k = 86;
		try {
			image = ImageIO.read(file);
			for (int i = 0; i < 7; i++) {
					bufferedImage[i] = cutImage(file, k * i, k, k, k);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(() -> {
			while (true) {
				for (int i = 0; i < 7; i++) {
						image = bufferedImage[i];
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						revalidate();
				}
			}
		}).start();

	}
	
	//image croping function
	private BufferedImage cutImage(File filePath, int x, int y, int w, int h) {
		try {
			BufferedImage originalImgage = ImageIO.read(filePath);
			BufferedImage subImgage = originalImgage.getSubimage(x, y, w, h);
			return subImgage;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void dodajLosowyProstokat() {
		Random r = new Random();
		Prostokat p = new Prostokat();
		p.setX(r.nextInt(550));
		p.setY(r.nextInt(550));
		p.setWidth(r.nextInt(80));
		p.setHeight(r.nextInt(80));
		p.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		prostakaty.add(p);
	}

	public void dodajProstokat(int x, int y, int width, int height, Color c) {
		Prostokat p = new Prostokat();
		p.setX(x);
		p.setY(y);
		p.setWidth(width);
		p.setHeight(height);
		p.setColor(c);
		prostakaty.add(p);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		for (Prostokat pr : prostakaty) {
			pr.paint(g2d);
		}
		if (image != null)
			g2d.drawImage(image, prostakaty.get(0).getX(), prostakaty.get(0).getY(), prostakaty.get(0).getWidth(),
					prostakaty.get(0).getHeight(), null);
		g2d.dispose();
	}

	public Dimension getPreferredSize() {
		return image == null ? new Dimension(200, 200) : new Dimension(image.getWidth(), image.getHeight());
	}

	//"moving" function
	@Override
	public void run() {
		while (true) {

			for (int i = 0; i < prostakaty.size(); i++) {
				prostakaty.get(i).setX(prostakaty.get(i).getX() + prostakaty.get(i).getxV());
				prostakaty.get(i).setY(prostakaty.get(i).getY() + prostakaty.get(i).getyV());
				// sprawdzenie scianek + zmieniac znak predkosci !
				if (prostakaty.get(i).getX() < 0
						|| prostakaty.get(i).getX() + prostakaty.get(i).getWidth() > MainClass.width) {
					prostakaty.get(i).setxV(-prostakaty.get(i).getxV());
				}
				if (prostakaty.get(i).getY() < 0
						|| prostakaty.get(i).getY() + prostakaty.get(i).getHeight() > MainClass.height) {
					prostakaty.get(i).setyV(-prostakaty.get(i).getyV());
				}
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
			Toolkit.getDefaultToolkit().sync();
		}

	}

}