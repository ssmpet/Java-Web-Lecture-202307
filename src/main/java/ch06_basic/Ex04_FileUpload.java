package ch06_basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Ex04_FileUpload
 */
@WebServlet("/ch06/upload")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1, 		// 1 MB
		maxFileSize = 1024 * 1024 * 10,				// 10 MB
		maxRequestSize = 1024 * 1024 * 10
)
public class Ex04_FileUpload extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		Part filePart = request.getPart("upload_file");
		
		String filename = filePart.getSubmittedFileName();
		System.out.println(filename);

		filePart.write("d:/Temp/" + filename);

		response.getWriter().print("The file is uploaded successfully.");
	}

}
