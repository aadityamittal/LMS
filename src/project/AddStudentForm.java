package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

public class AddStudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField reg;
	private JTextField phone;
	private JTextArea address;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnOthers;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentForm frame = new AddStudentForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public boolean verify()
	{
		if (name.getText().equals("")||reg.getText().equals("")||phone.getText().equals("")||address.getText().equals("")||dateChooser.getDate()==null) {
			JOptionPane.showMessageDialog(null, "Insert in every text box");
			return false;
		}
		else if (dateChooser.getDate().compareTo(new Date())>0) {
			JOptionPane.showMessageDialog(null, "Enter correct date");
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * Create the frame.
	 */
	public AddStudentForm() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setTitle("Add New Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 672);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Student");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 565, 87);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(new Color(218, 112, 214));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(44, 139, 123, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Registration No:");
		lblNewLabel_1_1.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(44, 195, 157, 46);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sex:");
		lblNewLabel_1_2.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(44, 251, 123, 46);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Birth Date");
		lblNewLabel_1_3.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_3.setBounds(44, 307, 123, 46);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Phone:");
		lblNewLabel_1_4.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_4.setBounds(44, 363, 123, 46);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Address:");
		lblNewLabel_1_5.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_5.setBounds(44, 419, 123, 46);
		contentPane.add(lblNewLabel_1_5);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!verify())
				{
					return;
				}
				String n = name.getText();
				String reg1 = reg.getText();
				String phn = phone.getText();
				String addr = address.getText();
				String sex = "M";
				if (rdbtnFemale.isSelected()) {
					sex = "F";
				}
				if (rdbtnOthers.isSelected()) {
					sex = "O";
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String bdate = dateFormat.format(dateChooser.getDate());
				
				Student.insertUpdateDeleteStudent('i', null, n, reg1, sex, bdate, phn, addr);
				AddStudentForm.this.dispose();
			}
		});
		btnNewButton.setBackground(new Color(245, 245, 220));
		btnNewButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnNewButton.setBounds(336, 530, 189, 70);
		contentPane.add(btnNewButton);
		
		name = new JTextField();
		name.setForeground(new Color(240, 128, 128));
		name.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		name.setBounds(122, 150, 386, 35);
		contentPane.add(name);
		name.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		rdbtnNewRadioButton.setBounds(122, 268, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 19));
		rdbtnFemale.setBounds(237, 268, 103, 21);
		contentPane.add(rdbtnFemale);
		
		rdbtnOthers = new JRadioButton("Others");
		buttonGroup.add(rdbtnOthers);
		rdbtnOthers.setFont(new Font("Tahoma", Font.BOLD, 19));
		rdbtnOthers.setBounds(366, 268, 103, 21);
		contentPane.add(rdbtnOthers);
		
		address = new JTextArea();
		address.setForeground(new Color(178, 34, 34));
		address.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 23));
		address.setBounds(140, 419, 368, 90);
		contentPane.add(address);
		
		reg = new JTextField();
		reg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		reg.setForeground(new Color(240, 128, 128));
		reg.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		reg.setColumns(10);
		reg.setBounds(211, 206, 344, 35);
		contentPane.add(reg);
		
		phone = new JTextField();
		phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		phone.setForeground(new Color(240, 128, 128));
		phone.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		phone.setColumns(10);
		phone.setBounds(135, 369, 344, 35);
		contentPane.add(phone);
		
		JButton btnExit = new JButton("Cancel");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentForm.this.dispose();
			}
		});
		btnExit.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnExit.setBackground(new Color(245, 245, 220));
		btnExit.setBounds(55, 530, 189, 70);
		contentPane.add(btnExit);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(161, 307, 348, 46);
		contentPane.add(dateChooser);
	}
}
