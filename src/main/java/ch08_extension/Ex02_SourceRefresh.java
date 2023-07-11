package ch08_extension;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex02_SourceRefresh
 */
@WebServlet("/ch08/src2")
public class Ex02_SourceRefresh extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/jw/ch08/src2 do Get()");
		
		String msg = "Refresh, 한글 메세지";
		msg = URLEncoder.encode(msg, "utf-8");		// 주소창을 이용해 보내는 경우 반드시 인코딩을 해주어야 함
		System.out.println(msg);
		
		response.addHeader("Refresh", "5; url=/jw/ch08/dst2?msg=" + msg);
	}
}
