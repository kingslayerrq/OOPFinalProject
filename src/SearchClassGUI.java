import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchClassGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnBrowseSubject;
	private JButton btnSearchName;
	private JButton btnCancel;
	private static SearchClassGUI Instance;
	

	/**
	 * Create the frame.
	 */
	private SearchClassGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBrowseSubject = new JButton("Browse By Subject");
		btnBrowseSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				                       
				Instance.setVisible(false);												//not disposing
				BrowseSubjectGUI.getInstance().setVisible(true);;

				
			}
		});
		btnBrowseSubject.setBounds(21, 100, 180, 23);
		contentPane.add(btnBrowseSubject);
		
		btnSearchName = new JButton("Search By Class Name");
		btnSearchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				           
				Instance.setVisible(false);
				SearchClassNameGUI.getInstance().setVisible(true);
			}
		});
		btnSearchName.setBounds(230, 100, 180, 23);
		contentPane.add(btnSearchName);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClassGUI.getInstance().dispose();
				MainGUI.getInstance().setVisible(true);
			}
		});
		btnCancel.setBounds(172, 196, 89, 23);
		contentPane.add(btnCancel);
	}
	
	public static SearchClassGUI getInstance() {
		if (Instance == null) {
			Instance = new SearchClassGUI();
		}
		return Instance;
	}
	
	
}
