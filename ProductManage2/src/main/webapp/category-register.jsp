<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>カテゴリ登録</title>
</head>
<body>
  <h1>カテゴリ登録フォーム</h1>

  <% String error = (String) request.getAttribute("error"); %>
  <% if (error != null) { %>
    <p style="color:red;"><%= error %></p>
  <% } %>

  <form action="CategoryRegisterServlet" method="post">
    <label>カテゴリID: <input type="text" name="id"></label><br>
    <label>カテゴリ名: <input type="text" name="name"></label><br><br>
    <input type="submit" value="登録">
  </form>

  <p><a href="CategoryListServlet">一覧へ戻る</a></p>
</body>
</html>
