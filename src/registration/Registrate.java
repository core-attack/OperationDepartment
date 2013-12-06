package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет регистрации пользователя в системе
 */
@WebServlet("/registrate")
public class Registrate extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registrate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			addUser(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			addUser(request, response);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * добавляет пользователя в БД
	 * */
	protected void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		authorization.Login.writeSessionInfo(request);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		if (authorization.Login.checkUser(request, response)) {
			try {// 1
				out = response.getWriter();
				try {// 2

					Class.forName("org.gjt.mm.mysql.Driver");
					Connection cn = null;
					try {// 3
						cn = ConnectDataBase.getConnection();
						Statement st = null;
						try {// 4
							st = cn.createStatement();
							ResultSet rs = null;
							try {// 5
								rs = st.executeQuery("select max(c.id) from clients c;");
								int client_id = 1000;
								while (rs.next())
									client_id = rs.getInt(1) + 1;
								System.out.println("client_id = " + client_id);
								rs = null;
								st = null;
								cn.setAutoCommit(false);
								st = cn.createStatement();
								// PreparedStatement ps = null;
								String sql = "INSERT INTO clients(id, firstname, lastname, category_id, phone, passport, email) VALUES("
										+ client_id
										+ ","
										+ "\""
										+ request.getParameter("firstname")
										+ "\","
										+ "\""
										+ request.getParameter("lastname")
										+ "\","
										+ 21
										+ ","
										+ "\""
										+ request.getParameter("phone")
										+ "\","
										+ "\""
										+ request.getParameter("passport").hashCode()
										+ "\","
										+ "\""
										+ request.getParameter("email")
										+ "\");";
								System.out.println(sql);
								st.executeUpdate(sql);
								// ps = cn.prepareStatement(sql);
								// Record.insertClient(ps, client_id,
								// request.getParameter("firstname"),
								// request.getParameter("lastname"), 21,
								// request.getParameter("phone"),
								// request.getParameter("passport"),
								// request.getParameter("email"));
								request.setAttribute("message", "Client added");
								System.out.println("Client added");
								rs = st.executeQuery("select max(id) from users;");
								int id = 1000;
								while (rs.next())
									id = rs.getInt(1);
								System.out.println("id = " + id);
								// ps = null;
								sql = "INSERT INTO users(id, login, password, client_id) VALUES("
										+ (id + 1)
										+ ",\""
										+ request.getParameter("login")
										+ "\",\""
										+ request.getParameter("password").hashCode()
										+ "\"," + client_id + ")";
								System.out.println(sql);
								st.executeUpdate(sql);
								request.setAttribute("message", "User added");
								request.setAttribute("login", request.getParameter("login"));
								request.setAttribute("login", request.getParameter("password").hashCode());
								System.out.println("User added");
								request.getRequestDispatcher(
										"/SuccessRegistrate.jsp").forward(
										request, response);
								cn.commit();
								System.out.println("Transaction complete");

							} catch (SQLException sqle) {
								cn.rollback();
								out.println(sqle.getMessage());

							} finally {// ошибка в 5 try

								if (rs != null)
									rs.close();
								else {
									request.setAttribute("r-error",
											"Ошибка регистрации пользователя");
									request.getRequestDispatcher(
											"/index-error.jsp").forward(
											request, response);
								}

							}
						} finally {// ошибка в 4 try

							if (st != null)
								st.close();
							else
								out.println("Statement не создан");
						}
					} finally {// ошибка в 3 try

						if (cn != null)
							cn.close();
						else
							out.print("Connection не создан");
					}
				} catch (ClassNotFoundException e) {//ошибка во 2 try
					out.println("не могу понять класс");
				}
			} catch (SQLException e) {
			}
			catch (IOException e) {
			}
			finally {// ошибка в 1 try

				if (out != null)
					out.close();
				else
					out.println("PrintWriter не проинициализирован");
			}
		} 
		else {
			
			request.setAttribute("r-error", "User with login ("
								+ request.getParameter("login")
								+ ") and password ("
								+ request.getParameter("password")
								+ ") already exists!");
			System.out.println("User with login ("
					+ request.getParameter("login")
					+ ") and password ("
					+ request.getParameter("password")
					+ ") already exists!");
			//переходим на страницу с ошибкой
			request.getRequestDispatcher("/index-r-error.jsp").forward(request,
					response);
		}
	}

	/**
	 * класс записи клиента в БД
	 * */
	static class Record {
		static void insertClient(PreparedStatement ps, int id,
				String firstname, String lastname, int category_id,
				String phone, String passport, String email)
				throws SQLException {
			System.out.println(id);
			ps.setInt(1, id);
			System.out.println(firstname);
			ps.setString(2, firstname);
			System.out.println(lastname);
			ps.setString(3, lastname);
			System.out.println(category_id);
			ps.setInt(4, category_id);
			System.out.println(phone);
			ps.setString(5, phone);
			System.out.println(passport);
			ps.setString(6, passport);
			System.out.println("null");
			ps.setDate(7, null);
			System.out.println(email);
			ps.setString(8, email);
			try {
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Success!");
		}

		/**
		 * метод добавлят данные о пользователе в подготовленный запрос
		 * */
		static void insertUser(PreparedStatement ps, int id, String login,
				String password, int client_id) throws SQLException {
			System.out.println(id);
			ps.setInt(1, id);
			System.out.println(login);
			ps.setString(2, login);
			System.out.println(password);
			ps.setString(2, password);
			System.out.println(client_id);
			ps.setInt(1, client_id);
			ps.executeUpdate();
			System.out.println("Success!");
		}
	}

}
