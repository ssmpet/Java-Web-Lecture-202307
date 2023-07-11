package ch07_dao.ex01_city;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CityDelete
 */
//@WebServlet("/ch07/city/delete")
public class CityDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		CityDao cDao = new CityDao();
		cDao.deleteCity(id);

		response.sendRedirect("/jw/ch07/city/list");
		
	}

}
