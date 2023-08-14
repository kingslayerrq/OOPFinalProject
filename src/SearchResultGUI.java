import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchResultGUI extends JFrame {
	
	private String searchParam;
	private JPanel contentPane;
	private JLabel lblSearchResultTitle;
	private JScrollPane spScroll;
	private JButton btnCancel;
	private static SearchResultGUI Instance;
	private JList<Course> resultJList;
	private DefaultListModel<Course> listModel;

	/**
	 * Create the frame.
	 */
	private SearchResultGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSearchResultTitle = new JLabel("Search Result");
		lblSearchResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchResultTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearchResultTitle.setBounds(155, 11, 117, 33);
		contentPane.add(lblSearchResultTitle);
		
		//populate JList
//		searchParam = SearchClassNameGUI.getInstance().getSearchParamToPassOn();             //get search param from previous GUI
//		listModel = new DefaultListModel<Course>();
//		for(Course i:CourseLib.getInstance().getCourseByName(searchParam)) {
//			listModel.addElement(i);
//		}
		listModel = new DefaultListModel<Course>();

		resultJList = new JList<Course>(listModel);
		resultJList.setCellRenderer(new CustomListCellRenderer());
		spScroll = new JScrollPane(resultJList);
		spScroll.setBounds(40, 71, 360, 143);
		contentPane.add(spScroll);
		
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchClassNameGUI.getInstance().setVisible(true);
				Instance.dispose();                                     //dispose result
			}
		});
		btnCancel.setBounds(170, 225, 89, 23);
		contentPane.add(btnCancel);
	}
	
	
	
	public DefaultListModel<Course> getListModel() {
		return listModel;
	}



	public void setListModel(DefaultListModel<Course> listModel) {
		this.listModel = listModel;
	}



	public static SearchResultGUI getInstance() {
		if (Instance == null) {
			Instance = new SearchResultGUI();
		}
		return Instance;
	}
	public void update(String searchParam, DefaultListModel<Course> listModel) {
		// clear and populate the list
		listModel.clear();         
		listModel.addElement(CourseLib.titleCourse);
		for(Course i:CourseLib.getInstance().getCourseByName(searchParam)) {
			listModel.addElement(i);
		}
	}
}
