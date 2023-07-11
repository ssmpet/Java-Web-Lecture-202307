package ch07_dao.ex01_city;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CityController
 */
@WebServlet({ "/ch07/city/list", "/ch07/city/insert", "/ch07/city/update", "/ch07/city/delete" })
public class CityController extends HttpServlet {
	
	CityDao cDao = new CityDao();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestUri = request.getRequestURI();
		System.out.println(requestUri);
		String[] cmd_ = requestUri.split("/");
		String cmd = cmd_[cmd_.length - 1];	// list, update, delete, insert
		String html = "";

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		switch (cmd) {
		case "list":

			List<City> list = cDao.getCityList("KOR", 10, 0);
			String data = "";
			for (City c: list) {
				data += "<tr>";
				data += "<td>" + c.getId() + "</td>";
				data += "<td>" + c.getName() + "</td>";
				data += "<td>" + c.getCountryCode() + "</td>";
				data += "<td>" + c.getDistrict() + "</td>";
				data += "<td>" + c.getPopulation() + "</td>";
				data += "<td> <a href=\"/jw/ch07/city/update?id=" + c.getId() + "\">수정</a> ";
				data += "<a href=\"/jw/ch07/city/delete?id=" + c.getId() + "\">삭제</a></td>";
				data += "</tr>";
			}

			html = "<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<meta charset=\"UTF-8\">"
					+ "<title>City List</title>"
					+ "<style>"
					+ "	td, th { padding: 2px;}"
					+ "</style>"
					+ "</head>"
					+ "<body style=\"margin: 40px;\">"
					+ "	<h1>도시 리스트</h1><br>"
					+ "  "
					+ "	<hr>"
					+ "	<table border=\"1\">"
					+ "		<tr><th>ID</th><th>Name</th><th>CountryCode</th><th>District</th><th>Population</th><th>Action</th></tr>";
			html += data;	
			html += "	</table>"
					+ "		<br><button onclick=\"location.href='/jw/ch07/city/insert'\">추가</button>"
					+ "</body>"
					+ "</html>";
			
			
			out.print(html);
			break;
		case "insert":
			html = "<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<meta charset=\"UTF-8\">"
					+ "<title>City Insert</title>"
					+ "<style> td { text-align: center; padding : 2px;} </style>"
					+ "</head>"
					+ "<body style=\"margin: 40px;\">"
					+ "	<h1>City Insert</h1>"
					+ "	<hr>"
					+ "	<form action=\"/jw/ch07/city/insert\" method=\"post\">"
			        + "		<table>"
					+ "			<tr>"
					+ "				<td>Name</td><td><input type=\"text\" name=\"name\"></td>"
			        + "			</tr>"
					+ "			<tr>"
					+ "				<td>CountryCode</td><td><input type=\"text\" name=\"countrycode\"></td>"
			        + "			</tr>"
					+ "			<tr>"
					+ "				<td>District</td><td><input type=\"text\" name=\"district\"></td>"
			    	+ "			</tr>"
					+ "			<tr>"
					+ "				<td>Population</td><td><input type=\"text\" name=\"population\" ></td>"
					+ "			</tr>"
					+ "			<tr><td colspan=\"2\"><input type=\"submit\" value=\"Insert\"></td></tr>"
					+ "		</table>"
					+ "	</form>"
					+ "</body>"
					+ "</html>";
				
			out.print(html);
			break;
		case "update":
			
			City city = cDao.getCity(Integer.parseInt(request.getParameter("id")));
			
			html = "<!DOCTYPE html>"
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
				
			out.print(html);
			break;
		case "delete":
			cDao.deleteCity(Integer.parseInt(request.getParameter("id")));

			response.sendRedirect("/jw/ch07/city/list");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestUri = request.getRequestURI();
		String[] cmd_ = requestUri.split("/");
		String cmd = cmd_[cmd_.length - 1];	// list, update, delete, insert
		String html = "";
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		String name;
		String countryCode;
		String district;
		int population = 0;
		City city = null;
		
		switch (cmd) {
		case "insert":
			name = request.getParameter("name");
			countryCode = request.getParameter("countrycode");
			district = request.getParameter("district");
			population = Integer.parseInt(request.getParameter("population"));

			city = new City(name, countryCode, district, population);
			cDao.insertCity(city);

			response.sendRedirect("/jw/ch07/city/list");
			break;
		case "update":
			int id = Integer.parseInt(request.getParameter("id"));
			name = request.getParameter("name");
			countryCode = request.getParameter("countrycode");
			district = request.getParameter("district");
			population = Integer.parseInt(request.getParameter("population"));

			city = new City(id, name, countryCode, district, population);
			cDao.updateCity(city);

			response.sendRedirect("/jw/ch07/city/list");
			break;
		}
	}

}
