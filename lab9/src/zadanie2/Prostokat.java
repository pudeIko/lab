package zadanie2;

import java.awt.Color;
import java.awt.Graphics;

public class Prostokat{

    private int xPos = 50;
	private int yPos = 50;
    private int width = 20;
    private int height = 20;
    private Color color = Color.BLACK;
    
    Prostokat(int x, int y, int w, int h, Color c){
    	xPos = x;
    	yPos = y;
    	width = w;
    	height = h;
    	color = c;
    }
    
    public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }

    public int getWidth(){
        return width;
    } 

    public int getHeight(){
        return height;
    }


	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

    public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void paint(Graphics g){
        g.setColor(getColor());
        g.fillRect(xPos,yPos,getWidth(),getHeight());
    }

}
