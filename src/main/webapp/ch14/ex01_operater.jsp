<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL 표현언어</title>
	<style>
		td { padding: 3px; }
	</style>
</head>
<body style="margin: 40px; margin-bottom:40px;">
	<h1>EL 연산자</h1>
	<hr>
	<table border="1">
		<tr><th>계산식</th><th>결과</tr>
		<tr><td>\${100} : </td><td>${100}</td></tr>	
		<tr><td>\${"안녕하세요"} : </td><td>${"안녕하세요"}</td></tr>	
		<tr><td>\${"10" + 1} : </td><td>${"10" + 1}</td></tr>	<%-- "10"이 숫자 10으로 변환: 11 --%>>
		<tr><td>\${10+1} : </td><td>${10+1}</td></tr>	
		<tr><td>\${ null + 10 } : </td><td>${ null + 10 }</td></tr>	
		<tr><td>\${ "안녕" + 11 }</td><td>${ "안녕" + 11 }</td></tr>	
		<tr><td>\${ "hello" + "world" } : </td><td>${ "hello" + "world" }</td></tr>	
		<tr><td colspan="2"></td></tr>	
		<tr><td>\${ 20 - 10 } : </td><td>${ 20-10 }</td></tr>	
		<tr><td>\${ 20 * 10 }</td><td>${ 20 * 10 }</td></tr>	
		<tr><td>\${ 100 / 9 }</td><td>${ 100 / 9 }</td></tr>	
		<tr><td>\${ 100 div 11 }</td><td>${ 100 div 11 }</td></tr>	
		<tr><td>\${ 100 % 9 }</td><td>${ 100 % 9 }</td></tr>	
		<tr><td>\${ 100 mod 9 }</td><td>${ 100 mod 9 }</td></tr>	
		<tr><td colspan="2"></td></tr>
		<tr><td>\${ 10 == 10 }</td><td>${ 10 == 10 }</td></tr>	
		<tr><td>\${ 10 eq 10 }</td><td>${ 10 eq 10 }</td></tr>	
		<tr><td>\${ "hello" == "hello" }</td><td>${ "hello" == "hello" }</td></tr>	
		<tr><td>\${ "hello" eq "hello" }</td><td>${ "hello" eq "hello" }</td></tr>	
		<tr><td>\${ 10 > 8 }</td><td>${ 10 > 8 }</td></tr>	
		<tr><td>\${ 10 gt 8 }</td><td>${ 10 gt 8 }</td></tr>	
		<tr><td colspan="2"></td></tr>	
		<tr><td>\${ 10 >= 8 && 8 <= 10 }</td><td>${ 10 >= 8 && 8 <= 10 }</td></tr>	
		<tr><td>\${ 10 ge 8 and 8 le 10 }</td><td>${ 10 ge 8 and 8 le 10 }</td></tr>	
		<tr><td>\${ 10 == 8 or 8 == 10 }</td><td>${ 10 == 8 or 8 == 10 }</td></tr>	
		<tr><td>\${ not(10 == 10) }</td><td>${ not(10 == 10) }</td></tr>	
		<tr><td>\${ empty "hello" }</td><td>${ empty "hello" }</td></tr>	
		<tr><td>\${ empty "" }</td><td>${ empty "" }</td></tr>	
		<tr><td>\${ empty null }</td><td>${ empty null }</td></tr>	
	</table>
	<h3>파라메터 값은 ${empty param.num ? "입력하지 않음" : param.num } 입니다.</h3>
</body>
</html>