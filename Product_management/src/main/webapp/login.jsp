<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>ログイン</title>
</head>
<body>
	<h1>ログイン</h1>
	<form action="LoginServlet" method="post">
		ユーザーID：<input type="text" name="id"><br> パスワード：<input
			type="password" name="password"><br> <input
			type="submit" value="ログイン">
	</form>
	<p style="color: red">${error}</p>
</body>
</html>
