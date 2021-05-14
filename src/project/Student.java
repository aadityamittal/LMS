package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Student {

	public static void insertUpdateDeleteStudent(char operation,Integer id,String name,String reg,String sex,String bdate,String phone,String address)
		{
			Connection con = MyConnection.getConnection();
			PreparedStatement ps;
			
			//i for insert
			if (operation == 'i') {
				try {
					ps = con.prepareStatement("INSERT INTO student(name, Reg_No, sex, birthdate, phone, address) VALUES (?,?,?,?,?,?)");
					ps.setString(1, name);
					ps.setString(2, reg);
					ps.setString(3, sex);
					ps.setString(4, bdate);
					ps.setString(5, phone);
					ps.setString(6, address);
					if (ps.executeUpdate()>0) {
						MainForm.studentCount.setText("Student's count = "+MyFunction.countData("student"));
						JOptionPane.showMessageDialog(null, "Data successfully inserted");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (operation == 'u') {
				try {
					ps = con.prepareStatement("UPDATE `student` SET `name`=?,`Reg_No`=?,`sex`=?,`birthdate`=?,`phone`=?,`address`=? WHERE `id`=?");
					ps.setString(1, name);
					ps.setString(2, reg);
					ps.setString(3, sex);
					ps.setString(4, bdate);
					ps.setString(5, phone);
					ps.setString(6, address);
					ps.setString(7, id.toString());
					if (ps.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null, "Data successfully updated");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (operation == 'd') {
				try {
					ps = con.prepareStatement("DELETE FROM `student` WHERE `id` = ?");
					ps.setString(1, id.toString());
					if (ps.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null, "Data successfully deleted");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	public static void fillTable(JTable table,String valueToSearch) {
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM `student` WHERE CONCAT( `id`, `name`, `Reg_No`, `sex`, `birthdate`, `phone`, `address`) LIKE ?");
			ps.setString(1, "%"+valueToSearch+"%");
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row;
			while (rs.next()) {
				row = new Object[7];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);
				model.addRow(row);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
