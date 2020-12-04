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

@WebServlet("/BillDelete")
public class BillDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BillService billService = new BillServiceImpl();

	public BillDeleteController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String billId = (String) request.getParameter("billId");
		boolean key = billService.delete(billId);
		if (key == true) {
			response.sendRedirect(request.getContextPath() + "/BillList");
		} else {
			response.sendRedirect(request.getContextPath() + "/BillList");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
