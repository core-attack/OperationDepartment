package registration;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Класс соединения с БД
 * */
public class ConnectDataBase {

	/**
	 * обычный конструктор
	 * */
	public ConnectDataBase(){
		
	}

	/**
	 * возврат соединения
	 * */
	public static Connection getConnection() 
			throws SQLException {
				ResourceBundle resource = ResourceBundle.getBundle("database");
				String url = resource.getString("url");
				String driver = resource.getString("driver");
				String user = resource.getString("user");
				String pass = resource.getString("password");
				//System.out.println(url + "\n" + driver  + "\n" + user  + "\n" + pass);
				try {
					Class.forName(driver).newInstance();	
				} catch (ClassNotFoundException e) {
					System.out.println("Ошибка соединения с БД");
					throw new SQLException("SQL Exception!");
				} catch (InstantiationException e) {
					e.printStackTrace();
					System.out.println("Ошибка соединения с БД");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					System.out.println("Ошибка соединения с БД");
				}
			return DriverManager.getConnection(url, user, pass);
			}

}
