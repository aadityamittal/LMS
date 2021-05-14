package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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

public class BorrowBook extends JFrame {

	private JPanel contentPane;
	private JTextField studentId;
	private JTable table;
	private JTextField searchText;
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowBook frame = new BorrowBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public boolean verify()
	{
		if (studentId.getText().equals("")||dateChooser.getDate()==null) {
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
	private void hideColumns(int colNo)
	{
		TableColumn column = table.getColumnModel().getColumn(colNo);
		column.setMaxWidth(0);
		column.setMinWidth(0);
		column.setPreferredWidth(0);
	}

	/**
	 * Create the frame.
	 */
	public BorrowBook() {
		setResizable(false);
		setTitle("Borrow Books");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1333, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.WHITE);
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblBorrowBooks = new JLabel("Borrow Books");
		lblBorrowBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrowBooks.setForeground(new Color(106, 90, 205));
		lblBorrowBooks.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 30));
		lblBorrowBooks.setBounds(0, 42, 1299, 80);
		contentPane_1.add(lblBorrowBooks);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID :");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 132, 162, 54);
		contentPane_1.add(lblNewLabel_1);
		
		studentId = new JTextField();
		studentId.setEditable(false);
		studentId.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		studentId.setColumns(10);
		studentId.setBounds(182, 132, 348, 54);
		contentPane_1.add(studentId);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book ID :");
		lblNewLabel_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(10, 218, 142, 54);
		contentPane_1.add(lblNewLabel_1_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!verify() || Borrow.isStudentExist(studentId.getText()))
				{
					return;
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = dateFormat.format(dateChooser.getDate());
				Integer studentIdInt = Integer.parseInt(studentId.getText());
				String descrip = comboBox.getSelectedItem().toString();
				int crsId = Book.getBookId(descrip);
				
				Borrow.insertUpdateDeleteBook('i', studentIdInt, crsId, date, descrip);
						
			}
		});
		btnSubmit.setIcon(new ImageIcon("Images\\submit.png"));
		btnSubmit.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(313, 413, 189, 70);
		contentPane_1.add(btnSubmit);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowBook.this.dispose();
			}
		});
		btnCancel_1.setIcon(new ImageIcon("Images\\cancel.png"));
		btnCancel_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnCancel_1.setBackground(Color.WHITE);
		btnCancel_1.setBounds(33, 413, 189, 70);
		contentPane_1.add(btnCancel_1);
		
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date :");
		lblNewLabel_1_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(10, 304, 142, 54);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(182, 304, 348, 54);
		contentPane_1.add(dateChooser);
		dateChooser.setDate(new Date());
		
		comboBox = new JComboBox();
		comboBox.setBounds(182, 229, 348, 54);
		contentPane_1.add(comboBox);
		
		Book.fillComboBox(comboBox);
		
		JButton btnSeeAvailaibleStudents = new JButton("See Availaible Students");
		btnSeeAvailaibleStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = MyConnection.getConnection();
				try {
				PreparedStatement ps = conn.prepareStatement("Select * from student");
				ResultSet rs = ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch (Exception exc) {
					System.out.println(exc);
				}
			}
		});
		btnSeeAvailaibleStudents.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnSeeAvailaibleStudents.setBackground(Color.WHITE);
		btnSeeAvailaibleStudents.setBounds(710, 498, 555, 47);
		contentPane_1.add(btnSeeAvailaibleStudents);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(686, 175, 586, 308);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				studentId.setText(table.getValueAt(rowIndex, 0).toString());
			}
		});
		
		JLabel lblNewLabel_1_2 = new JLabel("Search :");
		lblNewLabel_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(667, 111, 162, 54);
		contentPane_1.add(lblNewLabel_1_2);
		
		searchText = new JTextField();
		searchText.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		searchText.setColumns(10);
		searchText.setBounds(784, 111, 348, 54);
		contentPane_1.add(searchText);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel123 = new DefaultTableModel();
			    tableModel123.addColumn("ID");
			    tableModel123.addColumn("Name");
			    tableModel123.addColumn("Reg No");
			    tableModel123.addColumn("Sex");
			    tableModel123.addColumn("DOB");
			    tableModel123.addColumn("Phone");
			    tableModel123.addColumn("Address");
			    table.setModel(tableModel123);
				
				Student.fillTable(table, searchText.getText());
			}
		});
		btnNewButton.setIcon(new ImageIcon("Images\\magnifying-glass.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(1181, 111, 63, 42);
		contentPane_1.add(btnNewButton);
		
		DefaultTableModel tableModel123 = new DefaultTableModel();
	    tableModel123.addColumn("ID");
	    tableModel123.addColumn("Name");
	    tableModel123.addColumn("Reg No");
	    tableModel123.addColumn("Sex");
	    tableModel123.addColumn("DOB");
	    tableModel123.addColumn("Phone");
	    tableModel123.addColumn("Address");
	    table.setModel(tableModel123);
		
		Student.fillTable(table, "");
		hideColumns(3);
		hideColumns(4);
		hideColumns(5);
		hideColumns(6);
		
		table.setRowHeight(40);
		table.setShowGrid(true);
		table.setGridColor(Color.green);
	}
}
