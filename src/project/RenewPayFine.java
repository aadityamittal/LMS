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
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class RenewPayFine extends JFrame {

	private JPanel contentPane;
	private JTextField studentId;
	private JTextField bookId;
	private JTable table;
	String des;
	JDateChooser issueDateChooser;
	JDateChooser todayDateChooser;
	private JTextField searchTexttt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RenewPayFine frame = new RenewPayFine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void hideColumns(int colNo)
	{
		TableColumn column = table.getColumnModel().getColumn(colNo);
		column.setMaxWidth(0);
		column.setMinWidth(0);
		column.setPreferredWidth(0);
	}
	public boolean validDate(long difference_In_Days)
	{
		if (difference_In_Days>15) {
			
			JOptionPane.showMessageDialog(null, "Pay your fine first");
			return false;
		}
		else if (difference_In_Days<0) {
			JOptionPane.showMessageDialog(null, "Enter valid date");
			return false;
		}
		return true;
	}
	public boolean verify()
	{
		 
		
		if(studentId.getText().equals("")||bookId.getText().equals("")||issueDateChooser.getDate()==null||todayDateChooser.getDate() == null)
		{
			JOptionPane.showMessageDialog(null, "Insert good data");
			return false;
		}
		return true;
	}

	/**
	 * Create the frame.
	 */
	public RenewPayFine() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setTitle("Return/Renew");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(255, 235, 205));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Renew / Pay Fine");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(106, 90, 205));
		lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(10, 10, 1281, 80);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID : ");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 125, 162, 54);
		contentPane_1.add(lblNewLabel_1);
		
		studentId = new JTextField();
		studentId.setEditable(false);
		studentId.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		studentId.setColumns(10);
		studentId.setBounds(174, 128, 348, 54);
		contentPane_1.add(studentId);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Id :");
		lblNewLabel_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(10, 208, 142, 54);
		contentPane_1.add(lblNewLabel_1_1);
		
		bookId = new JTextField();
		bookId.setEditable(false);
		bookId.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		bookId.setColumns(10);
		bookId.setBounds(179, 217, 346, 54);
		contentPane_1.add(bookId);
		
		JButton btnNewButton = new JButton("Borrow");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowBook brBook = new BorrowBook();
				brBook.setVisible(true);
				RenewPayFine.this.dispose();
			}
		});
		btnNewButton.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnNewButton.setBackground(new Color(245, 245, 220));
		btnNewButton.setBounds(391, 468, 162, 43);
		contentPane_1.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Issue Date :");
		lblNewLabel_1_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(10, 295, 173, 54);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		issueDateChooser = new JDateChooser();
		issueDateChooser.setBounds(181, 306, 344, 43);
		contentPane_1.add(issueDateChooser);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Today Date :");
		lblNewLabel_1_1_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_1_1_1.setBounds(10, 389, 173, 54);
		contentPane_1.add(lblNewLabel_1_1_1_1);
		
		todayDateChooser = new JDateChooser();
		todayDateChooser.setBounds(181, 389, 344, 43);
		contentPane_1.add(todayDateChooser);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(634, 182, 647, 300);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnReturnBook = new JButton("Return");
		
		btnReturnBook.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnReturnBook.setBackground(new Color(245, 245, 220));
		btnReturnBook.setBounds(10, 468, 162, 43);
		contentPane_1.add(btnReturnBook);
		
		JButton btnRenew = new JButton("Renew");
		btnRenew.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(!verify())
				{
					return;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				 Date d1 = issueDateChooser.getDate();
				 Date d2 = todayDateChooser.getDate();
				 LocalDate ld1 = d1.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
				 LocalDate ld2 = d2.toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate();
				 long difference_In_Days = ChronoUnit.DAYS.between(ld1, ld2);
				 if(!validDate(difference_In_Days))
				 {
					 return;
				 }
				int sid = Integer.parseInt(studentId.getText());
				int bid = Integer.parseInt(bookId.getText());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String bdate = dateFormat.format(todayDateChooser.getDate());
				Borrow.insertUpdateDeleteBook('u', sid, bid, bdate, des);
			}
		});
		btnRenew.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnRenew.setBackground(new Color(245, 245, 220));
		btnRenew.setBounds(198, 468, 162, 43);
		contentPane_1.add(btnRenew);
		
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
		btnSeeAvailaibleStudents.setBackground(new Color(245, 245, 220));
		btnSeeAvailaibleStudents.setBounds(671, 517, 563, 43);
		contentPane_1.add(btnSeeAvailaibleStudents);
		
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
		
		JButton btnFinePaid = new JButton("Fine Paid");
		btnFinePaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!verify())
				{
					return;
				}
				int sid = Integer.parseInt(studentId.getText());
				int bid = Integer.parseInt(bookId.getText());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String bdate = dateFormat.format(todayDateChooser.getDate());
				Borrow.insertUpdateDeleteBook('d', sid, bid, bdate, des);
				studentId.setText("");
			}
		});
		btnFinePaid.setEnabled(false);
		btnFinePaid.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnFinePaid.setBackground(new Color(245, 245, 220));
		btnFinePaid.setBounds(20, 521, 327, 43);
		contentPane_1.add(btnFinePaid);
		
		JLabel fine_paid_lable = new JLabel("");
		fine_paid_lable.setForeground(new Color(128, 0, 0));
		fine_paid_lable.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		fine_paid_lable.setBounds(357, 521, 142, 54);
		contentPane_1.add(fine_paid_lable);
		
		JLabel lblNewLabel_1_2 = new JLabel("Search:");
		lblNewLabel_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(636, 110, 162, 54);
		contentPane_1.add(lblNewLabel_1_2);
		
		searchTexttt = new JTextField();
		searchTexttt.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 27));
		searchTexttt.setColumns(10);
		searchTexttt.setBounds(762, 110, 388, 54);
		contentPane_1.add(searchTexttt);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
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
				
				Student.fillTable(table, searchTexttt.getText());
				hideColumns(3);
				hideColumns(4);
				hideColumns(5);
				hideColumns(6);
				
				table.setRowHeight(40);
				table.setShowGrid(true);
				table.setGridColor(Color.green);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("Images\\magnifying-glass.png"));
		btnNewButton_1.setBounds(1169, 116, 73, 48);
		contentPane_1.add(btnNewButton_1);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnFinePaid.setEnabled(false);
				fine_paid_lable.setText("");
				int rowIndex = table.getSelectedRow();
				studentId.setText(table.getValueAt(rowIndex, 0).toString());
				
				Connection conn = MyConnection.getConnection();
				PreparedStatement ps;
				try {
					ps = conn.prepareStatement("SELECT * FROM `score` WHERE `student_id` = ?");
					ps.setString(1, table.getValueAt(rowIndex, 0).toString());
					ResultSet rs = ps.executeQuery();
					String[] arr = new String[3];
					
					if(rs.next()) {
						arr[0] = String.valueOf(rs.getInt(2));
						arr[1] = rs.getString(3);
						arr[2] = rs.getString(4);
					}
					else {
						arr[0] = "";
						arr[1] = "";
						arr[2] = "";
					}
//					System.out.println(Arrays.toString(arr));
					bookId.setText(arr[0]);
					
					if(arr[1].equals("")) {
//						System.out.println("Present here");
						((JTextField)issueDateChooser.getDateEditor().getUiComponent()).setText("");}
					else {
						Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(arr[1]);
						issueDateChooser.setDate(date);
					}
					des = arr[2];
				} catch (Exception exp) {
					// TODO: handle exception
				}
				
				
			}
		});
		JTextFieldDateEditor editor = (JTextFieldDateEditor) issueDateChooser.getDateEditor();
		editor.setEditable(false);
		
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!verify())
				{
					return;
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				 Date d1 = issueDateChooser.getDate();
				 Date d2 = todayDateChooser.getDate();
				 LocalDate ld1 = d1.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
				 LocalDate ld2 = d2.toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate();
				 long difference_In_Days = ChronoUnit.DAYS.between(ld1, ld2);
				 //Rs 2 fine taken per day
				 long fine = (difference_In_Days-30)*2;
				 if(difference_In_Days>30)
				 {
					 JOptionPane.showMessageDialog(null, "Pay your fine = "+fine);
					 btnFinePaid.setEnabled(true);
					 fine_paid_lable.setText("If fine paid");
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "No Dues");
					 btnFinePaid.setEnabled(true);
					 fine_paid_lable.setText("No dues!");
				}
				 
			}
		});
	}
}
