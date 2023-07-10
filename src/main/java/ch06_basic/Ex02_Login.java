package ch06_basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex02_Login
 */
@WebServlet("/ch06/login")
public class Ex02_Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost() method called.");
		request.setCharacterEncoding("utf-8");		// 한글 처리시 필수

		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String[] countries = request.getParameterValues("country");

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>파라메터 확인</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>로그인 창에서 입력한 값</h1>"
				+ "<hr>"
				+ "<ul>"
				+ "	<li>아이디: " + uid + "</li>"
				+ "	<li>패스워드: " + pwd + "</li>"
				+ "</ul>"
				+ "<ul>";
		
		for (String country: countries) {
			html += "<li>" + country + "</li>";			
		}
		html += "</ul>";
		html += "</body>"
				+ "</html>";
	
		out.print(html);

//		doGet(request, response);
	}

}
