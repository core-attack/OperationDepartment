package authorization;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет перенаправления при утере пароля
 */
@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forgot(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forgot(request, response);
	}
	/**
	 * перенаправление на страницу восстановления пароля
	 * */
	void forgot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("rerouting...");
		response.setCharacterEncoding("UTF-8");
		System.out.println("login:" + request.getSession().getAttribute("login"));
		request.setAttribute("login", request.getSession().getAttribute("login"));
		request.getRequestDispatcher("/forgot.jsp").forward(
				request, response);
	}
	
}
