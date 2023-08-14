import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchClassNameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtClassName;
	private JLabel lblClassName;
	private JLabel lblSearchClassNameTitle;
	private JButton btnSearch;
	private JButton btnCancel;
	private static SearchClassNameGUI Instance;

	/**
	 * Create the frame.
	 */
	public SearchClassNameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblClassName = new JLabel("Class Name");
		lblClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClassName.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassName.setBounds(22, 103, 92, 33);
		contentPane.add(lblClassName);
		
		txtClassName = new JTextField();
		txtClassName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtClassName.setBounds(155, 109, 225, 27);
		contentPane.add(txtClassName);
		txtClassName.setColumns(10);
		
		lblSearchClassNameTitle = new JLabel("Search By Class Name");
		lblSearchClassNameTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearchClassNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchClassNameTitle.setBounds(102, 11, 215, 62);
		contentPane.add(lblSearchClassNameTitle);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClassNameGUI.getInstance().setVisible(false);          					//not disposing
				SearchResultGUI.getInstance().setVisible(true);
			}
		});
		btnSearch.setBounds(62, 200, 89, 23);
		contentPane.add(btnSearch);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClassNameGUI.getInstance().dispose();
				SearchClassGUI.getInstance().setVisible(true);
			}
		});
		btnCancel.setBounds(271, 200, 89, 23);
		contentPane.add(btnCancel);
	}
	
	public static SearchClassNameGUI getInstance() {
		if (Instance == null) {
			Instance = new SearchClassNameGUI();
		}
		return Instance;
	}

}
