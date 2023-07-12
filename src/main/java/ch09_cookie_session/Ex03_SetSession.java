package ch09_cookie_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.group.Response;

/**
 * Servlet implementation class Ex03_SetSession
 */
@WebServlet("/ch09/setSession")
public class Ex03_SetSession extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = session.getId();
		int interval = session.getMaxInactiveInterval();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>isNew: " + session.isNew() + "</h1>");
		out.print("<h1>id: " + id + "</h1>");
		out.print("<h1>maxInactiveInterval: " + interval + "</h1>");
		
//		session.invalidate();	// 세션을 강제로 삭제
	}
}
