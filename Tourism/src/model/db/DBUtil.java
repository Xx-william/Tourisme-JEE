
package model.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * This class is a tool to connect the dataBase
 * @author WANG XI  - GAUTHIER Pierre 
 *
 */
public class DBUtil {

	private static DataSource ds;

	private static DataSource getDataSource() throws NamingException {

		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/tourism");
		return ds;

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
		return getDataSource().getConnection();
	}

	public static void dropConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

}
