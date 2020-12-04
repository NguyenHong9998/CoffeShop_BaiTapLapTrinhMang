package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Bill;
import service.BillService;
import service.BillServiceImpl;

@WebServlet("/BillInsertControl")
public class BillInsertControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BillService billService = new BillServiceImpl();

	String idBill = "";
	String idListBill = "";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		idBill = request.getParameter("billId");
		idListBill = request.getParameter("idListItem");
		System.out.println(idBill + "," + idListBill);
		billService.insert(new Bill(idBill, idListBill));

		response.sendRedirect(request.getContextPath() + "/BillList");
		return;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
