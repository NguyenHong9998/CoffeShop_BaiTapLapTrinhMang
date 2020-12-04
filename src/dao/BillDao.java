package dao;

import java.util.List;

import entities.Bill;
import entities.PriceTime;

public interface BillDao {
	List<Bill> getAll();
	
	List<PriceTime> getIdBill(String maHD);

	boolean insert(Bill bill);
	
	boolean delete(String billId);
}
