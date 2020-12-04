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

import entities.Bill;
import service.BillService;
import service.BillServiceImpl;

@WebServlet("/BillList")
public class BillListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BillService billService = new BillServiceImpl();

	public BillListController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Bill> bills = billService.getAll();
		request.setAttribute("bills", bills);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/BillListJSP.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
