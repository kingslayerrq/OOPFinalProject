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

public class BrowseCurrentScheduleGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurrentSchedule;
	private JList<Course> lstCurrentSchedule;
	private JScrollPane spScroll;
	private JButton btnDelete;
	private JButton btnCancel;
	private static BrowseCurrentScheduleGUI Instance;

	/**
	 * Create the frame.
	 */
	public BrowseCurrentScheduleGUI() {
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
		
		spScroll = new JScrollPane();
		spScroll.setBounds(40, 71, 360, 143);
		contentPane.add(spScroll);
		
		lstCurrentSchedule = new JList<Course>();
		spScroll.setViewportView(lstCurrentSchedule);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(40, 225, 89, 23);
		contentPane.add(btnDelete);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrowseCurrentScheduleGUI.getInstance().dispose();
				MainGUI.getInstance().setVisible(true);
			}
		});
		btnCancel.setBounds(311, 225, 89, 23);
		contentPane.add(btnCancel);
	}
	
	public static BrowseCurrentScheduleGUI getInstance() {
		if (Instance == null) {
			Instance = new BrowseCurrentScheduleGUI();
		}
		return Instance;
	}

}
