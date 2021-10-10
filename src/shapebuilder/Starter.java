package shapebuilder;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * This class simply houses the main method which runs the application.
 * @author Andrew Hocking
 */
public class Starter {
	
	private final static Starter INSTANCE = new Starter();
	private Starter() {}
	
	public static Starter getInstance() {
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Display Shapes - Andrew Hocking - 215752835 - EECS 3311 Section B");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(ShapePanel.getInstance());
		frame.add(ButtonPanel.getInstance(), BorderLayout.NORTH);
		frame.setMinimumSize(new Dimension(600, 600));
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
