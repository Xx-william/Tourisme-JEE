package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.MD5;

/**
 * 
 * This class is used to communicate with the DataBase in admin data
 * 
 * @author WANG XI - GAUTHIER Pierre
 */
public class AdminDB {
	private static String GET_ADMIN = "SELECT * FROM admin WHERE admin_pass = ?";

	/**
	 * This method checks if the password is correct
	 * 
	 * @param password
	 *            The password
	 * @return If the password is correct
	 */
	public static boolean checkAdmin(String password) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_ADMIN);
			stmt.setString(1, MD5.getMD5ofStr(password));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
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
