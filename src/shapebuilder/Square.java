package shapebuilder;

import java.awt.Color;

public class Square extends Rectangle {

	public Square(int x, int y, int width, Color colour) {
		super(x, y, width, width, colour);
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
	
}
