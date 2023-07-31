<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>간단한 계산기</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
	<script>
	
	</script>
</head>
<body style="margin: 40px;">

	<h2>간단한 계산기</h2>
	<hr>
	<form action="/jw/ch15/cal" method="post">
		<table>
			<tr>
				<td><input type="text" name="num1" class="form-control" value="${num1}" autofocus></td>
				<td> 
					<select class="form-select" name="operator">
						<option value="+" ${(operator eq '+') ? "selected":""}> + </option>
						<option value="-" ${(operator eq '-') ? "selected":""}> - </option>
						<option value="*" ${(operator eq '*') ? "selected":""}> * </option>
						<option value="/" ${(operator eq '/') ? "selected":""}> / </option>
					</select>
				</td>
				<td><input type="text" name="num2" class="form-control" value="${num2}" ></td>
				<td><button class="btn btn-primary" type="submit"> = </button></td>
				<td><input type="text" name="result" id="result" class="form-control" value="${result}"></td>
			</tr>
		</table>
	</form>
	
</body>
	
</html>