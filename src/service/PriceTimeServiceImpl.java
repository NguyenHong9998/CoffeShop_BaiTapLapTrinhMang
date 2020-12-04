package service;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import dao.PriceTimeDao;
import dao.PriceTimeDaoImpl;
import entities.Customer;
import entities.PriceTime;

public class PriceTimeServiceImpl implements PriceTimeService {
	private PriceTimeDao priceTimeDao;

	public PriceTimeServiceImpl() {
		priceTimeDao = new PriceTimeDaoImpl();
	}

	@Override
	public List<PriceTime> getAll() {
		return priceTimeDao.getAll();
	}

	@Override
	public boolean update(String idPriceTime, Double moneyPriceTime) {
		if (idPriceTime == null) {
			return false;
		} else {
			return priceTimeDao.update(idPriceTime, moneyPriceTime);
		}
	}

	@Override
	public boolean update(String idPriceTime, String tenmatHang, Double donGia) {
		if (idPriceTime == null) {
			return false;
		} else {
			return priceTimeDao.update(idPriceTime, tenmatHang, donGia);
		}
	}

	@Override
	public boolean insert(PriceTime priceTime) {
		if (priceTime == null) {
			return false;
		}
		return priceTimeDao.insert(priceTime);
	}

	@Override
	public String randomId() {
		List<PriceTime> list = getAll();
		Set<Integer> id = list.stream().map(t -> t.getIdPriceTime())
				.map(s -> Integer.parseInt(s.substring(s.lastIndexOf("T") + 1))).collect(Collectors.toSet());
		id.forEach(t -> System.out.println(t));
		Random rand = new Random();
		while (true) {
			int x = rand.nextInt(50) + 1;
			if (id.add(x)) {
				if (x <= 9) {
					return "MT0" + x;
				} else {
					return "MT" + x;
				}
			}
		}
	}

}
