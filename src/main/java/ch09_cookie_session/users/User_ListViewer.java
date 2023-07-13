package ch09_cookie_session.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/ch09/users/listView")
public class User_ListViewer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String sessionUid = (String) session.getAttribute("uid"); 
		
		List<User> list = (List<User>)request.getAttribute("userList");
		String html = "<!DOCTYPE html>"
				+ "<html lang=\"en\">"
				+ "<head>"
				+ "    <meta charset=\"UTF-8\">"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "    <title>사용자 목록</title>"
				+ "    <style>"
				+ "        td { text-align: center; padding: 3px;}"
				+ "    </style>"
				+ "</head>"
				+ "<body style=\"margin: 40px;\">"
				+ "    <h1>사용자 목록</h1>";
		// 로그인되었으면 -> 로그아웃 버튼, 환영 메세지 
		// 로그인이 안 되었으면 -> 로그인 버튼
		if (sessionUid != null) {		// 로그인 상태
			html += "<button onclick=\"location.href='/jw/ch09/users/logout'\">로그아웃</button> &nbsp;&nbsp;&nbsp;";
			html += session.getAttribute("uname") + "님 환영합니다. ";
		} else {						// 비로그인 상태
			html += "<button onclick=\"location.href='/jw/ch09/users/login.html'\">로그인</button>";
		}
		html += " <hr>"
				+ "    <table border=\"1\">"
				+ "        <tr><th>UID</th><th>PWD</th><th>Name</th><th>Email</th><th>등록일</th><th>액션</th></tr>";
		for (User u: list) {
			html += "<tr>"
					+ "            <td>" + u.getUid() +"</td>"
					+ "            <td>" + u.getPassword() + "</td>"		// 생략 무방
					+ "            <td>" + u.getUname() + "</td>"
					+ "            <td>" + u.getEmail() + "</td>"
					+ "            <td>" + u.getRegDate() + "</td>"
					+ "            <td>";
			// 본인만이 수정 권한이 있음
			if (sessionUid == null || !sessionUid.equals(u.getUid())) {
				html += "	<button disabled>수정</button> ";
			}else { 
				html += "	<button onclick=\"location.href='/jw/ch09/users/update?uid=" + u.getUid() + "'\">수정</button>";
			}
			// 관리자(admin)만이 삭제 권한이 있음
			if (sessionUid == null || !sessionUid.equals("admin")) {
				
				html += "	<button disabled>삭제</button> ";
			} else {
				html += " <button onclick=\"location.href='/jw/ch09/users/delete?uid=" + u.getUid() + "'\">삭제</button>";
			}
			html += "            </td>"
					+ "        </tr>";
		}
		html += "</table>    "
				+ "    <br>"
				+ "    <a href=\"/jw/ch09/users/register.html\">회원 가입</a>"
				+ "</body>"
				+ "</html>";
		
		out.print(html);

	}

}
