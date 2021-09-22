package shapebuilder;

import java.util.Comparator;

public class SortingTechnique {
	
	public static void sortBySurfaceArea(ShapePanel shapePanel) {
		shapePanel.getShapes().sort(Comparator.naturalOrder());
		
		int x = 10;
		int y = 10;
		
		for (Shape shape : shapePanel.getShapes()) {
			shape.setX(x);
			shape.setY(y);
			x += shape.getWidth() + ShapeFactory.SPACING;
			y += shape.getHeight() + ShapeFactory.SPACING;
		}
		
		shapePanel.repaint();
	}

}
