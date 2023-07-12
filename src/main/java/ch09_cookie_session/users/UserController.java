package ch09_cookie_session.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class UserController
 * WebServlet 안의 주소값 외에는 받지 않는다.
 */
@WebServlet({ "/ch09/users/list", "/ch09/users/register", "/ch09/users/update", "/ch09/users/delete", "/ch09/users/login", "/ch09/users/logout" })
public class UserController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		UserDao uDao = new UserDao();
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uid = null, pwd = null, pwd2 = null, uname = null, email = null;
		RequestDispatcher rd = null;
		User user = null;
		
		switch (action) {
		case "list":
			
			List<User> list = uDao.getUserList();
			System.out.println(list.size());
			request.setAttribute("userList", list);
			rd = request.getRequestDispatcher("/ch09/users/listView");
			rd.forward(request, response);
			break;

		case "register":
			uid = request.getParameter("uid");
			pwd = request.getParameter("pwd");
			pwd2= request.getParameter("pwd2");
			uname = request.getParameter("uname");
			email = request.getParameter("email");
			if (pwd.equals(pwd2)) {
				String hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
				user = new User(uid, hashedPwd, uname, email);
				uDao.insertUser(user);
				response.sendRedirect("/jw/ch09/users/list");
			} else {
				request.setAttribute("msg", "패스워드 입력이 잘못되었습니다.");
				request.setAttribute("url", "/jw/ch09/users/register.html");
				rd = request.getRequestDispatcher("/ch09/users/alertMsg.jsp");
				rd.forward(request, response);
//				out.print("<script>");
//				out.print("alert('패스워드 입력이 잘못되었습니다.');");
//				out.print("location.href='/jw/ch09/users/register.html'");
//				out.print("");
//				out.print("</script>");
			}
			break;
			
		case "login":
			uid = request.getParameter("uid");
			pwd = request.getParameter("pwd");
			UserService us = new UserService();
			int result = us.login(uid, pwd);
			if (result == UserService.CORRECT_LOGIN) {
				session.setAttribute("uid", uid);
				uname = uDao.getUser(uid).getUname();
				session.setAttribute("uname", uname);
				
				// 환영 메세지
				request.setAttribute("msg", uname + "님 환영합니다.");
				request.setAttribute("url", "/jw/ch09/users/list");
				rd = request.getRequestDispatcher("/ch09/users/alertMsg.jsp");
				rd.forward(request, response);				
				response.sendRedirect("/jw/ch09/users/list");
			} else if (result == UserService.WRONG_PASSWORD) {
				request.setAttribute("msg", "잘못되 패스워드 입니다. 다시 입력하세요.");
				request.setAttribute("url", "/jw/ch09/users/login.html");
				rd = request.getRequestDispatcher("/ch09/users/alertMsg.jsp");
				rd.forward(request, response);				
				
			} else {		// UID_NOT_EXIST
				request.setAttribute("msg", "ID가 없습니다. 회원 가입 페이지로 이동합니다.");
				request.setAttribute("url", "/jw/ch09/users/register.html");
				rd = request.getRequestDispatcher("/ch09/users/alertMsg.jsp");
				rd.forward(request, response);				
			}
			break;

		case "logout":
			session.invalidate();	// 세션을 삭제 --> 로그아웃
			response.sendRedirect("/jw/ch09/users/list");
			break;
			
		case "update":
			if (request.getMethod().equals("GET")) {	// 업데이트 양식 배포
				uid = request.getParameter("uid");
				user = uDao.getUser(uid);
				request.setAttribute("user", user);
				rd = request.getRequestDispatcher("/ch09/users/updateViewer");
				rd.forward(request, response);
			} else {									// 업데이트 처리
				
				uid = request.getParameter("uid");
				uname = request.getParameter("uname");
				email = request.getParameter("email");
				user = new User(uid, uname, email);
				uDao.updateUserWithoutPassword(user);
				response.sendRedirect("/jw/ch09/users/list");
			}	
			break;
			
		case "delete":
			uid = request.getParameter("uid");
			uDao.deleteUser(uid);
			response.sendRedirect("/jw/ch09/users/list");
			break;
			
		}
	}

}
