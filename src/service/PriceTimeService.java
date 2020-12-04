package service;

import java.util.List;

import entities.PriceTime;

public interface PriceTimeService {
	public List<PriceTime> getAll();

	public boolean update(String idPriceTime, Double moneyPriceTime);

	public boolean update(String idPriceTime, String tenmatHang, Double donGia);

	public boolean insert(PriceTime priceTime);

	public String randomId();

}
