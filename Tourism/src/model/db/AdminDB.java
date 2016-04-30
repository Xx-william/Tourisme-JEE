package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDB {
	private static String GET_ADMIN = "SELECT * FROM admin WHERE admin_pass = ?";

	public static boolean checkAdmin(String password) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_ADMIN);
			stmt.setString(1, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.dropConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
