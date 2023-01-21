package Brand;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection_maria {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String user = "c##green";
	private static final String pwd = "GREEN1234";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
