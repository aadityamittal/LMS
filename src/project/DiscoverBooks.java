package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class DiscoverBooks extends JFrame {

	private JPanel contentPane;
	private JTextField bookName;
	private JTextField bookNum;
	private JTable table;
	private JTextField id;
	private JTextField searchText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiscoverBooks frame = new DiscoverBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean verify()
	{
		if (bookName.getText().equals("")||bookNum.getText().equals("")) {
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
	public DiscoverBooks() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setTitle("Discover Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.WHITE);
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblDiscoverBook = new JLabel("Discover Book");
		lblDiscoverBook.setIcon(new ImageIcon("Images\\symbols.png"));
		lblDiscoverBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscoverBook.setForeground(new Color(106, 90, 205));
		lblDiscoverBook.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 30));
		lblDiscoverBook.setBounds(0, 42, 1286, 80);
		contentPane_1.add(lblDiscoverBook);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name:");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 182, 162, 54);
		contentPane_1.add(lblNewLabel_1);
		
		bookName = new JTextField();
		bookName.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		bookName.setColumns(10);
		bookName.setBounds(164, 184, 348, 54);
		contentPane_1.add(bookName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book No:");
		lblNewLabel_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(10, 295, 142, 54);
		contentPane_1.add(lblNewLabel_1_1);
		
		bookNum = new JTextField();
		bookNum.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		bookNum.setColumns(10);
		bookNum.setBounds(164, 297, 348, 54);
		contentPane_1.add(bookNum);
		
		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!verify())
				{
					return;
				}
				String n = bookName.getText();
				String reg1 = bookNum.getText();
				
				int id987 = Integer.parseInt(id.getText());
				
				
				Book.insertUpdateDeleteBook('d', id987, n, reg1);
				//MainForm.bookCount.setText("Book's count = "+MyFunction.countData("course"));
				id.setText("");
				bookName.setText("");
				bookNum.setText("");
				
				
				DefaultTableModel tableModel123 = new DefaultTableModel();
			    tableModel123.addColumn("ID");
			    tableModel123.addColumn("Book Label");
			    tableModel123.addColumn("Book Number");
			    table.setModel(tableModel123);
				
				Book.fillTable(table, "");
			}
		});
		btnCancel.setIcon(new ImageIcon("Images\\rubbish-bin.png"));
		btnCancel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(10, 436, 148, 47);
		contentPane_1.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(637, 164, 567, 330);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				id.setText(model.getValueAt(rowIndex, 0).toString());
				bookName.setText(model.getValueAt(rowIndex, 1).toString());
				bookNum.setText(model.getValueAt(rowIndex, 2).toString());
			}
		});
		table.setRowHeight(40);
		table.setShowGrid(true);
		table.setGridColor(Color.red);
		
		JButton btnShowAvailableBooks = new JButton("Show Available books");
		btnShowAvailableBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = MyConnection.getConnection();
				try {
				PreparedStatement ps = conn.prepareStatement("Select * from course");
				ResultSet rs = ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch (Exception exc) {
					System.out.println(exc);
				}
			}
		});
		btnShowAvailableBooks.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnShowAvailableBooks.setBackground(new Color(245, 245, 220));
		btnShowAvailableBooks.setBounds(676, 504, 507, 70);
		contentPane_1.add(btnShowAvailableBooks);
		
		JButton btnCancel_1 = new JButton("");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!verify())
				{
					return;
				}
				String n = bookName.getText();
				String reg1 = bookNum.getText();
				
				int id987 = Integer.parseInt(id.getText());
				Book.insertUpdateDeleteBook('u', id987, n, reg1);
				
				DefaultTableModel tableModel123 = new DefaultTableModel();
			    tableModel123.addColumn("ID");
			    tableModel123.addColumn("Book Name");
			    tableModel123.addColumn("Book Number");
			    table.setModel(tableModel123);
				
				Book.fillTable(table, "");}
		});
		btnCancel_1.setIcon(new ImageIcon("Images\\reload.png"));
		btnCancel_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnCancel_1.setBackground(Color.WHITE);
		btnCancel_1.setBounds(192, 436, 142, 47);
		contentPane_1.add(btnCancel_1);
		
		JButton btnCancel_1_1 = new JButton("");
		btnCancel_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookForm asf = new AddBookForm();
				asf.setVisible(true);
				
			}
		});
		btnCancel_1_1.setIcon(new ImageIcon("Images\\add.png"));
		btnCancel_1_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnCancel_1_1.setBackground(Color.WHITE);
		btnCancel_1_1.setBounds(359, 436, 142, 47);
		contentPane_1.add(btnCancel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID:");
		lblNewLabel_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(34, 126, 84, 54);
		contentPane_1.add(lblNewLabel_1_2);
		
		id = new JTextField();
		id.setEditable(false);
		id.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		id.setColumns(10);
		id.setBounds(98, 130, 84, 42);
		contentPane_1.add(id);
		
		JLabel lblNewLabel_1_3 = new JLabel("Search:");
		lblNewLabel_1_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_3.setBounds(652, 107, 162, 54);
		contentPane_1.add(lblNewLabel_1_3);
		
		searchText = new JTextField();
		searchText.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		searchText.setColumns(10);
		searchText.setBounds(757, 107, 348, 54);
		contentPane_1.add(searchText);
		
		JButton btnCancel_1_1_1 = new JButton("");
		btnCancel_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel123 = new DefaultTableModel();
			    tableModel123.addColumn("ID");
			    tableModel123.addColumn("Book Label");
			    tableModel123.addColumn("Book Number");
			    table.setModel(tableModel123);
				
				Book.fillTable(table, searchText.getText());
			}
		});
		btnCancel_1_1_1.setIcon(new ImageIcon("Images\\magnifying-glass.png"));
		btnCancel_1_1_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnCancel_1_1_1.setBackground(Color.WHITE);
		btnCancel_1_1_1.setBounds(1122, 107, 142, 47);
		contentPane_1.add(btnCancel_1_1_1);
	}
}
