package shapebuilder;

import java.awt.Color;
import java.util.Random;

/**
 * A factory class to produce Shape objects.
 * @author Andrew Hocking
 */
public class ShapeFactory {
	
	/**
	 * Creates a new Shape object with a random width, height, and colour.
	 * @param shapeType - The type of shape to be created.
	 * @param x - The x-coordinate of the shape.
	 * @param y - The y-coordinate of the shape.
	 * @param maxWidth - The maximum width the shape could potentially be.
	 * @param maxHeight - The maximum height the shape could potentially be.
	 * @return The new Shape object.
	 */
	public Shape generateShape(ShapeType shapeType, int x, int y, int maxWidth, int maxHeight) {
		
		Random random = new Random();
		
		int width;
		int height;
		Color colour = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		
		Shape shape;
		switch(shapeType) {
		case RECTANGLE:
			width = random.nextInt(maxWidth - ShapePanel.MIN_SHAPE_SIZE + 1) + ShapePanel.MIN_SHAPE_SIZE;
			height = random.nextInt(maxHeight - ShapePanel.MIN_SHAPE_SIZE + 1) + ShapePanel.MIN_SHAPE_SIZE;
			shape = new Rectangle(x, y, width, height, colour);
			break;
		case SQUARE:
			width = random.nextInt(Math.min(maxWidth, maxHeight) - ShapePanel.MIN_SHAPE_SIZE + 1) + ShapePanel.MIN_SHAPE_SIZE;
			shape = new Square(x, y, width, colour);
			break;
		case CIRCLE:
			width = random.nextInt(Math.min(maxWidth, maxHeight) - ShapePanel.MIN_SHAPE_SIZE + 1) + ShapePanel.MIN_SHAPE_SIZE;
			shape = new Circle(x, y, width, colour);
			break;
		default:
			shape = null;
			break;
		}
		
		return shape;
		
	}
	
}
