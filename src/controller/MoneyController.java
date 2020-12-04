package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Money")
public class MoneyController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public MoneyController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Socket socket = new Socket("localhost", 5000);
		try {
			String paidMoney = request.getParameter("paidMoney");
			String unit = request.getParameter("unit");
			
			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
			outToServer.writeUTF(paidMoney+ "###" + unit);
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			String moneyCoverted = dis.readUTF();
			
			PrintWriter out = response.getWriter();
			out.print(moneyCoverted);
			out.flush();
			
			dis.close();
			outToServer.close();
		} catch(Exception e) {}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
