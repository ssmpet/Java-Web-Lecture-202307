package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex03_ServletMapping
 */
@WebServlet("/mapping")
public class Ex03_ServletMapping extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String data = "<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<meta charset=\"UTF-8\">"
					+ "<title>Insert title here</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>localhost:8080/jw/mapping</h1>"
					+ "<hr>"
					+ "<h3>WebServlet Annotation의 값을 mapping으로 변경하고,</h3>	"
					+ "<h3>Servers에 있는 server.xml에서 </h3>	"
					+ "<h3>Context tag의 path값을 /jw로 변경하면 됩니다.</h3>"
					+ "</body>"
					+ "</html>";
		
		out.print(data);
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
