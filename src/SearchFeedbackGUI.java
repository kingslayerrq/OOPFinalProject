import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchFeedbackGUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtProfessorName;
	private String searchParamToPassOn;
	private JLabel lblProfessorName;
	private JLabel lblSearchProfessorNameTitle;
	private JButton btnSearch;
	private JButton btnCancel;
	private static SearchFeedbackGUI Instance;
	
	private SearchFeedbackGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblProfessorName = new JLabel("Professor Name");
		lblProfessorName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProfessorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessorName.setBounds(22, 103, 92, 33);
		contentPane.add(lblProfessorName);
		
		txtProfessorName = new JTextField();
		txtProfessorName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtProfessorName.setBounds(155, 109, 225, 27);
		contentPane.add(txtProfessorName);
		txtProfessorName.setColumns(10);
		
		lblSearchProfessorNameTitle = new JLabel("Search By Professor Name");
		lblSearchProfessorNameTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearchProfessorNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchProfessorNameTitle.setBounds(102, 11, 215, 62);
		contentPane.add(lblSearchProfessorNameTitle);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtProfessorName.getText().equals("")) {
				if (FeedbackLib.getInstance().getFeedbackByName(txtProfessorName.getText()).size()>0) {        
					searchParamToPassOn = txtProfessorName.getText();
					Instance.setVisible(false);          					
					
					SearchFeedbackResultGUI.getInstance().update(searchParamToPassOn, SearchFeedbackResultGUI.getInstance().getListModel());
					SearchFeedbackResultGUI.getInstance().setVisible(true);
				
				}
				else {
					JOptionPane.showMessageDialog(Instance, "Professor doesn't exist", "ERROR", JOptionPane.ERROR_MESSAGE);//throw an error

				}
				}
				else {
					JOptionPane.showMessageDialog(Instance, "Please Enter Something!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(62, 200, 89, 23);
		contentPane.add(btnSearch);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instance.clear();
				Instance.dispose();
				MainGUI.getInstance().setVisible(true);
			}
		});
		btnCancel.setBounds(271, 200, 89, 23);
		contentPane.add(btnCancel);
	}
	
	public String getSearchParamToPassOn() {
		return searchParamToPassOn;
	}

	public void setSearchParamToPassOn(String searchParamToPassOn) {
		this.searchParamToPassOn = searchParamToPassOn;
	}
	
	public void clear() {
		txtProfessorName.setText("");
	}
	
	public static SearchFeedbackGUI getInstance() {
		if (Instance == null) {
			Instance = new SearchFeedbackGUI();
		}
		else {
			Instance.clear();
		}
		return Instance;
	}
}
