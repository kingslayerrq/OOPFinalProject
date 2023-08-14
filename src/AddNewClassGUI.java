import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewClassGUI extends JFrame {


	private JPanel contentPane;
	private JTextField txtClassID;
	private JLabel lblClassID;
	private JButton btnAdd;
	private JButton btnCancel;
	private static AddNewClassGUI Instance;

	

	/**
	 * Create the frame.
	 */
	public AddNewClassGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblClassID = new JLabel("Enter Class ID");
		lblClassID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClassID.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassID.setBounds(104, 11, 215, 39);
		contentPane.add(lblClassID);
		
		txtClassID = new JTextField();
		txtClassID.setBounds(170, 61, 86, 20);
		contentPane.add(txtClassID);
		txtClassID.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(85, 176, 89, 23);
		contentPane.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewClassGUI.getInstance().dispose();                 //exit out of the current GUI	
				MainGUI.getInstance().setVisible(true);						//set mainGUI back to visible
			}
		});
		btnCancel.setBounds(252, 176, 89, 23);
		contentPane.add(btnCancel);
	}
	public static AddNewClassGUI getInstance() {
		if (Instance == null) {
			Instance = new AddNewClassGUI();
		}
		return Instance;
	}
}
