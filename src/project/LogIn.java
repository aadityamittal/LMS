package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LogIn {

	public JFrame frmLoginPage;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel userLabel;
	private JLabel passLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
		userLabel.setVisible(false);
		passLabel.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setResizable(false);
		frmLoginPage.setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		frmLoginPage.setTitle("LogIn Page");
		frmLoginPage.getContentPane().setBackground(Color.RED);
		frmLoginPage.setBounds(100, 100, 579, 603);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN FORM");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setBounds(171, 112, 248, 37);
		frmLoginPage.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("Images\\profile.png"));
		lblNewLabel_1.setBounds(74, 201, 124, 89);
		frmLoginPage.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.BOLD, 27));
		textField.setBounds(171, 223, 342, 49);
		frmLoginPage.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("Images\\key.png"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(74, 313, 124, 89);
		frmLoginPage.getContentPane().add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SansSerif", Font.BOLD, 27));
		passwordField.setBounds(171, 345, 342, 49);
		frmLoginPage.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLabel.setVisible(false);
				passLabel.setVisible(false);
				if(textField.getText().equals(""))
				{
					userLabel.setVisible(true);
				}
				
				if(passwordField.getText().equals(""))
				{
					passLabel.setVisible(true);
				}
				
				else {
					Connection conn = MyConnection.getConnection();
					PreparedStatement ps;
					try {
						ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
						ps.setString(1, textField.getText());
						ps.setString(2, String.valueOf(passwordField.getPassword()));
						
						ResultSet rS = ps.executeQuery();
						
						if(rS.next())
						{
							MainForm mForm = new MainForm();
							mForm.setVisible(true);
							//mForm.pack();
							//mForm.setLocationRelativeTo(null);
//							mForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
							MainForm.userLabel.setText("Welcome "+textField.getText());
							MainForm.studentCount.setText("Student's Count = "+MyFunction.countData("student"));
							MainForm.bookCount.setText("Book's count = "+MyFunction.countData("course"));
							frmLoginPage.dispose();
						}
						else {
							System.out.println("No");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(48, 430, 166, 49);
		frmLoginPage.getContentPane().add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		btnSignUp.setBackground(Color.RED);
		btnSignUp.setBounds(375, 430, 166, 49);
		frmLoginPage.getContentPane().add(btnSignUp);
		
		JButton btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		btnForgetPassword.setBackground(Color.RED);
		btnForgetPassword.setBounds(171, 507, 266, 49);
		frmLoginPage.getContentPane().add(btnForgetPassword);
		
		userLabel = new JLabel("*");
		userLabel.setForeground(Color.MAGENTA);
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		userLabel.setBounds(520, 201, 45, 49);
		frmLoginPage.getContentPane().add(userLabel);
		
		passLabel = new JLabel("*");
		passLabel.setForeground(Color.MAGENTA);
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passLabel.setBounds(520, 325, 45, 49);
		frmLoginPage.getContentPane().add(passLabel);
	}
}
