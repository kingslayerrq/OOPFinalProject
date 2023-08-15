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

public class SearchFeedbackResultGUI extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblSearchResultTitle;
	private JScrollPane spScroll;
	private JButton btnCancel;
	private static SearchFeedbackResultGUI Instance;
	private JList<Feedback> resultJList;
	private DefaultListModel<Feedback> listModel;

	/**
	 * Create the frame.
	 */
	private SearchFeedbackResultGUI() {
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
		
		listModel = new DefaultListModel<Feedback>();

		resultJList = new JList<Feedback>(listModel);
		resultJList.setCellRenderer(new CustomListCellRendererFB());
		spScroll = new JScrollPane(resultJList);
		spScroll.setBounds(40, 71, 360, 143);
		contentPane.add(spScroll);
		
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchFeedbackGUI.getInstance().setVisible(true);
				Instance.dispose();                                     //dispose result
			}
		});
		btnCancel.setBounds(170, 225, 89, 23);
		contentPane.add(btnCancel);
	}
	
	
	
	public DefaultListModel<Feedback> getListModel() {
		return listModel;
	}



	public void setListModel(DefaultListModel<Feedback> listModel) {
		this.listModel = listModel;
	}



	public static SearchFeedbackResultGUI getInstance() {
		if (Instance == null) {
			Instance = new SearchFeedbackResultGUI();
		}
		return Instance;
	}
	
	public void update(String searchParam, DefaultListModel<Feedback> listModel) {
		// clear and populate the list
		listModel.clear();         
		listModel.addElement(FeedbackLib.rateMyProfessor);
		for(Feedback i:FeedbackLib.getInstance().getFeedbackByName(searchParam)) {
			listModel.addElement(i);
		}
	}
	
}
