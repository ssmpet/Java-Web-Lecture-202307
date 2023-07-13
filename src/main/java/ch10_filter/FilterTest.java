package ch10_filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FilterTest
 */
@WebServlet("/ch10/filterTest")
public class FilterTest extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FilterTest doPost()");

		String msg = request.getParameter("msg");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>Filter Test</h1>");
		out.print("<h3>메세지 내용: " + msg + "</h3>");

	}

}
