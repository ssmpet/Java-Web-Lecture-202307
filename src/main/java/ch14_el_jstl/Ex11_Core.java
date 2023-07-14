package ch14_el_jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex03_Pojo
 */
@WebServlet("/ch14/jstl1")
public class Ex11_Core extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address addr1 = new Address(12345, "수원", "한국");
		Address addr2 = new Address(67890, "용인", "한국");
		Member m1 = new Member(101, "제임스", addr1);
		Member m2 = new Member(102, "마리아", addr2);
		
		request.setAttribute("m1", m1);
		request.setAttribute("m2", m2);
		
		Member[] members = {m1, m2};
		request.setAttribute("members", members);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch14/ex11_core.jsp");
		rd.forward(request, response);
	}

}
