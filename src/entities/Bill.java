package entities;

import java.util.List;

public class Bill {
	private String idBill;
	private String listIdMH;

	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Bill(String idBill, String listIdMH) {
		super();
		this.idBill = idBill;
		this.listIdMH = listIdMH;
	}

	public String getIdBill() {
		return idBill;
	}

	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}

	public String getListIdMH() {
		return listIdMH;
	}

	public void setListIdMH(String listIdMH) {
		this.listIdMH = listIdMH;
	}

	public Double getMoney(List<PriceTime> list) {
		double money = 0;
		for (PriceTime p : list) {
			money += p.getMoneyPriceTime();
		}
		return money;
	}

	@Override
	public String toString() {
		return "Bill [idBill=" + idBill + ", listIdMH=" + listIdMH + "]";
	}

}
