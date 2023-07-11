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
 * Servlet implementation class CityList
 */
//@WebServlet("/ch07/city/list")
public class CityList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CityDao cDao = new CityDao();
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
			

		String html = "<!DOCTYPE html>"
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
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
