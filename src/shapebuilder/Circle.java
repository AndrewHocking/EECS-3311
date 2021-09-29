package shapebuilder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape {

	public Circle(int x, int y, int width, Color colour) {
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(width);
		this.setColour(colour);
	}

	@Override
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}
	
	@Override
	public void setHeight(int height) {
		this.setWidth(height);
	}
	
	@Override
	public double getSurfaceArea() {
		return Math.PI * (Math.pow((getWidth() / 2.0), 2));
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.getColour());
		g2d.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

}
