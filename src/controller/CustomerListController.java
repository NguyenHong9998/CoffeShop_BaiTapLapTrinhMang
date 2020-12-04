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

import entities.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

@WebServlet("/CustomerList")
public class CustomerListController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    CustomerService customerService = new CustomerServiceImpl();
    
    public CustomerListController() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Customer> customers= customerService.getAll();
		request.setAttribute("customers", customers);
		RequestDispatcher dispatcher = request
                .getRequestDispatcher("/WEB-INF/views/CustomerViewJSP.jsp");
        dispatcher.forward(request, response);
       
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
