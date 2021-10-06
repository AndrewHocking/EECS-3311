package shapebuilder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The JPanel in which the "Load shapes" and "Sort shapes" buttons are located.
 * @author Andrew Hocking
 */
public class ButtonPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -5412098210805709542L;
	private static final ButtonPanel instance = new ButtonPanel(ShapePanel.getInstance());
	
	private static final String LOAD_SHAPES = "Load shapes";
	private static final String SORT_SHAPES = "Sort shapes";
	private static final int NUMBER_OF_SHAPES = 6;
	
	private JButton loadButton;
	private JButton sortButton;

	private ShapePanel shapePanel;

	private ButtonPanel(ShapePanel shapePanel) {
		super(new FlowLayout());
		
		// Add "Load shapes" button
		loadButton = new JButton(LOAD_SHAPES);
		loadButton.addActionListener(this);
		loadButton.setActionCommand(LOAD_SHAPES);
		this.add(loadButton);
		
		// Add "Sort shapes" button, disabled by default
		sortButton = new JButton(SORT_SHAPES);
		sortButton.addActionListener(this);
		sortButton.setActionCommand(SORT_SHAPES);
		sortButton.setEnabled(false);
		this.add(sortButton);
		
		this.shapePanel = shapePanel;
	}
	
	/**
	 * @return The single instance of ButtonPanel.
	 */
	public static ButtonPanel getInstance() {
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case LOAD_SHAPES:
				// Generate the shapes, repaint the screen, and enable the sort button
				generateShapes(shapePanel);
				sortButton.setEnabled(true);
				break;
			case SORT_SHAPES:
				// Sort the shapes by surface area, repaint the screen, and disable the sort button
				SortingTechnique.sortBySurfaceArea(shapePanel);
				sortButton.setEnabled(false);
				break;
			default:
				break;
		}
		
	}
	
	/**
	 * Generates the new shapes and repaints the screen.
	 * @param shapePanel
	 */
	private void generateShapes(ShapePanel shapePanel) {
		shapePanel.getShapes().clear();
		
		ShapeFactory factory = new ShapeFactory();
		Random random = new Random();
		
		final int maxWidth = shapePanel.getMaxShapeWidth(NUMBER_OF_SHAPES);
		final int maxHeight = shapePanel.getMaxShapeHeight(NUMBER_OF_SHAPES);
		
		int x = ShapePanel.SPACING;
		int y = ShapePanel.SPACING;

		for (int i = 0; i < NUMBER_OF_SHAPES; i++) {
			Shape shape = factory.generateShape(ShapeType.values()[random.nextInt(ShapeType.values().length)], x, y, maxWidth, maxHeight);
			x += shape.getWidth() + ShapePanel.SPACING;
			y += shape.getHeight() + ShapePanel.SPACING;
			shapePanel.getShapes().add(shape);
		}
		
		shapePanel.repaint();
	}

}
