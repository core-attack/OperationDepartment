package documents;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registration.ConnectDataBase;



import classes.Document;

/**
 * Servlet implementation class Read
 */
@WebServlet("/Read")
public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args){
		
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Read() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*Document doc = new Document(getNextDocumentId(), 
				request.getAttribute("payer-bank-account").toString(), 
				request.getAttribute("number"), 
				request.getAttribute("date"), 
				request.getAttribute("sum"), 
				request.getAttribute("sum-hand"), 
				request.getAttribute("pay-for"), 
				"payment order", 
				request.getAttribute("type-pay"), 
				"Rub", 
				request.getAttribute("addressee-bank-account"),
				request.getAttribute("addressee"), 
				request.getAttribute("addressee-inn"),
				request.getAttribute("addressee-kpp"));*/
		
		
	}
	
	public static int getNextDocumentId() throws ServletException, IOException {
		int id = -1;
		Connection con = null;
		try {
			con = ConnectDataBase.getConnection();
			Statement st = null;
			try {
				st = con.createStatement();
				ResultSet rs = null;
				try {
					rs = st.executeQuery("select count(id) from documents");
					int count = -1;
					while (rs.next()){
						count = rs.getInt(1);
						return count;
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
		return id;
	}

}
