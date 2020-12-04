package entities;

import java.util.Objects;

public class Customer {
	private String idCustomer;
	private String nameCustomer;
	private String address;
	private String phone;

	public Customer() {

	}

	public Customer(String idCustomer, String nameCustomer, String address, String phone) {
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.address = address;
		this.phone = phone;
	}

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Bill) {
			return false;
		}
		Customer customer = (Customer) obj;
		return customer.getIdCustomer() == getIdCustomer();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(getIdCustomer());
	}

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", nameCustomer=" + nameCustomer + ", address=" + address
				+ ", phone=" + phone + "]";
	}

	

}
