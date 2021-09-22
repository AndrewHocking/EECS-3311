package shapebuilder;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable<Shape> {
	
	public static final int MIN_WIDTH = 10;
	public static final int MAX_WIDTH = 90;
	public static final int MIN_HEIGHT = 10;
	public static final int MAX_HEIGHT = 90;
	
	private int x;
	private int y;
	private int height;
	private int width;
	private Color colour;
	
	abstract public double getSurfaceArea();
	abstract public void draw(Graphics g);
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}


	public Color getColour() {
		return colour;
	}
	public void setColour(Color colour) {
		this.colour = colour;
	}
	
	public int compareTo(Shape s) {
		double difference = this.getSurfaceArea() - s.getSurfaceArea();
		if (difference < 0) {
			return -1;
		} else if (difference > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
