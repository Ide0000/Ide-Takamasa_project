<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="model.entity.CategoryBean"%>
<%@ page import="java.util.List"%>
<html>
<head>
<title>カテゴリリスト</title>
</head>
<body>
  <h1>カテゴリリスト</h1>
  <table border="1">
    <tr>
      <th>カテゴリID</th>
      <th>カテゴリ名</th>
    </tr>
    <%
    List<CategoryBean> categoryList = (List) request.getAttribute("categoryList");
    if (categoryList != null) {
      for (CategoryBean category : categoryList) {
    %>
    <tr>
      <td><%=category.getId()%></td>
      <td><%=category.getName()%></td>
    </tr>
    <%
    }
    }
    %>
  </table>
</body>
</html>
