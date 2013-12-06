package authorization;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registration.ConnectDataBase;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import authorization.Auth;

/**
 * 
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	public Login() {
		super();
	}

	public static void writeSessionInfo(HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("id"));
		System.out.println(request.getSession().getAttribute("login"));
		System.out.println(request.getSession().getAttribute("password"));
		request.setAttribute("id", request.getSession().getAttribute("id"));
		request.setAttribute("login", request.getSession().getAttribute("login"));
		request.setAttribute("password", request.getSession().getAttribute("password"));
	}

	/**
	 * authenticate users
	 * */
	public static void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.write(request.getRequestURI());
		try {
			Auth au = new Auth();
			System.out.println("Login attempt...");
			if (request.getParameter("login") != null) {
				System.out.println("Login: " + request.getParameter("login"));
				System.out.println("Password hash: " + String.valueOf(request.getParameter("password")
								.hashCode()));
				if (au.login(request.getParameter("login"), String
						.valueOf(request.getParameter("password").hashCode()))) {
					System.out.println("Success");
					request.setAttribute("id",
							Integer.valueOf(au.user.get("id")));
					request.setAttribute("login", au.user.get("login"));
					request.setAttribute("password", au.user.get("password"));
					request.setAttribute("error", "");
					request.getSession().setAttribute("valid", null);
					request.getSession().setAttribute("user", au.user);
					request.getSession().setAttribute("id",	request.getSession().getId());
					request.getSession().setAttribute("login",
							au.user.get("login"));
					request.getSession().setAttribute("password",
							au.user.get("password"));
					request.getSession().setAttribute(
							"client",
							au.user.get("firstname") + " "
									+ au.user.get("lastname"));
					request.setAttribute("id", request.getSession().getId());
					request.setAttribute("login", request.getSession().getAttribute("login"));
					request.setAttribute("password", request.getSession().getAttribute("password"));
					request.getRequestDispatcher("/main.jsp").forward(request,
							response);
				}
				else
				{
					System.out.println("Доступ запрещен!");
					authorization.Login.writeSessionInfo(request);
					request.setAttribute("login", request.getParameter("login"));
					request.setAttribute("password", request.getParameter("password"));
					request.setAttribute("error", "Неправильный логин или пароль!");
					request.getRequestDispatcher("/index-error.jsp").forward(
							request, response);
				}

			} else {
				System.out.println("Доступ запрещен!");
				authorization.Login.writeSessionInfo(request);
				request.setAttribute("login", request.getParameter("login"));
				request.setAttribute("password", request.getParameter("password"));
				request.setAttribute("error", "Введите логин!");
				request.getRequestDispatcher("/index-error.jsp").forward(
						request, response);

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * do post
	 * */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		login(request, response);
	}

	/**
	 * do get
	 * */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doPost(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * checking users login and password of existing in system
	 * */
	public static boolean checkUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean success = false;
		Connection con = null;
		try {
			con = ConnectDataBase.getConnection();

			Statement st = null;
			try {
				st = con.createStatement();
				ResultSet rs = null;
				try {
					rs = st.executeQuery("select count(id) from users u "
							+ "where u.login = \""
							+ request.getParameter("login") + "\" "
							+ "and u.password = \""
							+ request.getParameter("password") + "\"");
					int count = -1;
					while (rs.next())
						count = rs.getInt(1);

					if (count == 0) {
						success = true;
						System.out.println("User with login ("
								+ request.getParameter("login")
								+ ") and password ("
								+ request.getParameter("password")
								+ ") is no exist in system.");
					} else {
						success = false;
						System.out.println("User with login ("
								+ request.getParameter("login")
								+ ") and password ("
								+ request.getParameter("password")
								+ ") is already exist in system.");
					}

				} catch (SQLException sqle) {
					System.out.println("SQL exception: " + sqle.getMessage()
							+ "\n" + sqle.getStackTrace().toString());
				} finally {
					if (rs != null)
						rs.close();
					else
						System.out.print("error connecting to database");
				}
			} finally {
				if (st != null)
					st.close();
				else
					System.out.print("Statement not create");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return success;
	}

}
