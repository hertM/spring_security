<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/7 0007
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"  %>

<html>
<head>
    <title>Title</title>
</head>
<body>

用户：${userName}
<br>

<security:authorize access="hasAuthority('ROLE_ADD')">
    <a href="${pageContext.request.contextPath}/all/add">增加</a>
</security:authorize>
<br>
<security:authorize access="hasAuthority('ROLE_LIST')">
    <a href="${pageContext.request.contextPath}/all/list">查询</a>
</security:authorize>
<br>
<security:authorize access="hasAuthority('ROLE_UPDATE')">
<a href="${pageContext.request.contextPath}/all/update">修改</a>
</security:authorize>
<br>
<security:authorize access="hasAuthority('ROLE_DELETE')">
<a href="${pageContext.request.contextPath}/all/delete">删除</a>
</security:authorize>
<br>
</body>
</html>
