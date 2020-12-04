package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BillService;
import service.BillServiceImpl;

@WebServlet("/BillInsert")
public class BillInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BillService billService = new BillServiceImpl();
	String warn = "";
	String idBill = "";
	String idListBill = "";

	public BillInsertController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/BillInsertBoxJSP.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
