package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class MainFrameStudent extends JFrame {

	private JPanel contentPane;
	public static JLabel userLabel,studentCount,bookCount;
	public static JTextField registNo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameStudent frame = new MainFrameStudent();
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
	public MainFrameStudent() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setTitle("Welcome Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 651);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.ORANGE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Student Details");
		mnNewMenu.setIcon(new ImageIcon("Images\\graduated.png"));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		mnNewMenu.setBackground(Color.YELLOW);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("See Details");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeStudentDetails ssd  = new SeeStudentDetails();
				ssd.setVisible(true);
				SeeStudentDetails.regNotextField.setText(registNo.getText());
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("Images\\binocular.png"));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mntmNewMenuItem.setBackground(Color.MAGENTA);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnBorrowDetails = new JMenu("Borrow Details");
		mnBorrowDetails.setIcon(new ImageIcon("Images\\inspiration.png"));
		mnBorrowDetails.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		mnBorrowDetails.setBackground(Color.YELLOW);
		menuBar.add(mnBorrowDetails);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("See Details");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BorrowDetails borrowDetails = new BorrowDetails();
				borrowDetails.setVisible(true);
				borrowDetails.registTextField.setText(registNo.getText());
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("Images\\binocular.png"));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mntmNewMenuItem_1.setBackground(Color.MAGENTA);
		mnBorrowDetails.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBounds(0, 0, 924, 584);
		contentPane.add(contentPane_1);
		
		userLabel = new JLabel("Welcome <#####>");
		userLabel.setIcon(new ImageIcon("Images\\library (1).png"));
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setForeground(Color.ORANGE);
		userLabel.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 35));
		userLabel.setBounds(10, 10, 884, 82);
		contentPane_1.add(userLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(10, 159, 348, 155);
		contentPane_1.add(panel);
		
		studentCount = new JLabel("Student's count = ");
		studentCount.setForeground(Color.WHITE);
		studentCount.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 38));
		studentCount.setBounds(20, 27, 318, 105);
		panel.add(studentCount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 139));
		panel_1.setBounds(546, 159, 348, 155);
		contentPane_1.add(panel_1);
		
		bookCount = new JLabel("Book's count = ");
		bookCount.setForeground(Color.WHITE);
		bookCount.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 38));
		bookCount.setBounds(20, 23, 318, 105);
		panel_1.add(bookCount);
		
		registNo = new JTextField();
		registNo.setEditable(false);
		registNo.setBounds(10, 544, 294, 19);
		contentPane_1.add(registNo);
		registNo.setColumns(10);
	}
}
