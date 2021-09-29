package shapebuilder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -5412098210805709542L;
	
	private final class ButtonAction {
		public static final String LOAD_SHAPES = "Load shapes";
		public static final String SORT_SHAPES = "Sort shapes";
	}
	
	private JButton loadButton;
	private JButton sortButton;

	private ShapePanel shapePanel;

	public ButtonPanel(ShapePanel shapePanel) {
		super(new FlowLayout());
		
		// Add "Load shapes" button
		loadButton = new JButton(ButtonAction.LOAD_SHAPES);
		loadButton.addActionListener(this);
		loadButton.setActionCommand(ButtonAction.LOAD_SHAPES);
		this.add(loadButton);
		
		// Add "Sort shapes" button, disabled by default
		sortButton = new JButton(ButtonAction.SORT_SHAPES);
		sortButton.addActionListener(this);
		sortButton.setActionCommand(ButtonAction.SORT_SHAPES);
		sortButton.setEnabled(false);
		this.add(sortButton);
		
		this.shapePanel = shapePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case ButtonAction.LOAD_SHAPES:
				// Generate the shapes, repaint the screen, and enable the sort button
				ShapeFactory.generateShapes(shapePanel);
				sortButton.setEnabled(true);
				break;
			case ButtonAction.SORT_SHAPES:
				// Sort the shapes by surface area, repaint the screen, and disable the sort button
				SortingTechnique.sortBySurfaceArea(shapePanel);
				sortButton.setEnabled(false);
				break;
			default:
				break;
		}
		
	}

}
