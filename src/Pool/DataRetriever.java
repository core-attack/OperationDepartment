package Pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

import classes.*;
import registration.*;
/**
 * requests to DBConnectionPool
 */
public class DataRetriever {
	public static void main(String[] args) throws Exception {
		//new DataRetriever().retrieveData();
		//new DataRetriever().getLastTicketId();
		//new DataRetriever().setClient(3008);
		//new DataRetriever().setFlight(14);
		new DataRetriever().buyTicket(3008, 14, null);
	}

	/**
	 */
	private void retrieveData() throws Exception {

		DBConnectionPool pool = new DBConnectionPool();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			final Connection connection = pool.getConnection();
			pstmt = connection
					.prepareStatement("SELECT id, name FROM flights");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				final String id = rset.getString("id");
				final String name = rset.getString("name");
				System.out.println(id + " | " + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();

			pool.close();
		}
	}
	
	public static void buyTicket(int client_id, int flight_id, HttpServletRequest request) throws Exception{
		DBConnectionPool pool = new DBConnectionPool();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			final Connection connection = pool.getConnection();
			connection.setAutoCommit(false);
			Statement st = connection.createStatement();
			setClient(client_id);
			setFlight(flight_id);
			int id = getLastTicketId() + 1;
			/*String sql = "INSERT INTO tickets(id, flight_id, client_id, price, luggage_price, action_id) VALUES("
					+ id
					+ ","
					+ flight.getId()
					+ ","
					+ client.getId()
					+ ","
					+ flight.getPrice()
					+ ","
					+ flight.getLuggage_price()
					+ ","
					+ "\""
					+ 400
					+ "\");";
			System.out.println(sql);
			//pstmt = connection
					//.prepareStatement(sql);
			st.executeUpdate(sql);
			//rset = pstmt.executeQuery();
			connection.commit();
			System.out.println("ticket bought");
			if (request != null){
				request.setAttribute("ticket_id", id);
				request.setAttribute("ticket_flight_id", flight.getId());
				request.setAttribute("ticket_client_id", client.getId());
				request.setAttribute("ticket_price", flight.getPrice());
				request.setAttribute("ticket_luggage_price", flight.getLuggage_price());
				request.setAttribute("ticket_action_id", 0);
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
			pool.close();
		}
	}
	
	private static int getLastTicketId() throws Exception{
		int id = -1;
		DBConnectionPool pool = new DBConnectionPool();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			final Connection connection = pool.getConnection();
			pstmt = connection
					.prepareStatement("SELECT max(id) FROM tickets");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				id = rset.getInt("max(id)");
				System.out.println("max ticket id = " + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
			pool.close();
			return id;
		}
	}
	
	private static void setClient(int client_id) throws Exception{
		
		DBConnectionPool pool = new DBConnectionPool();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			final Connection connection = pool.getConnection();
			pstmt = connection
					.prepareStatement("SELECT * FROM clients WHERE id = " + client_id);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				/*
				client = new Client(rset.getInt("id"), rset.getInt("category_id"), rset.getString("lastname"), rset.getString("firstname"), 
						rset.getString("phone"),  rset.getString("passport"),  rset.getString("born_date"),  rset.getString("email"));
				System.out.println(client.print());*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
			pool.close();
		}
	}
	
		private static void setFlight(int flight_id) throws Exception{
		
		DBConnectionPool pool = new DBConnectionPool();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			final Connection connection = pool.getConnection();
			pstmt = connection
					.prepareStatement("SELECT * FROM flights WHERE id = " + flight_id);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				
				/*flight = new Flight(rset.getInt("id"), rset.getInt("airplane_id"), rset.getString("name"), rset.getString("from"), 
						rset.getString("to"),  rset.getString("departure_time"),  rset.getString("incoming_time"),  rset.getString("departure_date"),  
						rset.getString("incoming_date"), rset.getString("number"), rset.getDouble("price"), rset.getDouble("luggage_price"));
				System.out.println(flight.print());*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (rset != null)
				rset.close();
			if (pstmt != null)
				pstmt.close();
			pool.close();
		}
	}
}
