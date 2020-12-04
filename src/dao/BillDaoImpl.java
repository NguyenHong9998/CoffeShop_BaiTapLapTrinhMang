package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Bill;
import entities.PriceTime;

public class BillDaoImpl implements BillDao {

	private ConnectionManager connectionManager;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public BillDaoImpl() {
		connectionManager = new ConnectionManagerImpl();
		conn = connectionManager.getConnection();
	}

	@Override
	public List<Bill> getAll() {
		conn = connectionManager.getConnection();
		List<Bill> bills = new ArrayList<Bill>();
		String query = "SELECT * FROM hoadon";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				Bill bill = new Bill(rs.getString("MaHD"), rs.getString("CacMatHang"));
				bills.add(bill);
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

		return bills;
	}

	@Override
	public boolean insert(Bill bill) {
		if (bill.getIdBill() == null || bill.getListIdMH() == null) {
			return false;
		}
		if (bill.getIdBill().equals("") || bill.getListIdMH().equals("")) {
			return false;
		}
		conn = connectionManager.getConnection();
		int affectedRows = 0;
		String query = "insert into hoadon (MaHD,CacMatHang) values (?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, bill.getIdBill());
			pst.setString(2, bill.getListIdMH());

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
	public boolean delete(String billId) {
		if (billId == null) {
			return false;
		}
		conn = connectionManager.getConnection();
		int affectedRows = 0;
		String query = "delete from hoadon where MaHD = ? ";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, billId);
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
	public List<PriceTime> getIdBill(String maHD) {
		conn = connectionManager.getConnection();
		List<PriceTime> idBills = new ArrayList<>();
		List<PriceTime> list = new PriceTimeDaoImpl().getAll();
		String query = "SELECT CacMatHang FROM hoadon where MaHD=?";

		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, maHD);
			rs = pst.executeQuery();
			while (rs.next()) {
				String idListMH = rs.getString("CacMatHang");
				System.out.println(idListMH);
				String[] listId = idListMH.split(",");
				for (String s : listId) {
					idBills.add(list.stream().filter(t -> t.getIdPriceTime().equals(s)).collect(Collectors.toList())
							.get(0));
				}
			}
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				pst.close();

				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return idBills;
	}

}
