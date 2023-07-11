package ch08_extension;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_DestRedirect
 */
@WebServlet("/ch08/dst1")
public class Ex01_DestRedirect extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("utf-8");
			String msg = request.getParameter("msg");
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>sendRedirect를 이용한 화면 이동<h1>");
			out.print("<h3>" + msg + "</h3>");
		}

}
