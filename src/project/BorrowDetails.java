package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class BorrowDetails extends JFrame {

	private JPanel contentPane;
	public JTextField registTextField;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowDetails frame = new BorrowDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fillStudentForm()
	{
		Connection conn = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement("SELECT * FROM `student` WHERE `Reg_No` = ?");
			ps.setString(1, registTextField.getText());
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				int id = rSet.getInt(1);
				fillFormUsingScore(id);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void fillFormUsingScore(int id)
	{
		Connection conn = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement("SELECT * FROM `score` WHERE `student_id` = ?");
			ps.setLong(1, id);
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				textField.setText(rSet.getString(3));
				textField_1.setText(rSet.getString(4));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public BorrowDetails() {
		setResizable(false);
		setTitle("Borrow Books");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1296, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Borrow Details");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 42));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 1272, 81);
		contentPane.add(lblNewLabel);
		
		registTextField = new JTextField();
		registTextField.setEditable(false);
		registTextField.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 30));
		registTextField.setBounds(1152, 10, 96, 51);
		contentPane.add(registTextField);
		registTextField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Date Borrowed:");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_3.setBounds(80, 177, 267, 42);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Description:");
		lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_4.setBounds(80, 229, 173, 42);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("See Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillStudentForm();
			}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(52, 315, 523, 71);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(270, 177, 523, 36);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(270, 229, 523, 36);
		contentPane.add(textField_1);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowDetails.this.dispose();
			}
		});
		btnGoBack.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 23));
		btnGoBack.setBackground(Color.WHITE);
		btnGoBack.setBounds(725, 315, 523, 71);
		contentPane.add(btnGoBack);
	}

}
