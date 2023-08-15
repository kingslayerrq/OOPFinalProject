import javax.swing.DefaultListCellRenderer;
import javax.swing.*;

import java.awt.*;
import java.util.*;


public  class CustomListCellRendererFB extends DefaultListCellRenderer{
	@Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		JPanel panel = new JPanel(new GridLayout(1, 5));
		panel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        if (value instanceof Feedback) {
            Feedback feedback = (Feedback) value;
            JLabel profJLabel = new JLabel(feedback.getProfName());
            JLabel courseIDJLabel = new JLabel(feedback.getCourseID());
            JLabel ratingJLabel = new JLabel(feedback.getRating());
            JLabel difficultyJLabel = new JLabel(feedback.getDifficulty());
            panel.add(profJLabel);
            panel.add(courseIDJLabel);
            panel.add(ratingJLabel);
            panel.add(difficultyJLabel);           
        }
        
        return panel;
    }
}
