import javax.swing.DefaultListCellRenderer;
import javax.swing.*;

import java.awt.*;
import java.util.*;


public  class CustomListCellRenderer extends DefaultListCellRenderer{
	@Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		JPanel panel = new JPanel(new GridLayout(1, 5));
		panel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
        if (value instanceof Course) {
            Course course = (Course) value;
            JLabel courseIDJLabel = new JLabel(course.getCourseID());
            JLabel courseSubjectJLabel = new JLabel(course.getSubject());
            JLabel courseNameJLabel = new JLabel(course.getCourseName());
            JLabel courseProfJLabel = new JLabel(course.getProfName()); 
            JLabel courseCreditJLabel = new JLabel(Float.toString(course.getCredit()));
            panel.add(courseIDJLabel);
            panel.add(courseSubjectJLabel);
            panel.add(courseNameJLabel);
            panel.add(courseProfJLabel);
            panel.add(courseCreditJLabel);
            

        }
        
        return panel;
    }
}
