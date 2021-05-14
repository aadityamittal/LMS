package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Borrow {

	public static void insertUpdateDeleteBook(char operation ,Integer sID,Integer cId,String date,String description)
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		//i for insert
		if (operation == 'i') {
			try {
				ps = con.prepareStatement("INSERT INTO `score`(`student_id`, `course_id`, `date_borrowed`, `description`) VALUES (?,?,?,?)");
				ps.setInt(1, sID);
				ps.setInt(2, cId);
				ps.setString(3, date);
				ps.setString(4, description);
				
				if (ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Data successfully inserted");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (operation == 'd') {
			try {
				ps = con.prepareStatement("DELETE FROM `score` WHERE `student_id` = ?");
				ps.setLong(1, sID);
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
				ps = con.prepareStatement("UPDATE `score` SET `course_id`=?,`date_borrowed`=? WHERE `student_id`=?");
				ps.setLong(1, cId);
				ps.setString(2, date);
				ps.setLong(3, sID);
				if (ps.executeUpdate()>0) {
					JOptionPane.showMessageDialog(null, "Data successfully updated");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static boolean isStudentExist(String sId)
	{
		Connection conn = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT * FROM `score` WHERE `student_id` = ?");
			ps.setString(1, sId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Student already borrowed a book");
				return true;}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false ;
	}
}
