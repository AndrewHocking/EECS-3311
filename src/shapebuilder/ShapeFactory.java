package shapebuilder;

import java.awt.Color;
import java.util.Random;

public class ShapeFactory {
	
	public static final int DEFAULT_NUMBER_OF_SHAPES = 6;
	public static final int SPACING = 10;
	
	private enum ShapeType {
		RECTANGLE,
		CIRCLE,
		SQUARE;
	}
	
	public static void generateShapes(ShapePanel shapePanel) {
		generateShapes(shapePanel, DEFAULT_NUMBER_OF_SHAPES);
	}
	
	public static void generateShapes(ShapePanel shapePanel, int numberOfShapes) {
		if (numberOfShapes <= 0) {
			throw new IllegalArgumentException("Number of shapes must be a positive integer");
		}
		
		shapePanel.getShapes().clear();
		int x = SPACING;
		int y = SPACING;
		for (int i = 0; i < numberOfShapes; i++) {
			Random random = new Random();
			int index = random.nextInt(ShapeType.values().length);
			ShapeType shapeType = ShapeType.values()[index];
			
			int width = random.nextInt(Shape.MAX_WIDTH - Shape.MIN_WIDTH) + Shape.MIN_WIDTH;
			int height = random.nextInt(Shape.MAX_HEIGHT - Shape.MIN_HEIGHT) + Shape.MIN_HEIGHT;
			Color colour = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
			
			Shape shape;
			switch(shapeType) {
			case RECTANGLE:
				shape = new Rectangle(x, y, width, height, colour);
				break;
			case SQUARE:
				shape = new Square(x, y, width, colour);
				break;
			case CIRCLE:
				shape = new Circle(x, y, width, colour);
				break;
			default:
				shape = null;
				break;
			}
			
			x += shape.getWidth() + SPACING;
			y += shape.getHeight() + SPACING;
			
			shapePanel.getShapes().add(shape);
		}
		shapePanel.repaint();
	}
	
}
