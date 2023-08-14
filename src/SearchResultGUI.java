import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchResultGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSearchResultTitle;
	private JScrollPane spScroll;
	private JButton btnCancel;
	private static SearchResultGUI Instance;
	private JList list;
	

	/**
	 * Create the frame.
	 */
	public SearchResultGUI() {
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
		
		spScroll = new JScrollPane();
		spScroll.setBounds(40, 71, 360, 143);
		contentPane.add(spScroll);
		
		list = new JList();
		spScroll.setViewportView(list);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SearchClassGUI.getInstance().getOption() == SearchClassGUI.SearchClassOption.Subject) {
					BrowseSubjectGUI.getInstance().setVisible(true);
				}
				else {
					SearchClassNameGUI.getInstance().setVisible(true);
				}
				SearchResultGUI.getInstance().dispose();                                     //dispose result
			}
		});
		btnCancel.setBounds(170, 225, 89, 23);
		contentPane.add(btnCancel);
	}
	
	public static SearchResultGUI getInstance() {
		if (Instance == null) {
			Instance = new SearchResultGUI();
		}
		return Instance;
	}
}
