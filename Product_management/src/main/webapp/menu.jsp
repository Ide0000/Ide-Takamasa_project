<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="model.entity.UserBean"%>

<%
UserBean user = (UserBean) session.getAttribute("user");
if (user == null) {
	request.setAttribute("error", "セッションが切れています。再度ログインしてください！");
	request.getRequestDispatcher("login.jsp").forward(request, response);
	return;
}
%>

<html>
<head>
<title>メニュー</title>
</head>
<body>
	<h1>ログイン中のユーザー：${user.name} さん（ID: ${user.id}）</h1>
	<h2>メニュー</h2>
	<h4>・商品一覧</h4>
	<form action="LogoutServlet" method="get">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>
