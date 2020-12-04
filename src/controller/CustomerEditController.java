package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;
import service.CustomerServiceImpl;

@WebServlet("/CustomerEdit")
public class CustomerEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService customerService = new CustomerServiceImpl();
	String warn = "";
	String idCustomer = "";
	String name = "";
	String address = "";
	String phone = "";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		idCustomer = request.getParameter("Id");
		name = request.getParameter("Name");
		address = request.getParameter("Address");
		phone = request.getParameter("Phone");
		request.setAttribute("customerId", idCustomer);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerEditBoxJSP.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		String name = request.getParameter("nameCustomer");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		try {
			Double phoneNumber = Double.parseDouble(phone);
		} catch (NumberFormatException e) {
			warn = "Số điện thoại không đúng!";
			request.setAttribute("customerId", idCustomer);
			request.setAttribute("warn", warn);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			request.setAttribute("address", address);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerEditBoxJSP.jsp");
			dispatcher.forward(request, response);
			return;
		}
		boolean key = customerService.update(idCustomer, name, address, phone);
		if (key == true) {
			response.sendRedirect(request.getContextPath() + "/CustomerList");
		} else {
			warn = "Error ! Please try again";
			request.setAttribute("customerId", idCustomer);
			request.setAttribute("warn", warn);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			request.setAttribute("address", address);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerEditBoxJSP.jsp");
			dispatcher.forward(request, response);
			return;
		}

	}
}
