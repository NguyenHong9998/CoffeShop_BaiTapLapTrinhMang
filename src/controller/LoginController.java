package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	String warn = "";

	public LoginController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginJSP.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		System.out.println("user : " + user + ", pass: " + pass);
		boolean key = userService.check(user, pass);
		if (key == true) {
			request.getSession().setAttribute("account", user);
			request.setAttribute("name", user);
			response.sendRedirect("index.jsp");
		} else {
			warn = "Tài khoản hoặc mật khẩu không đúng!";
			request.setAttribute("warn", warn);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginJSP.jsp");
			dispatcher.forward(request, response);
		}
	}
}

