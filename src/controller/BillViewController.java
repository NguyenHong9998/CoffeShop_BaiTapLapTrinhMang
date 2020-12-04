package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Bill;
import entities.PriceTime;
import service.BillService;
import service.BillServiceImpl;

@WebServlet("/BillView")
public class BillViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BillService billService = new BillServiceImpl();
	String id = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		id = req.getParameter("Id");
		System.out.println(id);
		List<PriceTime> listPriceTime = billService.getIdBill(id);
		Double money = new Bill().getMoney(listPriceTime);
		req.setAttribute("money", money);
		req.setAttribute("list", listPriceTime);
		req.setAttribute("Id", id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/BillViewJSP.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
