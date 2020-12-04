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
import entities.Bill;
import entities.PriceTime;

public class PriceTimeDaoImpl implements PriceTimeDao {
	private ConnectionManager connectionManager;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public PriceTimeDaoImpl() {
		connectionManager = new ConnectionManagerImpl();
		conn = connectionManager.getConnection();
	}

	@Override
	public List<PriceTime> getAll() {
		conn = connectionManager.getConnection();
		List<PriceTime> priceTimes = new ArrayList<PriceTime>();
		String query = "SELECT * FROM muctiengio";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				PriceTime priceTime = new PriceTime(rs.getString("MaMatHang"), rs.getDouble("DonGia"),
						rs.getString("MoTa"));
				priceTimes.add(priceTime);
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

		return priceTimes;
	}

	@Override
	public boolean update(String idPriceTime, Double moneyPriceTime) {
		if (moneyPriceTime == null) {
			return false;
		}
		conn = connectionManager.getConnection();
		int affectedRows = 0;
		String query = "update muctiengio set DonGia=? where MaMatHang=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setDouble(1, moneyPriceTime);
			pst.setString(2, idPriceTime);
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
	public boolean update(String idPriceTime, String tenMatHang, Double donGia) {
		if (donGia == null || tenMatHang == null) {
			return false;
		}
		conn = connectionManager.getConnection();
		int affectedRows = 0;
		String query = "update muctiengio set DonGia=?, MoTa=? where MaMatHang=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setDouble(1, donGia);
			pst.setString(2, tenMatHang);
			pst.setString(3, idPriceTime);
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
	public boolean insert(PriceTime priceTime) {
		if (priceTime.getIdPriceTime() == null || priceTime.getMoneyPriceTime() == null
				|| priceTime.getDesPriceTime() == null) {
			return false;
		}
		if (priceTime.getIdPriceTime().equals("") || priceTime.getMoneyPriceTime().equals("")
				|| priceTime.getDesPriceTime().equals("")) {
			return false;
		}
		conn = connectionManager.getConnection();
		int affectedRows = 0;
		String query = "insert into muctiengio(MaMatHang,DonGia,MoTa) values (?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, priceTime.getIdPriceTime());
			pst.setDouble(2, priceTime.getMoneyPriceTime());
			pst.setString(3, priceTime.getDesPriceTime());

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
}
