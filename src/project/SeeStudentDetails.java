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
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SeeStudentDetails extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField nameTextField;
	public static JTextField regNotextField;
	private JTextField sexTextField;
	private JTextField phoneTextField;
	private JTextField birthTextField;
	JTextArea addressTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeStudentDetails frame = new SeeStudentDetails();
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
			ps.setString(1, regNotextField.getText());
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				idTextField.setText(String.valueOf(rSet.getInt(1)));
				nameTextField.setText(rSet.getString(2));
				regNotextField.setText(rSet.getString(3));
				sexTextField.setText(rSet.getString(4));
				birthTextField.setText(rSet.getString(5));
				phoneTextField.setText(rSet.getString(6));
				addressTextField.setText(rSet.getString(7));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Create the frame.
	 */
	public SeeStudentDetails() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setTitle("Student Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 662);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("See Student Details");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 22, 623, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_1.setBounds(73, 111, 140, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(73, 163, 140, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Reg No:");
		lblNewLabel_1_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBounds(73, 215, 140, 42);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Sex:");
		lblNewLabel_1_1_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_1_1_2.setBounds(73, 267, 140, 42);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Birth Date:");
		lblNewLabel_1_1_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_1_1_3.setBounds(73, 319, 140, 42);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Phone:");
		lblNewLabel_1_1_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_1_1_4.setBounds(73, 371, 140, 42);
		contentPane.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Address:");
		lblNewLabel_1_1_5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_1_1_5.setBounds(73, 423, 140, 42);
		contentPane.add(lblNewLabel_1_1_5);
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		idTextField.setBounds(131, 119, 523, 36);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		nameTextField.setColumns(10);
		nameTextField.setBounds(162, 169, 523, 36);
		contentPane.add(nameTextField);
		
		regNotextField = new JTextField();
		regNotextField.setEditable(false);
		regNotextField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		regNotextField.setColumns(10);
		regNotextField.setBounds(172, 215, 523, 36);
		contentPane.add(regNotextField);
		
		sexTextField = new JTextField();
		sexTextField.setEditable(false);
		sexTextField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		sexTextField.setColumns(10);
		sexTextField.setBounds(131, 273, 523, 36);
		contentPane.add(sexTextField);
		
		phoneTextField = new JTextField();
		phoneTextField.setEditable(false);
		phoneTextField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(162, 377, 523, 36);
		contentPane.add(phoneTextField);
		
		 addressTextField = new JTextArea();
		addressTextField.setEditable(false);
		addressTextField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		addressTextField.setBounds(182, 436, 488, 63);
		contentPane.add(addressTextField);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeStudentDetails.this.dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 35));
		btnNewButton.setBounds(229, 560, 278, 55);
		contentPane.add(btnNewButton);
		
		birthTextField = new JTextField();
		birthTextField.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		birthTextField.setEditable(false);
		birthTextField.setColumns(10);
		birthTextField.setBounds(199, 319, 523, 36);
		contentPane.add(birthTextField);
		
		JButton btnNewButton_1 = new JButton("Press Me");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillStudentForm();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("Images\\binocular.png"));
		btnNewButton_1.setBounds(10, 10, 161, 33);
		contentPane.add(btnNewButton_1);
		
		
	}
}
