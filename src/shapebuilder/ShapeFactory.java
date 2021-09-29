package shapebuilder;

import java.awt.Color;
import java.util.Random;

public class ShapeFactory {
	
	public static final int DEFAULT_NUMBER_OF_SHAPES = 6;
	public static final int SPACING = 10;
	public static final int MIN_SHAPE_SIZE = 20;
	
	private enum ShapeType {
		RECTANGLE,
		SQUARE,
		CIRCLE;
	}
	
	/**
	 * Generates the maximum shape width that all shapes could be, given the window size, the number
	 * of shapes, the spacing between the shapes, and the spacing from the edges of the frame.
	 * @param shapePanel
	 * @param numberOfShapes
	 * @return maxShapeWidth
	 */
	private static int getMaxShapeWidth(ShapePanel shapePanel, int numberOfShapes) {
		return Math.max((shapePanel.getSize().width - ((numberOfShapes + 2) * SPACING)) / numberOfShapes, MIN_SHAPE_SIZE);
	}
	
	/**
	 * Generates the maximum shape height that all shapes could be, given the window size, the number
	 * of shapes, the spacing between the shapes, and the spacing from the edges of the frame.
	 * @param shapePanel
	 * @param numberOfShapes
	 * @return maxShapeHeight
	 */
	private static int getMaxShapeHeight(ShapePanel shapePanel, int numberOfShapes) {
		return Math.max((shapePanel.getSize().height - ((numberOfShapes + 2) * SPACING)) / numberOfShapes, MIN_SHAPE_SIZE);
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
			
			final int MAX_WIDTH = getMaxShapeWidth(shapePanel, numberOfShapes);
			final int MAX_HEIGHT = getMaxShapeHeight(shapePanel, numberOfShapes);
			final int MAX_EQUILATERAL_SIZE = Math.min(MAX_WIDTH, MAX_HEIGHT);
			
			int width;
			int height;
			Color colour = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
			
			Shape shape;
			switch(shapeType) {
			case RECTANGLE:
				width = random.nextInt(MAX_WIDTH - MIN_SHAPE_SIZE + 1) + MIN_SHAPE_SIZE;
				height = random.nextInt(MAX_HEIGHT - MIN_SHAPE_SIZE + 1) + MIN_SHAPE_SIZE;
				shape = new Rectangle(x, y, width, height, colour);
				break;
			case SQUARE:
				width = random.nextInt(MAX_EQUILATERAL_SIZE - MIN_SHAPE_SIZE + 1) + MIN_SHAPE_SIZE;
				shape = new Square(x, y, width, colour);
				break;
			case CIRCLE:
				width = random.nextInt(MAX_EQUILATERAL_SIZE - MIN_SHAPE_SIZE + 1) + MIN_SHAPE_SIZE;
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
