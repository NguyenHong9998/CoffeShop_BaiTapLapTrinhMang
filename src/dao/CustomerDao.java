package dao;

import java.util.List;

import entities.Customer;

public interface CustomerDao {
	List<Customer> getAll();
	List<Customer> getCustomers(String nameCustomer);
	List<String> getIdCustomers();
	boolean insert(Customer customer);
	boolean delete(String idCustomer);
	boolean update(String idCustomer,String address,String phoneNumber,String taxFee);
}
