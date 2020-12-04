package service;

import java.util.List;

import entities.Bill;
import entities.PriceTime;

public interface BillService {
	public List<Bill> getAll();

	public List<PriceTime> getIdBill(String maHD);

	public boolean insert(Bill bill);

	public boolean delete(String billId);

	public String randomId();
}
