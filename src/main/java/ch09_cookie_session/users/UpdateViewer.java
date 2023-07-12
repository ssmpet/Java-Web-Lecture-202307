package ch09_cookie_session.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateViewer
 */
@WebServlet("/ch09/users/updateViewer")
public class UpdateViewer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = (User) request.getAttribute("user");
		
		String html ="<!DOCTYPE html>"
				+ "<html lang=\"en\">"
				+ "<head>"
				+ "    <meta charset=\"UTF-8\">"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "    <title>회원 수정</title>"
				+ "    <style>"
				+ "        td { text-align: center; padding: 3px;}"
				+ "    </style>"
				+ "</head>"
				+ "<body style=\"margin: 40px;\">"
				+ "    <h1>회원 수정</h1>"
				+ "    <hr>"
				+ "    <form action=\"/jw/ch09/users/update\" method=\"post\">"
				+ " 	   <input type=\"hidden\" name=\"uid\" value=\""+ user.getUid() + "\">"
				+ "        <table>"
				+ "            <tr>"
				+ "                <td>아이디</td>"
				+ "                <td><input type=\"text\" name=\"uid\" value=\""+ user.getUid() +"\" disabled></td>"
			    + "            </tr>"
				+ "            <tr>"
				+ "                <td>이름</td>"
				+ "                <td><input type=\"text\" name=\"uname\" value=\"" + user.getUname() + "\"></td>"
				+ "            </tr>"
				+ "            <tr>"
				+ "                <td>이메일</td>"
				+ "                <td><input type=\"text\" name=\"email\" value=\"" + user.getEmail() + "\"></td>"
				+ "            </tr>"
				+ "            <tr>"
				+ "                <td colspan=\"2\"><input type=\"submit\" value=\"수정\"></td>"
				+ "            </tr>"
				+ "        </table>"
				+ "    </form>"
				+ "</body>"
				+ "</html>";
		
		out.print(html);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
