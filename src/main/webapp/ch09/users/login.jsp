<%@page import="ch09_cookie_session.users.UserDao"%>
<%@page import="ch09_cookie_session.users.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (request.getMethod().equals("POST") ) {
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		UserService us = new UserService();
		UserDao uDao = new UserDao();

		int result = us.login(uid, pwd);

		RequestDispatcher rd = null;
		
		if (result == UserService.CORRECT_LOGIN) {

			String uname = uDao.getUser(uid).getUname();
			request.getSession().setAttribute("uid", uid);
			request.getSession().setAttribute("uname", uid);
			
			request.setAttribute("msg", uname + "님 환영합니다.");
			request.setAttribute("url", "/jw/ch09/users/list.jsp");
			rd = request.getRequestDispatcher("/ch09/users/alertMsg.jsp");
			rd.forward(request, response);				
			response.sendRedirect("/jw/ch09/users/list.jsp");
			
		} else if (result == UserService.WRONG_PASSWORD) {
			request.setAttribute("msg", "잘못되 패스워드 입니다. 다시 입력하세요.");
			request.setAttribute("url", "/jw/ch09/users/login.jsp");
			rd = request.getRequestDispatcher("/ch09/users/alertMsg.jsp");
			rd.forward(request, response);				
			
		}else {
			request.setAttribute("msg", "ID가 없습니다. 회원 가입 페이지로 이동합니다.");
			request.setAttribute("url", "/jw/ch09/users/register.jsp");
			rd = request.getRequestDispatcher("/ch09/users/alertMsg.jsp");
			rd.forward(request, response);		
		}
		
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<style>
        td { text-align: center; padding: 3px;}
    </style>
</head>
<body>
	<h1>로그인</h1>
    <hr>
    <form action="/jw/ch09/users/login.jsp" method="post">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="uid"></td>
            </tr>
            <tr>
                <td>패스워드</td>
                <td><input type="password" name="pwd"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="로그인"></td>
            </tr>
        </table>
    </form>
</body>
</html>