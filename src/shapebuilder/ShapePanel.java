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
	
	private final List<Shape> shapes = new ArrayList<Shape>();
	
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