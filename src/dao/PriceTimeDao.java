package dao;

import java.util.List;

import entities.PriceTime;

public interface PriceTimeDao {
	List<PriceTime> getAll();

	boolean update(String idPriceTime, Double moneyPriceTime);

	boolean update(String idPriceTime, String tenMatHang, Double donGia);

	boolean insert(PriceTime priceTime);
}
