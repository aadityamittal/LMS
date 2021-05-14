package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DiscoverStudent extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField regNo;
	private JTextField phn;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField searchText;
	public static JButton btnSeeAvailableStudents;
	private JTextField idText;
	private JDateChooser dateChooser;
	private JTextArea address;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiscoverStudent frame = new DiscoverStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean verify()
	{
		if (name.getText().equals("")||regNo.getText().equals("")||phn.getText().equals("")||address.getText().equals("")||dateChooser.getDate()==null||idText.getText().equals("")) {
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
	public DiscoverStudent() {
	  	setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\book.png"));
		setTitle("Discover Students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1325, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.WHITE);
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("   Discover Student's");
		lblNewLabel.setIcon(new ImageIcon("Images\\symbols.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 44));
		lblNewLabel.setBounds(0, 10, 1291, 87);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(new Color(218, 112, 214));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(44, 139, 123, 46);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Registration No:");
		lblNewLabel_1_1.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(44, 195, 157, 46);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sex:");
		lblNewLabel_1_2.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(44, 251, 123, 46);
		contentPane_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Birth Date");
		lblNewLabel_1_3.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_3.setBounds(44, 307, 123, 46);
		contentPane_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Phone:");
		lblNewLabel_1_4.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_4.setBounds(44, 363, 123, 46);
		contentPane_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Address:");
		lblNewLabel_1_5.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_5.setBounds(44, 419, 123, 46);
		contentPane_1.add(lblNewLabel_1_5);
		
		name = new JTextField();
		name.setForeground(new Color(240, 128, 128));
		name.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		name.setColumns(10);
		name.setBounds(122, 150, 386, 35);
		contentPane_1.add(name);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 19));
		rdbtnNewRadioButton.setBounds(122, 268, 103, 21);
		contentPane_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 19));
		rdbtnFemale.setBounds(237, 268, 103, 21);
		contentPane_1.add(rdbtnFemale);
		
		JRadioButton rdbtnOthers = new JRadioButton("Others");
		buttonGroup.add(rdbtnOthers);
		rdbtnOthers.setFont(new Font("Tahoma", Font.BOLD, 19));
		rdbtnOthers.setBounds(366, 268, 103, 21);
		contentPane_1.add(rdbtnOthers);
		
		address = new JTextArea();
		address.setForeground(new Color(178, 34, 34));
		address.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 23));
		address.setBounds(140, 419, 368, 90);
		contentPane_1.add(address);
		
		regNo = new JTextField();
		regNo.setForeground(new Color(240, 128, 128));
		regNo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		regNo.setColumns(10);
		regNo.setBounds(211, 206, 344, 35);
		contentPane_1.add(regNo);
		
		phn = new JTextField();
		phn.setForeground(new Color(240, 128, 128));
		phn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		phn.setColumns(10);
		phn.setBounds(135, 369, 344, 35);
		contentPane_1.add(phn);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!verify())
				{
					return;
				}
				String n = name.getText();
				String reg1 = regNo.getText();
				String phn1 = phn.getText();
				String addr = address.getText();
				String sex = "M";
				int id987 = Integer.parseInt(idText.getText());
				if (rdbtnFemale.isSelected()) {
					sex = "F";
				}
				if (rdbtnOthers.isSelected()) {
					sex = "O";
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String bdate = dateFormat.format(dateChooser.getDate());
				
				Student.insertUpdateDeleteStudent('d', id987, n, reg1, sex, bdate, phn1, addr);
				MainForm.studentCount.setText("Student's count = "+MyFunction.countData("student"));
				name.setText("");
				regNo.setText("");
				phn.setText("");
				address.setText("");
				dateChooser.setDate(null);
				idText.setText("");
				rdbtnNewRadioButton.setSelected(true);
				
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
			}
		});
		btnExit.setIcon(new ImageIcon("Images\\rubbish-bin.png"));
		btnExit.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(10, 511, 189, 35);
		contentPane_1.add(btnExit);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(161, 307, 348, 46);
		contentPane_1.add(dateChooser);
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(680, 187, 611, 329);
		contentPane_1.add(scrollPane);
		
		DefaultTableModel tableModel = new DefaultTableModel();
	    tableModel.addColumn("ID");
	    tableModel.addColumn("Name");
	    tableModel.addColumn("Reg No");
	    tableModel.addColumn("Sex");
	    tableModel.addColumn("DOB");
	    tableModel.addColumn("Phone");
	    tableModel.addColumn("Address");
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				if(model.getValueAt(rowIndex, 3).toString().equals("F"))
					rdbtnFemale.setSelected(true);
				if(model.getValueAt(rowIndex, 3).toString().equals("O"))
					rdbtnOthers.setSelected(true);
				idText.setText(model.getValueAt(rowIndex, 0).toString());
				name.setText(model.getValueAt(rowIndex, 1).toString());
				regNo.setText(model.getValueAt(rowIndex, 2).toString());
				phn.setText(model.getValueAt(rowIndex, 5).toString());
				address.setText(model.getValueAt(rowIndex, 6).toString());
				java.util.Date bdate;
				try {
				bdate =  new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 4).toString());
				dateChooser.setDate(bdate);
				}
				catch (Exception exp) {
					System.out.println(exp);
				}
				
			}
		});
		
		table.setRowHeight(40);
		table.setShowGrid(true);
		table.setGridColor(Color.green);
	
		
		btnSeeAvailableStudents = new JButton("See Available Students");
		btnSeeAvailableStudents.addActionListener(new ActionListener() {
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
		btnSeeAvailableStudents.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnSeeAvailableStudents.setBackground(new Color(245, 245, 220));
		btnSeeAvailableStudents.setBounds(764, 530, 450, 70);
		contentPane_1.add(btnSeeAvailableStudents);
		
		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon("Images\\reload.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!verify())
				{
					return;
				}
				String n = name.getText();
				String reg1 = regNo.getText();
				String phn1 = phn.getText();
				String addr = address.getText();
				String sex = "M";
				int id987 = Integer.parseInt(idText.getText());
				if (rdbtnFemale.isSelected()) {
					sex = "F";
				}
				if (rdbtnOthers.isSelected()) {
					sex = "O";
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String bdate = dateFormat.format(dateChooser.getDate());
				
				Student.insertUpdateDeleteStudent('u', id987, n, reg1, sex, bdate, phn1, addr);
				
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
			}
		});
		btnUpdate.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(237, 511, 189, 35);
		contentPane_1.add(btnUpdate);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon("Images\\add.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentForm asf = new AddStudentForm();
				asf.setVisible(true);
				
			}
		});
		btnAdd.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 28));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(458, 511, 189, 35);
		contentPane_1.add(btnAdd);
		
		searchText = new JTextField();
		searchText.setForeground(new Color(240, 128, 128));
		searchText.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		searchText.setColumns(10);
		searchText.setBounds(744, 128, 386, 35);
		contentPane_1.add(searchText);
		
		JLabel lblNewLabel_1_6 = new JLabel("Search:");
		lblNewLabel_1_6.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_6.setBounds(667, 122, 123, 46);
		contentPane_1.add(lblNewLabel_1_6);
		
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
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("Images//magnifying-glass.png"));
		btnNewButton.setBounds(1155, 128, 85, 32);
		contentPane_1.add(btnNewButton);
		
		JLabel lblNewLabel_1_7 = new JLabel("Id:");
		lblNewLabel_1_7.setForeground(new Color(218, 112, 214));
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_7.setBounds(44, 88, 123, 46);
		contentPane_1.add(lblNewLabel_1_7);
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setForeground(new Color(240, 128, 128));
		idText.setFont(new Font("Tempus Sans ITC", Font.BOLD, 23));
		idText.setColumns(10);
		idText.setBounds(104, 94, 67, 35);
		contentPane_1.add(idText);
	}
}
