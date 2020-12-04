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

import entities.PriceTime;
import service.PriceTimeService;
import service.PriceTimeServiceImpl;

@WebServlet("/PriceTimeList")
public class PriceTimeListController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    PriceTimeService priceTimeService = new PriceTimeServiceImpl();
    
    public PriceTimeListController() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<PriceTime> priceTimes = priceTimeService.getAll();
		request.setAttribute("priceTimes", priceTimes);
		RequestDispatcher dispatcher = request
                .getRequestDispatcher("/WEB-INF/views/PriceTimeViewJSP.jsp");
        dispatcher.forward(request, response);
       
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
