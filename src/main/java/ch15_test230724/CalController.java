package ch15_test230724;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalController
 */
@WebServlet("/ch15/cal")
public class CalController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch15/cal.jsp?num1=" + request.getParameter("num1") + 
																		   "&num1=" + request.getParameter("num2") +
																		   "&operator=" + request.getParameter("operator")+
																		   "&result=" + request.getParameter("result"));
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		double result = 0;

		String operator = request.getParameter("operator");
		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = (double)num1 / num2;
			break;
		default:
			break;
		}
		
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("operator", operator);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/ch15/cal.jsp");
		rd.forward(request, response);
		
	}

}


