package shapebuilder;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The template for all shape objects.
 * @author Andrew Hocking
 */
public abstract class Shape implements Comparable<Shape> {
	
	private int x;
	private int y;
	private int height;
	private int width;
	private Color colour;
	
	/**
	 * @return The surface area of the Shape.
	 */
	abstract public double getSurfaceArea();
	
	/**
	 * Draws the shape on the screen (but does not repaint its container).
	 * @param g
	 */
	abstract public void draw(Graphics g);
	
	// Getters and Setters
	
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
	
	/**
	 * Returns 1 if this Shape has a larger surface area than Shape s.
	 * Returns -1 if this Shape has a smaller surface area than Shape s.
	 * Returns 0 if they have the same surface area.
	 */
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
