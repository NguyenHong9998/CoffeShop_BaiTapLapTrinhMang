package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManagerImpl implements ConnectionManager {
	
	@Override
	public Connection getConnection() {
		Connection cnn = null;

		try {
			// mysql driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baitaplaptrinhmang", "root", "hong09081999");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnn;
	}
}
