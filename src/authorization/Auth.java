package authorization;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import classes.*;

import registration.ConnectDataBase;
/**
 * 
 * */
public class Auth {
	/**
	 * 
	 * */
	//User user;
	/**
	 * 
	 * */
	public Auth(){}
	/**
	 * 
	 * */
	public Auth(String login, String pass) throws SQLException {
		login(login, pass);
	}
	
	/***/
	public HashMap<String, String> user = new HashMap<String, String>();
	/***/
	public boolean login(String login, String pass) throws SQLException {
		boolean success = false;
		Connection con = null;
		try {
			con = ConnectDataBase.getConnection();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = null;
			try {
				
				System.out.println("Check the user login and password...");
				rs = st.executeQuery("select * from users u " +
						"where u.login = \"" + login + "\" " +
						"and u.password = \"" + pass + "\"");
				System.out.println("наш логин: " + login);
				System.out.println("наш логин: " + pass);
				System.out.println(rs);
				while (rs.next()) {
					System.out.println("найденный логин: " + rs.getString(2));
					user.put("id", String.valueOf(rs.getInt(1)));
					System.out.println("найденный пароль: " + rs.getString(3));
					user.put("login", rs.getString(2));
					user.put("password", rs.getString(3));
					success = true;
					System.out.println("id = " + user.get("id"));
					System.out.println("login = " + user.get("login"));
					System.out.println("password = " + user.get("password"));
				}
			} catch (SQLException sqle) {
				System.out.println("SQL exception: " + sqle.getMessage() + "\n"
						+ sqle.getStackTrace().toString());
			} finally {
				if (rs != null)
					rs.close();
				else
					System.out.print("Error connection to database");
			}
		} finally {
			if (st != null)
				st.close();
			else
				System.out.print("Statement is not create");
		}
		return success;
	}
}
