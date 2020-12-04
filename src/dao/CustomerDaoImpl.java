package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public CustomerDaoImpl() {
		connectionManager = new ConnectionManagerImpl();
		conn = connectionManager.getConnection();
	}

	@Override
	public List<Customer> getAll() {
		conn = connectionManager.getConnection();
		List<Customer> customers = new ArrayList<Customer>();
		String query = "SELECT * FROM khachhang";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				Customer customer = new Customer(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("DiaChi"),
						rs.getString("SoDT"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			return null;
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return customers;
	}

	@Override
	public List<Customer> getCustomers(String nameCustomer) {
		if (nameCustomer.equals("") || nameCustomer == null) {
			return null;
		}
		conn = connectionManager.getConnection();
		List<Customer> customers = new ArrayList<Customer>();
		String query = "SELECT * FROM khachhang WHERE TenKH like ?";

		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, "%" + nameCustomer + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("DiaChi"),
						rs.getString("SoDT"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			return null;
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return customers;

	}

	@Override
	public boolean insert(Customer customer) {
		if (customer.getIdCustomer() == null || customer.getNameCustomer() == null || customer.getAddress() == null
				|| customer.getPhone() == null) {
			return false;
		}
		if (customer.getIdCustomer().equals("") || customer.getNameCustomer().equals("")
				|| customer.getAddress().equals("") || customer.getPhone().equals("")) {
			return false;
		}
		conn = connectionManager.getConnection();
		int affectedRows = 0;
		String query = "insert into khachhang (MaKH,TenKH,DiaChi,SoDT) values (?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, customer.getIdCustomer());
			pst.setString(2, customer.getNameCustomer());
			pst.setString(3, customer.getAddress());
			pst.setString(4, customer.getPhone());
			affectedRows = pst.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return affectedRows != 0;

	}

	@Override
	public boolean delete(String idCustomer) {
		if (idCustomer == null || idCustomer.equals("")) {
			return false;
		}
		conn = connectionManager.getConnection();
		int affectedRows = 0;
		String query = "delete from khachhang where MaKH = ? ";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, idCustomer);
			affectedRows = pst.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return affectedRows != 0;
	}

	@Override
	public boolean update(String idCustomer, String name, String address, String phoneNumber) {
		if (address == null || phoneNumber == null || address == null) {
			return false;
		}
		if (address.equals("") || phoneNumber.equals("") || address.equals("")) {
			return false;
		}
		conn = connectionManager.getConnection();
		int affectedRows = 0;
		String query = "update khachhang set DiaChi=?,SoDT=?,TenKH=? where MaKH=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, address);
			pst.setString(2, phoneNumber);
			pst.setString(3, name);
			pst.setString(4, idCustomer);
			affectedRows = pst.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return affectedRows != 0;

	}

	@Override
	public List<String> getIdCustomers() {
		conn = connectionManager.getConnection();
		List<String> idCustomers = new ArrayList<String>();
		String query = "SELECT MaKH FROM khachhang";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				String idCustomer = rs.getString("MaKH");
				idCustomers.add(idCustomer);
			}
		} catch (SQLException e) {
			return null;
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return idCustomers;
	}
}
