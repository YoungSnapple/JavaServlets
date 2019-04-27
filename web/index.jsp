<%--
  Created by IntelliJ IDEA.
  User: feltzshae
  Date: 2019-04-11
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--Lance Graham
IT 214 Section 01
Group Project-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Math Portal</title>
</head>
<body>
<h1>Cool Math Implementations</h1>
<img src="https://s3.amazonaws.com/www.mathnasium.com/upload/831/images/Math.jpg" style="width: 400px;"/>  <!-- image -->
<h1><a href="${pageContext.request.contextPath}/RecursiveAdd.jsp">Recursive Add Function</a></h1><!-- These are the hyperlinks, and they are on the index page. The user will click a hyperlink to call a specific servlet. -->
<h1><a href="${pageContext.request.contextPath}/RecursiveMult.jsp">Recursive Multiplication Function</a></h1>
<h1><a href="${pageContext.request.contextPath}/BinarySearch.jsp">Binary Search and Sorting Functions</a></h1>
<h1><a href="${pageContext.request.contextPath}/Calculator.jsp">Calculator</a></h1>
<h1><a href="${pageContext.request.contextPath}/Queue.jsp">Queue Implementation and Reused Functions</a></h1>
</body>
</html>