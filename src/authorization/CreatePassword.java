package authorization;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pool.DBConnectionPool;

import registration.ConnectDataBase;
import classes.*;

/**
 * Сервлет создания нового пароля для пользователя
 */
@WebServlet("/CreatePassword")
public class CreatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		createPassword(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		createPassword(request, response);
	}
	/**
	 * создание нового указанного пользователем пароля
	 * */
	void createPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Enter on changePassword");
		User user = new User();
		Client client;
		String sql = "";
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String passport = request.getParameter("passport");
		String login = String.valueOf(request.getSession()
				.getAttribute("login"));
		String pass = request.getParameter("password");
		Connection con = null;
		PreparedStatement ps = null; 
		DBConnectionPool pool = new DBConnectionPool();
		try {
			try {
				con = pool.getConnection();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			try {
				ResultSet rs = null;
				try {
					sql = "select * from users u, clients c "
							+ "where u.login = \"" + login + "\" "
							+ " and u.client_id = c.id "
							+ " and c.firstname = \"" + fname + "\" "
							+ " and c.lastname = \"" + lname + "\" "
							+ " and c.email = \"" + email + "\" "
							+ " and c.passport = \"" + passport + "\" ";
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					System.out.println(sql);
					System.out.println(rs.next());
					while(rs.next()){
						System.out.println(rs.getInt(1));
						System.out.println(rs.getInt(2));
						System.out.println(rs.getInt(3));
						System.out.println(rs.getInt(4));
						
					}
					if (rs.wasNull()) {
						System.out.println("6");
						request.setAttribute(
								"message",
								"Sorry, we haven't that client: "
										+ String.format(
												"login:%s fname:%s lname:%s email:%s passport:%s ",
												login, fname, lname, email,
												passport));
						System.out
								.println("Sorry, we haven't that client: "
										+ String.format(
												"login:%s fname:%s lname:%s email:%s passport:%s ",
												login, fname, lname, email,
												passport));
					}
					System.out.println("7");
					while (!rs.next()) {
						/*System.out.println("Create client...");
						 client = new Client(rs.getInt(5),
								rs.getInt("category_id"),
								rs.getString("lastname"),
								rs.getString("firstname"),
								rs.getString("phone"),
								rs.getString("passport"),
								rs.getString("born_date"),
								rs.getString("email"));
						System.out.println(client.print());
						System.out.println("Create user...");*/
						user = new User(rs.getInt(1) /* user id */,
								login,
								pass, rs.getInt(1));
						System.out.println(user.print());
						con.setAutoCommit(false);
						
						sql = "UPDATE users SET password=\""
								+ user.getPassword() + "\" WHERE id=\""
								+ user.getId() + "\";";
						System.out.println(sql);
						ps = con.prepareStatement(sql);
						
						con.commit();
						System.out.println("Password changed");
					}
					System.out.println("8");

				} catch (SQLException sqle) {
					System.out.println("SQL exception: " + sqle.getMessage()
							+ "\n" + sqle.getStackTrace().toString());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (rs != null)
						rs.close();
					else
						System.out.print("Ошибка обращения к БД");
				}
			} finally {
				pool.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
