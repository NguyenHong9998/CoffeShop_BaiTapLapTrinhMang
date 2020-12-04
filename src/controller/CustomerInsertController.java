package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

@WebServlet("/CustomerInsert")
public class CustomerInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService customerService = new CustomerServiceImpl();
	String warn = "";
	String size = "";

	public CustomerInsertController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		size = request.getParameter("Size");
		request.setAttribute("Size", size);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerInsertBoxJSP.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idCustomer = customerService.randomId();
		String nameCustomer = request.getParameter("nameCustomer");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		try {
			Double mobiphone = Double.parseDouble(phone);
		} catch (NumberFormatException e) {
			warn = "Số điện thoại không đúng!";
			request.setAttribute("warn", warn);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerInsertBoxJSP.jsp");
			dispatcher.forward(request, response);
			return;
		}
		Customer customer = new Customer(idCustomer, nameCustomer, address, phone);
		System.out.println(customer);
		boolean key = customerService.insert(customer);
		if (key == true) {
			response.sendRedirect(request.getContextPath() + "/CustomerList");
		} else {
			warn = "Error ! Please try again";
			request.setAttribute("warn", warn);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerInsertBoxJSP.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}

}
