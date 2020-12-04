package service;

import java.util.List;

import entities.Customer;

public interface CustomerService {
	public List<Customer> getAll();
	public List<Customer> getCustomers(String nameCustomer);
	public boolean insert(Customer customer);
	public boolean delete(String idCustomer);
	public boolean update(String idCustomer,String address,String phoneNumber,String taxFee);
	public List<String> getIdCustomers();
	public String randomId();
}
