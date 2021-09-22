package shapebuilder;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapePanel extends JPanel {

	private static final long serialVersionUID = -6477724278434788915L;
	
	private List<Shape> shapes = new ArrayList<Shape>();
	
	public static void main(String[] args) {
		ShapePanel shapePanel = new ShapePanel();
		ButtonPanel buttons = new ButtonPanel(shapePanel);
		JFrame frame = new JFrame("Display Shapes - Andrew Hocking - 215752835 - EECS 3311 Section B");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(shapePanel);
		frame.add(buttons, BorderLayout.NORTH);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Shape shape : getShapes()) {
			shape.draw(g);
		}
	}

	public List<Shape> getShapes() {
		return shapes;
	}
}