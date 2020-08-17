<%@ page import="hust.hieutm.model.Skill" %><%--
  Created by IntelliJ IDEA.
  User: Minh Hieu Dr
  Date: 8/17/2020
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Skill skill = (Skill) request.getAttribute("skill");
%>
<%= skill.getName()%>
</body>
</html>
