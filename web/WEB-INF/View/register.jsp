<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/3
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--使用标签，需要引入Struts2核心jar包，在jsp头部--%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
    <title>注册</title>
</head>
<body>

<h1>简单的注册系统</h1>
<form action="regInsert.action" method="post">
    name: <input type="text" name="name"/> <br/>
    pad: <input type="text" name="pwd"/> <br/>
    <input type="submit" value="立即注册"/> <br/>
</form>
</body>
</html>
