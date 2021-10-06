package shapebuilder;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * The JPanel in which the shapes are drawn.
 * @author Andrew Hocking
 */
public class ShapePanel extends JPanel {

	private static final long serialVersionUID = -6477724278434788915L;
	private static final ShapePanel instance = new ShapePanel();
	
	public static final int SPACING = 10;
	public static final int MIN_SHAPE_SIZE = 20;
	
	private final List<Shape> shapes = new ArrayList<Shape>();
	
	private ShapePanel() {}
	
	/**
	 * @return The single instance of ShapePanel.
	 */
	public static ShapePanel getInstance() {
		return instance;
	}
	
	/**
	 * Generates the maximum shape width that all shapes could be, given the window size, the number
	 * of shapes, the spacing between the shapes, and the spacing from the edges of the frame.
	 * @param numberOfShapes
	 * @return maxShapeWidth
	 */
	public int getMaxShapeWidth(int numberOfShapes) {
		return Math.max((this.getSize().width - ((numberOfShapes + 2) * SPACING)) / numberOfShapes, MIN_SHAPE_SIZE);
	}
	
	/**
	 * Generates the maximum shape height that all shapes could be, given the window size, the number
	 * of shapes, the spacing between the shapes, and the spacing from the edges of the frame.
	 * @param numberOfShapes
	 * @return maxShapeHeight
	 */
	public int getMaxShapeHeight(int numberOfShapes) {
		return Math.max((this.getSize().height - ((numberOfShapes + 2) * SPACING)) / numberOfShapes, MIN_SHAPE_SIZE);
	}
	
	/**
	 * @return The list of Shapes on screen, in order from left to right.
	 */
	public List<Shape> getShapes() {
		return shapes;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Shape shape : getShapes()) {
			shape.draw(g);
		}
	}
}