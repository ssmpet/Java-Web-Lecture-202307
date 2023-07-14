<%@page import="ch09_cookie_session.users.UserDao"%>
<%@page import="ch09_cookie_session.users.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");
	UserDao uDao = new UserDao();

	String uid = request.getParameter("uid");
	
	if (request.getMethod().equals("POST") ) {
	
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");

		User user = new User(uid, uname, email);
		uDao.updateUserWithoutPassword(user);
		response.sendRedirect("/jw/ch09/users/list.jsp");
		return;
	}
	
	User user = uDao.getUser(uid);
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정</title>
	<style>
        td { text-align: center; padding: 3px;}
    </style>
</head>
<body style="margin: 40px;">
	<h1>회원 수정</h1>
    <hr>
    <form action="/jw/ch09/users/update.jsp" method="post">
        <input type="hidden" name="uid" value="<%= uid %>">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="uid" value="<%= uid %>" disabled></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="uname" value="<%= user.getUname() %>"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" value="<%= user.getEmail() %>"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="수정"></td>
            </tr>
        </table>
    </form>

</body>
</html>