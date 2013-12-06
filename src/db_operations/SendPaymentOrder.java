package db_operations;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sendPaymentOrder
 */
@WebServlet("/SendPaymentOrder")
public class SendPaymentOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendPaymentOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authorization.Login.writeSessionInfo(request);
		//нужно определить какой документ мы печатаем
		System.out.println(request.getParameter("login") + " сохраняет платежное требование в БД");
		request.setAttribute("login", request.getParameter("login"));
		
		//передать все его аттрибуты
		request.getSession().setAttribute("message", "Платежное поручение сохранено в базу данных");
		request.getRequestDispatcher("/report.jsp").forward(request,
				response);
	}
	

}
