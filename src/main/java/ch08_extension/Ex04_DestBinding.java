package ch08_extension;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex04_DestBinding
 */
@WebServlet("/ch08/dst4")
public class Ex04_DestBinding extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqAddr = (String) request.getAttribute("requestAddr");
		String[] reqFruits = (String[]) request.getAttribute("requestFruits");
		
		HttpSession session = request.getSession();
		String sessAddr = (String)session.getAttribute("sessionAddr");
		String[] sessFruits = (String[]) session.getAttribute("sessionFruits");
		
		ServletContext ctx = getServletContext();
		String applAddr = (String) ctx.getAttribute("applicationAddr");
		String[] applFruits = (String[]) ctx.getAttribute("applicationFruits");
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>RequestDispatcher Binding<h1>");
		out.print("<h3>" + reqAddr + "</h3>");
		out.print("<h3>" + sessAddr + "</h3>");
		out.print("<h3>" + applAddr + "</h3>");
		
		System.out.println("Request scope: ");
		for (String f: reqFruits) 
			System.out.println(f + " ");
		System.out.println();
		System.out.println("Session scope: ");
		for (String f: sessFruits) 
			System.out.println(f + " ");
		System.out.println();
		System.out.println("Application scope: ");
		for (String f: applFruits ) 
			System.out.println(f + " ");
		System.out.println();
		
	}

}
