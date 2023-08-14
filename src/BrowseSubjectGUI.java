import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BrowseSubjectGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSubjectTitle;
	private JList<String> lstSubjectList;
	private JButton btnViewClass;
	private JButton btnCancel;
	private static BrowseSubjectGUI Instance;

	/**
	 * Create the frame.
	 */
	public BrowseSubjectGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSubjectTitle = new JLabel("Subjects");
		lblSubjectTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectTitle.setBounds(156, 11, 122, 37);
		lblSubjectTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblSubjectTitle);
		
		lstSubjectList = new JList<String>();
		lstSubjectList.setBounds(40, 71, 360, 143);
		contentPane.add(lstSubjectList);
		
		btnViewClass = new JButton("View Classes");
		btnViewClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrowseSubjectGUI.getInstance().setVisible(false);         				//not disposing 
				SearchResultGUI.getInstance().setVisible(true);
			}
		});
		btnViewClass.setBounds(40, 225, 113, 23);
		contentPane.add(btnViewClass);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrowseSubjectGUI.getInstance().dispose();
				SearchClassGUI.getInstance().setVisible(true);
			}
		});
		btnCancel.setBounds(287, 225, 113, 23);
		contentPane.add(btnCancel);
	}
	
	public static BrowseSubjectGUI getInstance() {
		if (Instance == null) {
			Instance = new BrowseSubjectGUI();
		}
		return Instance;
	}
}
