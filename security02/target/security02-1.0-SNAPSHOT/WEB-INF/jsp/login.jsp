<%--
  Created by IntelliJ IDEA.
  User: majianxiang
  Date: 2019/9/15
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>登录页面</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>

</head>
<body>

<%-- 判断 参数 是否为空 如果 不为空 就显示错误 --%>
<c:if test="${not empty param.error}">
<font style="color: red">用户名或密码错误</font>
</c:if>


<h3>登录页面</h3>

<form id="formId" action="${pageContext.request.contextPath}/login"  method="post">
    用户名：<input type="text" name="username" />
    <br>
    密码：<input type="password" name="password"  />
    <br>
    验证码：<input type="text" name="imgCode" value="" /><img src="${pageContext.request.contextPath}/yzm" />
    <br>
     记住我：<input type="checkbox" name="remember-me" value="true">
    <br>
    <input type="button" id = "loginBtn" value="submit" />
    <%--<input type="submit" value="subit" />--%>


</form>

<script type="text/javascript">

    $(function () {
        $("#loginBtn").click(function(){
            $.post("${pageContext.request.contextPath}/login",$("#formId").serialize(),function (data) {
                console.log(data);
                if (data.success == "true") {
                    window.location.href="${pageContext.request.contextPath}/all/hello";
                } else {
                    window.location.href="${pageContext.request.contextPath}/userlogin?error=true"
                }

            },"json");
        });

    });

</script>



</body>
</html>
