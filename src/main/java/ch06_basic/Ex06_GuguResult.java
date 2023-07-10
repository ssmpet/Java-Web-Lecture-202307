package ch06_basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex06_GuguResult
 */
@WebServlet("/ch06/guguresult")
public class Ex06_GuguResult extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int dan = Integer.parseInt(request.getParameter("dan"));
		
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>구구단 결과 창</title>"
				+ "</head>"
				+ "<body style=\"margin: 40px;\">"
				+ "	<h1>구구단 결과</h1>"
				+ "	<hr>"
				+ "	<table border=1>"
				+ "		<tr>"
				+ "			<td colspan=\"2\"> " + dan + "단 출력</td>"
				+ "		</tr>";
				
		for (int i=1; i<10; i++) {
			int res = dan * i;
			html += "<tr>"
			     + "<td>" + dan + " * " + i + "</td><td> " + res + "</td></tr>";
		}
		
			html +="	</table>"
				+ "	<button onclick=\"location.href='/jw/ch06/gugu.html'\">재실행</button>"
				+ "</body>"
				+ "</html>";
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
	}

}
