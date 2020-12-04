package entities;

public class PriceTime {
	private String idPriceTime;
	private Double moneyPriceTime;
	private String desPriceTime;
	
	public PriceTime() {
		
	}

	public PriceTime(String idPriceTime, Double moneyPriceTime, String desPriceTime) {
		this.idPriceTime = idPriceTime;
		this.moneyPriceTime = moneyPriceTime;
		this.desPriceTime = desPriceTime;
	}

	public String getIdPriceTime() {
		return idPriceTime;
	}

	public void setIdPriceTime(String idPriceTime) {
		this.idPriceTime = idPriceTime;
	}

	public Double getMoneyPriceTime() {
		return moneyPriceTime;
	}

	public void setMoneyPriceTime(Double moneyPriceTime) {
		this.moneyPriceTime = moneyPriceTime;
	}

	public String getDesPriceTime() {
		return desPriceTime;
	}

	public void setDesPriceTime(String desPriceTime) {
		this.desPriceTime = desPriceTime;
	}

	@Override
	public String toString() {
		return "PriceTime [idPriceTime=" + idPriceTime + ", moneyPriceTime=" + moneyPriceTime + ", desPriceTime="
				+ desPriceTime + "]";
	}

	
}
