package shapebuilder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -5412098210805709542L;
	
	private ShapePanel shapePanel;
	private JButton loadButton = new JButton("Load shapes");
	private JButton sortButton = new JButton("Sort shapes");

	public ButtonPanel(ShapePanel shapePanel) {
		super(new FlowLayout());
		loadButton.addActionListener(this);
		loadButton.setActionCommand("load shapes");
		this.add(loadButton);
		
		sortButton.addActionListener(this);
		sortButton.setActionCommand("sort shapes");
		sortButton.setEnabled(false);
		this.add(sortButton);
		
		this.shapePanel = shapePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "load shapes":
				ShapeFactory.generateShapes(shapePanel);
				sortButton.setEnabled(true);
				break;
			case "sort shapes":
				SortingTechnique.sortBySurfaceArea(shapePanel);
				sortButton.setEnabled(false);
				break;
			default:
				break;
		}
		
	}

}
