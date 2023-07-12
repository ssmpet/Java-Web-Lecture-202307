package ch09_cookie_session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_SetCookie
 */
@WebServlet("/ch09/setCookie")
public class Ex01_SetCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie c1 = new Cookie("cookie-name", "cookie-value");
		c1.setMaxAge(24*60*60); 	// 유효기간: 24 * 60 * 60 초 --> 1일
		response.addCookie(c1);
		
		String kMsg = URLEncoder.encode("한글 데이터", "utf-8");
		Cookie c2 = new Cookie("hangul-test", kMsg);
		c2.setMaxAge(-1);			// -1: 브라우저가 닫히면 사라짐
		response.addCookie(c2);
		
		out.print("<h1>현재시간: " + new Date() + "</h1>");
	}

}
