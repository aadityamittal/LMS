package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm extends JFrame {

	private JPanel contentPane;
	public static JLabel userLabel;
	public static JLabel studentCount;
	public static JLabel bookCount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setFont(new Font("Lucida Console", Font.BOLD, 12));
		setTitle("Main Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 559);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.YELLOW);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Student");
		mnNewMenu.setIcon(new ImageIcon("Images\\graduated.png"));
		mnNewMenu.setForeground(Color.CYAN);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 24));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentForm studentForm = new AddStudentForm();
				studentForm.setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("Images\\add.png"));
		mntmNewMenuItem.setBackground(Color.PINK);
		mntmNewMenuItem.setForeground(Color.MAGENTA);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Discover");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiscoverStudent dStudent = new DiscoverStudent();
				dStudent.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("Images\\magnifying-glass.png"));
		mntmNewMenuItem_1.setBackground(Color.PINK);
		mntmNewMenuItem_1.setForeground(Color.MAGENTA);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnBooks = new JMenu("Books");
		mnBooks.setIcon(new ImageIcon("Images\\open-book.png"));
		mnBooks.setForeground(Color.CYAN);
		mnBooks.setFont(new Font("Segoe UI", Font.BOLD, 24));
		menuBar.add(mnBooks);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookForm bookish = new AddBookForm();
				bookish.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon("Images\\add.png"));
		mntmNewMenuItem_2.setBackground(Color.PINK);
		mntmNewMenuItem_2.setForeground(Color.MAGENTA);
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnBooks.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Discover");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiscoverBooks book = new DiscoverBooks();
				book.setVisible(true);
			}
		});
		mntmNewMenuItem_1_1.setIcon(new ImageIcon("Images\\magnifying-glass.png"));
		mntmNewMenuItem_1_1.setBackground(Color.PINK);
		mntmNewMenuItem_1_1.setForeground(Color.MAGENTA);
		mntmNewMenuItem_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mnBooks.add(mntmNewMenuItem_1_1);
		
		JMenu mnBorrowBooks = new JMenu("Borrow Books");
		mnBorrowBooks.setIcon(new ImageIcon("Images\\inspiration.png"));
		mnBorrowBooks.setForeground(Color.CYAN);
		mnBorrowBooks.setFont(new Font("Segoe UI", Font.BOLD, 24));
		menuBar.add(mnBorrowBooks);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Borrow");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowBook objBorrowBook = new BorrowBook();
				objBorrowBook.setVisible(true);
			}
		});
		mntmNewMenuItem_2_1.setIcon(new ImageIcon("Images\\book (1).png"));
		mntmNewMenuItem_2_1.setForeground(Color.MAGENTA);
		mntmNewMenuItem_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmNewMenuItem_2_1.setBackground(Color.PINK);
		mnBorrowBooks.add(mntmNewMenuItem_2_1);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Renew/Return/PayFine");
		mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RenewPayFine obRenewPayFine = new RenewPayFine();
				obRenewPayFine.setVisible(true);
			}
		});
		mntmNewMenuItem_1_1_1.setIcon(new ImageIcon("Images\\exchange.png"));
		mntmNewMenuItem_1_1_1.setForeground(Color.MAGENTA);
		mntmNewMenuItem_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		mntmNewMenuItem_1_1_1.setBackground(Color.PINK);
		mnBorrowBooks.add(mntmNewMenuItem_1_1_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userLabel = new JLabel("Welcome <#####>");
		userLabel.setIcon(new ImageIcon("Images\\library (1).png"));
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setForeground(Color.ORANGE);
		userLabel.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 35));
		userLabel.setBounds(10, 10, 884, 82);
		contentPane.add(userLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(10, 159, 348, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		studentCount = new JLabel("Student's count = ");
		studentCount.setForeground(new Color(255, 255, 255));
		studentCount.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 38));
		studentCount.setBounds(20, 27, 318, 105);
		panel.add(studentCount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 139));
		panel_1.setBounds(546, 159, 348, 155);
		contentPane.add(panel_1);
		
		bookCount = new JLabel("Book's count = ");
		bookCount.setForeground(Color.WHITE);
		bookCount.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 38));
		bookCount.setBounds(20, 23, 318, 105);
		panel_1.add(bookCount);
	}
}
