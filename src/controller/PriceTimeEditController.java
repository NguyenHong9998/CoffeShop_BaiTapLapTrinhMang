package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PriceTimeService;
import service.PriceTimeServiceImpl;

@WebServlet("/PriceTimeEdit")
public class PriceTimeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PriceTimeService priceTimeService = new PriceTimeServiceImpl();
	String warn = "";
	String priceTimeId = "";
	String name = "";
	String price = "";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		priceTimeId = request.getParameter("IdPriceTime");
		name = request.getParameter("Name");
		price = request.getParameter("Price");
		request.setAttribute("priceTimeId", priceTimeId);
		request.setAttribute("name", name);
		request.setAttribute("price", price);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/PriceTimeEditBoxJSP.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String donGia = request.getParameter("donGia");
		double gia = -1;
		try {
			gia = Double.parseDouble(donGia);
		} catch (NumberFormatException e) {
			warn = "Giá mặt hàng không đúng!";
			request.setAttribute("warn", warn);
			request.setAttribute("priceTimeId", priceTimeId);
			request.setAttribute("name", name);
			request.setAttribute("price", price);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/PriceTimeEditBoxJSP.jsp");
			dispatcher.forward(request, response);
			return;
		}
		String tenMathHang = request.getParameter("tenMatHang");
		System.out.println("mã: " + priceTimeId + ", tên: " + tenMathHang + " , giá: " + gia);
		boolean key = priceTimeService.update(priceTimeId, tenMathHang, gia);
		if (key == true) {
			response.sendRedirect(request.getContextPath() + "/PriceTimeList");
		} else {
			warn = "Error ! Please try again";
			request.setAttribute("warn", warn);
			request.setAttribute("priceTimeId", priceTimeId);
			request.setAttribute("name", name);
			request.setAttribute("price", price);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/PriceTimeEditBoxJSP.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
}
