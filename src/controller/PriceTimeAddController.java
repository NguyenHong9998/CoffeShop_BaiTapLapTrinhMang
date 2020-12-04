package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.PriceTime;
import service.PriceTimeService;
import service.PriceTimeServiceImpl;

@WebServlet("/PriceTimeAdd")

public class PriceTimeAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PriceTimeService priceTimeService = new PriceTimeServiceImpl();
	String warn = "";
	String size = "";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		size = request.getParameter("Size");
		request.setAttribute("Size", size);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/PriceTimeAddJSP.jsp");
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/PriceTimeAddJSP.jsp");
			dispatcher.forward(request, response);
			return;
		}
		String tenMathHang = request.getParameter("tenMatHang");
		System.out.println("mã: " + (size + 1) + ", tên: " + tenMathHang + " , giá: " + gia);
		String id = priceTimeService.randomId();
		boolean key = priceTimeService.insert(new PriceTime(id, Double.parseDouble(donGia), tenMathHang));
		if (key == true) {
			response.sendRedirect(request.getContextPath() + "/PriceTimeList");
		} else {
			warn = "Error ! Please try again";
			request.setAttribute("warn", warn);
			/*
			 * request.setAttribute("priceTimeId", priceTimeId);
			 */ RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/PriceTimeAddJSP.jsp");
			dispatcher.forward(request, response);
			return;
		}

	}
}
