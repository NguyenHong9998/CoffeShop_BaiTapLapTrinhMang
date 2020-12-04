package controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

@WebServlet("/CustomerFind")
public class CustomerFindBoxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService customerService = new CustomerServiceImpl();
	String nameCustomer = "";

	public CustomerFindBoxController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		nameCustomer = request.getParameter("Name");
		System.out.println(nameCustomer);
		if (nameCustomer == "") {
			List<Customer> customers = customerService.getAll();
			System.out.println(customers.size());
			request.setAttribute("customers", customers);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerViewJSP.jsp");
			dispatcher.forward(request, response);
			return;
		} else {
			List<Customer> customers = customerService.getCustomers(nameCustomer);
			System.out.println(customers.size());
			request.setAttribute("customers", customers);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerViewJSP.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		nameCustomer = request.getParameter("Name");
		List<Customer> customers = customerService.getCustomers(nameCustomer);
		request.setAttribute("customers", customers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerViewJSP.jsp");
		dispatcher.forward(request, response);
	}
}
