package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Users;

public class UserDB {
	

		private static String ADD_USER = "INSERT INTO USER(user_type,user_count) VALUES(?,?)";
		private static String GET_USER_BY_ID = "SELECT * FROM user WHERE user_id = ?";
		private static String FREFRESH_USER = "UPDATE user SET user_count=? WHERE user_id=?";
		
		public static void refreshUser(int userId,Users user){
			Connection conn = null;
			try{
				conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(FREFRESH_USER);
				stmt.setInt(1,user.getCount());
				stmt.setInt(2, userId);
				stmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					DBUtil.dropConnection(conn);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		public static void addUser(Users user){
			Connection conn = null;
			try{
				conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(ADD_USER);
				stmt.setString(1, user.getType());
				stmt.setInt(2, user.getCount());
				
				stmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					DBUtil.dropConnection(conn);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		public static Users getUser(int userId){
			Connection conn = null;
			Users user = new Users();
			try{
				conn = DBUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(GET_USER_BY_ID);
				stmt.setInt(1, userId);
				ResultSet rs = stmt.executeQuery();				
				if(rs.next()){
					int count = rs.getInt("user_count");
					String type = rs.getString("user_type");
					 user = new Users(type,count);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return user;
		}
	}


