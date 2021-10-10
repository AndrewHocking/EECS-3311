package shapebuilder;

import java.util.List;

/**
 * A utility class for sorting the Shape objects.
 * @author Andrew Hocking
 */
public class SortingTechnique {
	
	private SortingTechnique() {}
	
	/**
	 * Sorts shapes by their surface area in ascending order using Bubble Sort, then repaints the screen.
	 * @param shapePanel
	 */
	public static void sortBySurfaceArea() {
		List<Shape> shapes = ShapePanel.getInstance().getShapes();
        int numberOfShapes = shapes.size();
        for (int i = 0; i < numberOfShapes - 1; i++) {
            for (int j = 0; j < numberOfShapes - i - 1; j++) {
                if (shapes.get(j).compareTo(shapes.get(j + 1)) > 0) {
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
        repaintShapes();
    }
	
	private static void repaintShapes() {
		int x = ShapePanel.SPACING;
		int y = ShapePanel.SPACING;
		for (Shape shape : ShapePanel.getInstance().getShapes()) {
			shape.setX(x);
			shape.setY(y);
			x += shape.getWidth() + ShapePanel.SPACING;
			y += shape.getHeight() + ShapePanel.SPACING;
		}
		ShapePanel.getInstance().repaint();
	}
}
