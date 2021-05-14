package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Book {
	public static void insertUpdateDeleteBook(char operation,Integer id,String name,String reg)
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		//i for insert
		if (operation == 'i') {
			try {
				ps = con.prepareStatement("INSERT INTO course(label, book_number) VALUES (?,?)");
				ps.setString(1, name);
				ps.setString(2, reg);
				
				if (ps.executeUpdate()>0) {
					MainForm.bookCount.setText("Book's count = "+MyFunction.countData("course"));
					JOptionPane.showMessageDialog(null, "Data successfully inserted");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (operation == 'd') {
			try {
				ps = con.prepareStatement("DELETE FROM `course` WHERE `id` = ?");
				ps.setString(1, id.toString());
				if (ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Data successfully deleted");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (operation == 'u') {
			try {
				ps = con.prepareStatement("UPDATE `course` SET `label`=?,`book_number`=? WHERE `id`=?");
				ps.setString(1, name);
				ps.setString(2, reg);
				ps.setString(3, id.toString());
				if (ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Data successfully updated");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static boolean isBookExist(String book)
	{
		Connection conn = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT * FROM `course` WHERE `label` = ?");
			ps.setString(1, book);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Book Already Present");
				return true;}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false ;
	}
	public static void fillTable(JTable table,String valueToSearch) {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM `course` WHERE CONCAT( `id`, `label`, `book_number`) LIKE ?");
			ps.setString(1, "%"+valueToSearch+"%");
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row;
			while (rs.next()) {
				row = new Object[3];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				model.addRow(row);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static int getBookId(String bookLabel)
	{
		int bookId = 0;
		Connection conn = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT * FROM `course` WHERE `label` = ?");
			ps.setString(1, bookLabel);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bookId = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bookId;
	}
	public static void fillComboBox(JComboBox comboBox) {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM `course`");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				comboBox.addItem(rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
