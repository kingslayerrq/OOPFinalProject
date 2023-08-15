
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainGUI extends JFrame {



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MainGUI frame = new MainGUI();
					MainGUI frame = MainGUI.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel contentPane;
	private JButton btnAddNewClass;
	private JButton btnSearchClass;
	private JButton btnCurrentSchedule;
	private JButton btnSearchFeedback;
	private static MainGUI Instance;      //Singleton
	
	/**
	 * Create the frame.
	 */
	private MainGUI() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnSearchClass = new JButton("Course Search");
		btnSearchClass.setBounds(128, 100, 180, 23);
		btnSearchClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instance.setVisible(false);
				SearchClassGUI.getInstance().setVisible(true);
				
			}
		});
		
		btnAddNewClass = new JButton("Add New Class");
		btnAddNewClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instance.setVisible(false);		
				AddNewClassGUI.getInstance().setVisible(true);
				
			}
		});
		btnAddNewClass.setBounds(128, 50, 180, 23);
		
		btnCurrentSchedule = new JButton("Current Schedule");
		btnCurrentSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instance.setVisible(false);
				BrowseCurrentScheduleGUI.getInstance().setVisible(true);
			}
		});
		btnCurrentSchedule.setBounds(128, 150, 180, 23);
		
		
		btnSearchFeedback = new JButton("Feedback Search");
		btnSearchFeedback.setBounds(128, 120, 180, 23);
		btnSearchFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instance.setVisible(false);
				SearchFeedbackGUI.getInstance().setVisible(true);			
			}
		});
		btnSearchFeedback.setBounds(128, 200, 180, 23);
		
		contentPane.setLayout(null);
		contentPane.add(btnAddNewClass);
		contentPane.add(btnSearchClass);
		contentPane.add(btnCurrentSchedule);
		contentPane.add(btnSearchFeedback);
	}
	
	public static MainGUI getInstance() {
		if (Instance == null) {
			Instance = new MainGUI();
		}
		return Instance;
	}
}
