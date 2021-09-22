package shapebuilder;

import java.awt.Color;

public class Square extends Rectangle {

	public Square(int x, int y, int width, Color colour) {
		super(x, y, width, width, colour);
	}

	@Override
	public void setHeight(int length) {
		super.setHeight(length);
		super.setWidth(length);
	}

	@Override
	public void setWidth(int width) {
		this.setHeight(width);
	}
	
}
