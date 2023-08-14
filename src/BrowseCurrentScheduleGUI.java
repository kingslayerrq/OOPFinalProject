import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

public class BrowseCurrentScheduleGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurrentSchedule;

	private JButton btnDelete;
	private JButton btnCancel;
	private JList<Course> scheduleJList;
	private DefaultListModel<Course> listModel;
	private static BrowseCurrentScheduleGUI Instance;
	

	/**
	 * Create the frame.
	 */
	private BrowseCurrentScheduleGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCurrentSchedule = new JLabel("Current Schedule");
		lblCurrentSchedule.setBounds(124, 11, 169, 33);
		lblCurrentSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentSchedule.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblCurrentSchedule);
		
		
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course curSelectedCourse = scheduleJList.getSelectedValue();
				if(!curSelectedCourse.getCourseID().equals(CourseLib.titleCourse.getCourseID())) {
					if(PersonalSchedule.getInstance().deleteCourse(curSelectedCourse)) {
						Instance.update();
						JOptionPane.showMessageDialog(Instance, "Course Successfully Deleted", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(Instance, "Deletion Error", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(Instance, "This is for Formatting reason. Please don't select this!", "WARN", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnDelete.setBounds(40, 225, 89, 23);
		contentPane.add(btnDelete);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instance.dispose();
				MainGUI.getInstance().setVisible(true);
			}
		});
		btnCancel.setBounds(311, 225, 89, 23);
		contentPane.add(btnCancel);
		
		
		
		listModel = new DefaultListModel<Course>();
		
		for(Course i:PersonalSchedule.getInstance().getSchedule()) {
			System.out.println(i.getCourseID());
			listModel.addElement(i);
		}
		scheduleJList = new JList<Course>(listModel);
		scheduleJList.setCellRenderer(new CustomListCellRenderer());
		
	
		JScrollPane scrollPane = new JScrollPane(scheduleJList);
		scrollPane.setBounds(40, 55, 360, 159);
		contentPane.add(scrollPane);
		
	}
	
	public static BrowseCurrentScheduleGUI getInstance() {
		if (Instance == null) {
			Instance = new BrowseCurrentScheduleGUI();
		}
		return Instance;
	}
	
	public void update() {
		// clear and populate the list
		listModel.clear();         
		
		for(Course i:PersonalSchedule.getInstance().getSchedule()) {
			listModel.addElement(i);
		}
	}
}
