package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;

public class UserDaoImpl implements UserDao{

	private ConnectionManager connectionManager;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public UserDaoImpl() {
		connectionManager = new ConnectionManagerImpl();
		conn = connectionManager.getConnection();
	}
	@Override
	public boolean check(String user, String pass) {
		if(user==null||pass==null) {
			return false;
		} 
		conn = connectionManager.getConnection();
		int affectedRows = 0;
		String query = "select * from account where user = ? and pass = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, user);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			rs.last();
			affectedRows =rs.getRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		} finally {
			try {
				pst.close();
				rs.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return affectedRows != 0;
	}

}
