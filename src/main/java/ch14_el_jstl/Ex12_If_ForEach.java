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
@WebServlet("/ch14/jstl2")
public class Ex12_If_ForEach extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address addr1 = new Address(12345, "수원", "한국");
		Address addr2 = new Address(67890, "용인", "한국");

		Member m1 = new Member(101, "김자바", addr1);
		Member m2 = new Member(102, "박디비", addr2);
		Member m3 = new Member(103, "제임스", new Address(9876, "뉴욕", "미국"));
		Member m4 = new Member(104, "마리아", new Address(3421, "시카고", "미국"));
		
		Member[] members = {m1, m2, m3, m4};
		request.setAttribute("members", members);

		RequestDispatcher rd = request.getRequestDispatcher("/ch14/ex12_if_forEach.jsp");
		rd.forward(request, response);
	}

}
