package service;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import dao.BillDao;
import dao.BillDaoImpl;
import entities.Bill;
import entities.PriceTime;

public class BillServiceImpl implements BillService {
	private BillDao billDao;

	public BillServiceImpl() {
		billDao = new BillDaoImpl();
	}

	@Override
	public List<Bill> getAll() {
		return billDao.getAll();
	}

	@Override
	public boolean insert(Bill bill) {
		if (bill == null) {
			return false;
		}
		return billDao.insert(bill);
	}

	@Override
	public boolean delete(String billId) {
		if (billId == null) {
			return false;
		}
		return billDao.delete(billId);
	}

	@Override
	public List<PriceTime> getIdBill(String maHD) {
		return billDao.getIdBill(maHD);
	}

	@Override
	public String randomId() {
		List<Bill> list = getAll();
		Set<Integer> id = list.stream().map(t -> t.getIdBill())
				.map(s -> Integer.parseInt(s.substring(s.lastIndexOf("D") + 1))).collect(Collectors.toSet());
		id.forEach(t -> System.out.println(t));
		Random rand = new Random();
		while (true) {
			int x = rand.nextInt(50) + 1;
			if (id.add(x)) {
				if (x <= 9) {
					return "HD0" + x;
				} else {
					return "HD" + x;
				}
			}
		}
	}

}
