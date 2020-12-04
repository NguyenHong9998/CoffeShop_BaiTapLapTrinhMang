package controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Bill;
import service.BillService;
import service.BillServiceImpl;

@WebServlet("/BillFind")
public class BillFindBoxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BillService billService = new BillServiceImpl();
	String id = "";

	public BillFindBoxController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		id = request.getParameter("Id");
		if (id.equals("")) {
			List<Bill> bills = billService.getAll();
			request.setAttribute("bills", bills);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/BillListJSP.jsp");
			dispatcher.forward(request, response);
		} else {
			List<Bill> bills = billService.getAll().stream().filter(t -> t.getIdBill().startsWith(id))
					.collect(Collectors.toList());
			request.setAttribute("bills", bills);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/BillListJSP.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		id = request.getParameter("Id");
		List<Bill> bills = billService.getAll().stream().filter(t -> t.getIdBill().startsWith(id))
				.collect(Collectors.toList());
		request.setAttribute("bills", bills);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/BillListJSP.jsp");
		dispatcher.forward(request, response);
	}
}
