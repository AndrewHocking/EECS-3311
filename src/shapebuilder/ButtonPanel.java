package shapebuilder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -5412098210805709542L;
	private static final String LOAD_SHAPES = "Load shapes";
	private static final String SORT_SHAPES = "Sort shapes";
	
	private JButton loadButton;
	private JButton sortButton;

	private ShapePanel shapePanel;

	public ButtonPanel(ShapePanel shapePanel) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case LOAD_SHAPES:
				// Generate the shapes, repaint the screen, and enable the sort button
				ShapeFactory.generateShapes(shapePanel);
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

}
