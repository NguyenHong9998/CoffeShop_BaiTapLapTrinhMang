package service;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entities.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public CustomerServiceImpl() {
		customerDao = new CustomerDaoImpl();
	}

	@Override
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	@Override
	public List<Customer> getCustomers(String nameCustomer) {
		return customerDao.getCustomers(nameCustomer);
	}

	@Override
	public boolean insert(Customer customer) {
		if (customer == null) {
			return false;
		}
		return customerDao.insert(customer);
	}

	@Override
	public boolean delete(String idCustomer) {
		if (idCustomer == null) {
			return false;
		}
		return customerDao.delete(idCustomer);
	}

	@Override
	public boolean update(String idCustomer, String address, String phoneNumber, String taxFee) {
		if (idCustomer == null) {
			return false;
		}
		return customerDao.update(idCustomer, address, phoneNumber, taxFee);
	}

	@Override
	public List<String> getIdCustomers() {
		return customerDao.getIdCustomers();
	}

	@Override
	public String randomId() {
		List<Customer> list = getAll();
		Set<Integer> id = list.stream().map(t -> t.getIdCustomer())
				.map(s -> Integer.parseInt(s.substring(s.lastIndexOf("H") + 1))).collect(Collectors.toSet());
		id.forEach(t -> System.out.println(t));
		Random rand = new Random();
		while (true) {
			int x = rand.nextInt(50) + 1;
			if (id.add(x)) {
				if (x <= 9) {
					return "KH0" + x;
				} else {
					return "KH" + x;
				}
			}
		}
	}
}
