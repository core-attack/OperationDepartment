package print;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Print
 */
@WebServlet("/Print")
public class Print extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Print() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//нужно определить какой документ мы печатаем
		System.out.println("Зашли в print");
		
		//передать все его аттрибуты
		request.setAttribute("enter-to-bank", request.getParameter("enter-to-bank"));
		request.setAttribute("change-off", request.getParameter("change-off"));
		request.setAttribute("number", request.getParameter("number"));
		request.setAttribute("date", request.getParameter("date"));
		request.setAttribute("payment-type", request.getParameter("payment-type"));
		request.setAttribute("sum-hand", request.getParameter("sum-hand"));
		request.setAttribute("sum", request.getParameter("sum"));
		request.setAttribute("payer-inn", request.getParameter("payer-inn"));
		request.setAttribute("payer-kpp", request.getParameter("payer-kpp"));
		request.setAttribute("payer", request.getParameter("payer"));
		request.setAttribute("payer-bank-account", request.getParameter("payer-bank-account"));
		request.setAttribute("payer-bank-bank-account", request.getParameter("payer-bank-bank-account"));
		request.setAttribute("payer-bik", request.getParameter("payer-bik"));
		request.setAttribute("payers-bank", request.getParameter("payers-bank"));
		request.setAttribute("addressee", request.getParameter("addressee"));
		request.setAttribute("addressee-bank-account", request.getParameter("addressee-bank-account"));
		request.setAttribute("addressees-bank-bank-account", request.getParameter("addressees-bank-bank-account"));
		request.setAttribute("addressee-bik", request.getParameter("addressee-bik"));
		request.setAttribute("addressee-bank", request.getParameter("addressee-bank"));
		request.setAttribute("addressee-inn", request.getParameter("addressee-inn"));
		request.setAttribute("addressee-kpp", request.getParameter("addressee-kpp"));
		request.setAttribute("type-pay", request.getParameter("type-pay"));
		request.setAttribute("pay-for", request.getParameter("pay-for"));
		request.setAttribute("code", request.getParameter("code"));
		request.setAttribute("period-pay", request.getParameter("period-pay"));
		request.setAttribute("pay-order", request.getParameter("pay-order"));
		
		request.getRequestDispatcher("/print.jsp").forward(request,
				response);
	}
	
	//создание и печать xls файла
	void print(HttpServletRequest request, HttpServletResponse response){
		
	}

}
