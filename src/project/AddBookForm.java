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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

public class AddBookForm extends JFrame {

	private JPanel contentPane;
	private JTextField bookName;
	private JTextField bookNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookForm frame = new AddBookForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public boolean verify()
	{
		if (bookName.getText().equals("")||bookNumber.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Insert in every text box");
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * Create the frame.
	 */
	public AddBookForm() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setTitle("Add Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Book");
		lblNewLabel.setForeground(new Color(106, 90, 205));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(0, 42, 484, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name:");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 182, 162, 54);
		contentPane.add(lblNewLabel_1);
		
		bookName = new JTextField();
		bookName.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		bookName.setBounds(182, 182, 348, 54);
		contentPane.add(bookName);
		bookName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book No:");
		lblNewLabel_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(10, 295, 142, 54);
		contentPane.add(lblNewLabel_1_1);
		
		bookNumber = new JTextField();
		bookNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
					e.consume();
			}
		});
		bookNumber.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		bookNumber.setColumns(10);
		bookNumber.setBounds(138, 295, 392, 54);
		contentPane.add(bookNumber);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!verify() || Book.isBookExist(bookName.getText())) {
					return;
				}
				String bk = bookName.getText();
				String number = bookNumber.getText();
				Book.insertUpdateDeleteBook('i', null, bk, number);
				AddBookForm.this.dispose();
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnNewButton.setBackground(new Color(245, 245, 220));
		btnNewButton.setBounds(313, 413, 189, 70);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookForm.this.dispose();
			}
		});
		btnCancel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnCancel.setBackground(new Color(245, 245, 220));
		btnCancel.setBounds(33, 413, 189, 70);
		contentPane.add(btnCancel);
	}

}
