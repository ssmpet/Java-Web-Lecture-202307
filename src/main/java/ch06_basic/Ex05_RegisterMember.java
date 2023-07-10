package ch06_basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex05_RegisterMember
 */
@WebServlet("/ch06/register")
public class Ex05_RegisterMember extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String data = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>회원 등록</title>"
				+ "</head>"
				+ "<body style=\"margin: 40px;\">"
				+ "	<h1>회원 등록</h1>"
				+ "	<hr>"
				+ "	<form action=\"/jw/ch06/register\" method=\"post\">"
				+ "		uid : <input type=\"text\" name=\"uid\"><br>"
				+ "		pwd : <input type=\"password\" name=\"pwd\"><br>"
				+ "		uname : <input type=\"text\" name=\"uname\"><br>"
				+ "		email : <input type=\"email\" name=\"email\"><br>"
				+ "		<input type=\"submit\" value=\"확인\"> "
				+ "		<input type=\"reset\" value=\"취소\">"
				+ "	</form>	"
				+ "</body>"
				+ "</html>";
		
		out.print(data);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");		// 한글 처리시 필수
		response.setContentType("text/html; charset=utf-8");
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		
		String html = "<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "	<meta charset=\"UTF-8\">"
					+ "	<title>회원 등록 결과</title>"
					+ "</head>"
					+ "<body style=\"margin: 40px;\">"
					+ "	<h1>회원 등록 결과창입니다.</h1>"
					+ "	<hr>"
					+ "		uid : " + uid + "<br>"
					+ "		pwd : " + pwd + " <br>"
					+ "		uname : " + uname + "<br>"
					+ "		email : " + email + "<br>"
					+ "		<button onclick=\"location.href='/jw/ch06/register'\">재실행</button>"
					+ "</body>"
					+ "</html>";

		PrintWriter out = response.getWriter();
		out.print(html);
		
	}

}
