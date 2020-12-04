package controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Bill;
import service.BillService;
import service.BillServiceImpl;
import service.CustomerService;
import service.CustomerServiceImpl;

@WebServlet("/CustomerDelete")
public class CustomerDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService customerService = new CustomerServiceImpl();

	public CustomerDeleteController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idCustomer = (String) request.getParameter("Id");
		boolean key = customerService.delete(idCustomer);
		if (key == true) {
			response.sendRedirect(request.getContextPath() + "/CustomerList");
		} else {
			response.sendRedirect(request.getContextPath() + "/CustomerList");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
