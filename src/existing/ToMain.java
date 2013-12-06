package existing;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToMain
 */
@WebServlet("/ToMain")
public class ToMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToMain() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authorization.Login.writeSessionInfo(request);
		request.getRequestDispatcher("/main.jsp").forward(request,
				response);
	}

}
