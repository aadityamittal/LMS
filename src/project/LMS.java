package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LMS extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LMS frame = new LMS();
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
	public LMS() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setTitle("Main Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 632);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Images\\siksha.jpg"));
		lblNewLabel.setBounds(0, 115, 1430, 485);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To SOA University");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(106, 24, 1267, 70);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogInForm obj = new StudentLogInForm();
				obj.setVisible(true);
				LMS.this.dispose();
				
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 41));
		btnNewButton.setBounds(26, 20, 289, 85);
		contentPane.add(btnNewButton);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn a = new LogIn();
				a.frmLoginPage.setVisible(true);
				LMS.this.dispose();
			}
		});
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 41));
		btnAdmin.setBackground(Color.BLACK);
		btnAdmin.setBounds(1123, 20, 289, 85);
		contentPane.add(btnAdmin);
		
	}
}
