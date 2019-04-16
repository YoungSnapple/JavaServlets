<%--
  Created by IntelliJ IDEA.
  User: feltzshae
  Date: 2019-04-11
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Members Portal</title>
</head>
<body>
<form method="post" action="LoginServlet">
    Email ID:<input type="text" name="email" /><br/>
    Password:<input type="text" name="pass" /><br/>
    <input type="submit" value="login" />
</form>
</body>
</html>