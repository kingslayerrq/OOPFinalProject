import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class BrowseSubjectGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSubjectTitle;
	private JList<Course> lstSubjectCoursesList;
	private JButton btnCancel;
	private static BrowseSubjectGUI Instance;
	private JComboBox<String> cmboSubject;
	private JScrollPane spScroll;

	/**
	 * Create the frame.
	 */
	private BrowseSubjectGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSubjectTitle = new JLabel("Subjects");
		lblSubjectTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectTitle.setBounds(40, 29, 122, 37);
		lblSubjectTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSubjectTitle);
		
		cmboSubject = new JComboBox<String>();
		cmboSubject.addItem("");
		//add subject to the comboBox
		for(String i:CourseLib.getInstance().getAllSubjects()) {
			cmboSubject.addItem(i);
		}
		cmboSubject.setBounds(220, 38, 156, 22);
		contentPane.add(cmboSubject);
		
		//default comboBox and JList
		DefaultListModel<Course> listModel = new DefaultListModel<Course>();
		String curSelectedSubject = (String)cmboSubject.getSelectedItem();
		for(Course i:CourseLib.getInstance().getCourseBySubject(curSelectedSubject)) {
			listModel.addElement(i);
		}
		lstSubjectCoursesList = new JList<Course>(listModel);
		lstSubjectCoursesList.setCellRenderer(new CustomListCellRenderer());
		
		
		//update JList when select new item from comboBox
		cmboSubject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String newSelectedSubject = (String)cmboSubject.getSelectedItem();
				updateJList(newSelectedSubject, listModel);
			}
		});
		

		spScroll = new JScrollPane(lstSubjectCoursesList);
		spScroll.setBounds(40, 71, 360, 143);
		contentPane.add(spScroll);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instance.clear();                                               //clear the comboBox selection
				Instance.dispose();
				SearchClassGUI.getInstance().setVisible(true);
			}
		});
		btnCancel.setBounds(170, 225, 89, 23);
		contentPane.add(btnCancel);
		
		
		
		
	}
	
	public static BrowseSubjectGUI getInstance() {
		if (Instance == null) {
			Instance = new BrowseSubjectGUI();
		}
		return Instance;
	}
	
	public void updateJList(String curSelectedSubject, DefaultListModel<Course> listModel) {
		// clear and populate the list
		listModel.clear();                 
		for(Course i:CourseLib.getInstance().getCourseBySubject(curSelectedSubject)) {
			listModel.addElement(i);
		}
	}
	
	public void clear() {
		cmboSubject.setSelectedIndex(0);
	}
}
