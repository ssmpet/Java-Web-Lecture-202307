package ch08_extension;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex03_SourceDispatch
 */
@WebServlet("/ch08/src3")
public class Ex03_SourceDispatch extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/jw/ch08/src3 do Get()");
		
		String msg = "Dispatch, 한글 메세지";
		System.out.println(msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch08/dst3?msg=" + msg);
		rd.forward(request, response);		
	}

}
