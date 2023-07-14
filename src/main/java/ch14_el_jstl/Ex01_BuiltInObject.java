package ch14_el_jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex01_BuiltInObject
 */
@WebServlet("/ch14/el1")
public class Ex01_BuiltInObject extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext ctx = request.getServletContext();
		HttpSession sess = request.getSession();
		
		ctx.setAttribute("name", "어플리케이션 스코프");
		sess.setAttribute("name", "세션 스코프");
		request.setAttribute("name", "리퀘스트 스코프");
//		request.setAttribute("name", "리퀘스트 스코프 name");
//		ctx.setAttribute("aName", "어플리케이션 스코프");
//		sess.setAttribute("sName", "세션 스코프");
//		request.setAttribute("rName", "리퀘스트 스코프");

		RequestDispatcher rd = request.getRequestDispatcher("/ch14/ex02_object.jsp?id=admin");
		rd.forward(request, response);

	}

}
