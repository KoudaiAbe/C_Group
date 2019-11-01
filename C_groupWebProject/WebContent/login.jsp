<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="login.css" rel="stylesheet" type="text/css">
</head>

<body>
	<jsp:include page="/HEADER.html"/>

	<form action="../src/servlet/Login.java">
		<div id="errorText" style="color: red;"></div>
		ユーザ名　：<input type="text" name="name"><br>
		パスワード：<input type="password" name="pass"><br>
		<input type="submit" name="login" value="ログイン">
		<input type="submit" name="regist" value="アカウント作成">
	</form>

	<script type="text/javascript">
		function errorOut(msg)
		{
			let text = document.getElementById("errorText");
			const p = document.createElement("p");
			p.textContent = msg;
			text.appendChild(p);
		}
	</script>
</body>

</html>
