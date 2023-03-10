package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ?"
					+ "WHERE "
					+ "(DepartmentId = ?)");
			
			st.setDouble(1, 459.0);
			st.setInt(2, 1);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Linhas afetadas: " + rowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}
