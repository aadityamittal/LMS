package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class StudentLogInForm extends JFrame {

	private JPanel contentPane;
	private JTextField regNoTextField;
	private JTextField nameTextField;
	JLabel userLabel;JLabel passLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogInForm frame = new StudentLogInForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentLogInForm() {
		setResizable(false);
		setTitle("Student LogIn Form");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 656);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student LogIn");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 45));
		lblNewLabel.setBounds(10, 47, 594, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 37));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(43, 219, 160, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Reg No :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 37));
		lblNewLabel_1_1.setBounds(43, 313, 160, 51);
		contentPane.add(lblNewLabel_1_1);
		
		regNoTextField = new JTextField();
		regNoTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		regNoTextField.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 36));
		regNoTextField.setColumns(10);
		regNoTextField.setBounds(197, 312, 352, 51);
		contentPane.add(regNoTextField);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 36));
		nameTextField.setColumns(10);
		nameTextField.setBounds(178, 218, 370, 51);
		contentPane.add(nameTextField);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTextString = nameTextField.getText();
				userLabel.setVisible(false);
				passLabel.setVisible(false);
				if(nameTextField.getText().equals(""))
				{
					userLabel.setVisible(true);
				}
				
				if(regNoTextField.getText().equals(""))
				{
					passLabel.setVisible(true);
				}
				
				else {
					Connection conn = MyConnection.getConnection();
					PreparedStatement ps;
					try {
						ps = conn.prepareStatement("SELECT * FROM student WHERE name = ? AND Reg_No = ?");
						ps.setString(1, nameTextField.getText());
						ps.setString(2, regNoTextField.getText());
						
						ResultSet rS = ps.executeQuery();
						
						if(rS.next())
						{
							MainFrameStudent mfs = new MainFrameStudent();
							mfs.setVisible(true);
							StudentLogInForm.this.dispose();
							MainFrameStudent.userLabel.setText("Welcome "+nameTextField.getText());
							MainFrameStudent.studentCount.setText("Student's Count = "+MyFunction.countData("student"));
							MainFrameStudent.bookCount.setText("Book's count = "+MyFunction.countData("course"));
							MainFrameStudent.registNo.setText(regNoTextField.getText());
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid details");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnLogin.setBounds(368, 447, 191, 64);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogInForm.this.dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(43, 447, 191, 64);
		contentPane.add(btnCancel);
		
		userLabel = new JLabel("*");
		userLabel.setVisible(false);
		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		userLabel.setBounds(558, 196, 45, 43);
		contentPane.add(userLabel);
		
		passLabel = new JLabel("*");
		passLabel.setVisible(false);
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		passLabel.setBounds(559, 290, 45, 43);
		contentPane.add(passLabel);
	}
}
