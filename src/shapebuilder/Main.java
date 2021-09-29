package shapebuilder;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		ShapePanel shapePanel = new ShapePanel();
		ButtonPanel buttons = new ButtonPanel(shapePanel);
		JFrame frame = new JFrame("Display Shapes - Andrew Hocking - 215752835 - EECS 3311 Section B");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(shapePanel);
		frame.add(buttons, BorderLayout.NORTH);
		frame.setMinimumSize(new Dimension(250, 275));
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
