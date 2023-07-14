<%@page import="ch09_cookie_session.users.UserDao"%>
<%@page import="ch09_cookie_session.users.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserDao uDao = new UserDao();
	List<User> list = uDao.getUserList();	

	String sessionUid = (String) request.getSession().getAttribute("uid");
	String sessionUname = (String) request.getSession().getAttribute("uname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>
</head>
<body style="margin: 40px;">
	<h1>사용자 목록</h1>
	<% if ( sessionUid == null) { %>
    <button onclick="location.href='/jw/ch09/users/login.jsp'">로그인</button>
    <% } else { %>
    <button onclick="location.href='/jw/ch09/users/logout.jsp'">로그아웃</button>
    	<%= sessionUname %>환영합니다.
    <% } %>

    <hr>
    <table border="1">
        <tr><th>UID</th><th>PWD</th><th>Name</th><th>Email</th><th>등록일</th><th>액션</th></tr>
        <% for ( User user: list) { %>
	        <tr>
	            <td><%= user.getUid() %></td>
	            <td><%= user.getUname() %></td>
	            <td><%= user.getPassword() %></td>
	            <td><%= user.getEmail() %></td>
	            <td><%= user.getRegDate().toString() %></td>
	            <td>
	                <button onclick="location.href='/jw/ch09/users/update.jsp?uid=<%= user.getUid() %>'">수정</button> 
	                <button onclick="location.href='/jw/ch09/users/delete.jsp?uid=<%= user.getUid() %>'">삭제</button>
	            </td>
	        </tr>
        <% } %>
    </table>
    <br>
    <a href="/jw/ch09/users/register.jsp">회원 가입</a>
</body>
</html>