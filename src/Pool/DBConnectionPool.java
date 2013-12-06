package Pool;

import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * database connection pool 
 */
public class DBConnectionPool {

	/**
	 * 
	 */
	private static final int MAX_ACTIVE = 100;

	/**
	 * 
	 */
	private static final int MAX_WAIT = 100;
	/**
	 * 
	 */
	private Connection conn = null;

	/**
	 * 
	 */
	private static DataSource ds = null;

	/**
	 *
	 */
	public DBConnectionPool() {
		if (ds == null) {
			try {
				// 
				DriverAdapterCPDS pcds = new DriverAdapterCPDS();
				pcds.setDriver("org.gjt.mm.mysql.Driver");
				pcds.setUrl("jdbc:mysql://localhost:3307/operationDepartment?useUnicode=true&");
				pcds.setUser("root");
				pcds.setPassword("P@ssw0rd");

				// 
				SharedPoolDataSource tds = new SharedPoolDataSource();
				tds.setConnectionPoolDataSource(pcds);

				tds.setMaxActive(MAX_ACTIVE);

				tds.setMaxWait(MAX_WAIT);

				ds = tds;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *
	 */
	public Connection openConnection() throws SQLException {
		if (conn == null)
			conn = ds.getConnection();
		return conn;

	}

	/**
	 * 
	 */
	public static int getActiveConnection() {
		return ((SharedPoolDataSource) ds).getNumActive();
	}

	/**
	 * 
	 */
	public Connection getConnection() throws SQLException {
		return openConnection();
	}

	/**
	 * 
	 */
	public void close() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
