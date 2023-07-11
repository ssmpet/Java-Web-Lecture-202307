package ch07_dao.ex01_city;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CityUpdate
 */
//@WebServlet("/ch07/city/update")
public class CityUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		CityDao cDao = new CityDao();
		City city = cDao.getCity(id);
		
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>City Update</title>"
				+ "<style> td { text-align: center; padding : 2px;} </style>"
				+ "</head>"
				+ "<body style=\"margin: 40px;\">"
				+ "	<h1>City Update</h1>"
				+ "	<hr>"
				+ "	<form action=\"/jw/ch07/city/update\" method=\"post\">"
				+ "		<input type=\"hidden\" name=\"id\" value=\"" + city.getId() + "\">";
		   html += "		<table>"
				+ "			<tr>"
				+ "				<td>Name</td><td><input type=\"text\" name=\"name\" value=\""+city.getName() +"\"></td>";
		   html += "			</tr>"
				+ "			<tr>"
				+ "				<td>CountryCode</td><td><input type=\"text\" name=\"countrycode\" value=\""+ city.getCountryCode()+"\"></td>";
		   html += "			</tr>"
				+ "			<tr>"
				+ "				<td>District</td><td><input type=\"text\" name=\"district\" value=\""+ city.getDistrict() + "\"></td>";
		   html += "			</tr>"
				+ "			<tr>"
				+ "				<td>Population</td><td><input type=\"text\" name=\"population\" value=\"" + city.getPopulation() + "\"></td>";
		   html += "			</tr>"
				+ "			<tr><td colspan=\"2\"><input type=\"submit\" value=\"수정\"></td></tr>"
				+ "		</table>"
				+ "		"
				+ "	</form>"
				+ "</body>"
				+ "</html>";
			
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String countryCode = request.getParameter("countrycode");
		String district = request.getParameter("district");
		int population = Integer.parseInt(request.getParameter("population"));

		City city = new City(id, name, countryCode, district, population);
		CityDao cDao = new CityDao();
		cDao.updateCity(city);
		
		response.sendRedirect("/jw/ch07/city/list");
	}

}
