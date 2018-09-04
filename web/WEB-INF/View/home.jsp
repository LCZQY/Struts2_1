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
    <title>主页展示</title>
</head>
<body>

<h1>Sturts2 + Hiberante知识整合练习</h1>

<div align="center">
    <a href="login.action">登陆</a>
    <a href="register.action">注册</a>
    <form action="${pageContext.request.contextPath}/findRenterByname" method="post">
        <input type="text" name="renterName"/><input type="submit" value="查询"/>
    </form>
</div>

<div id="uid"></div>
<div align="center">
    <table width="100%" height="210" border="1" cellpadding="0">

        <tr align="center">
            <td>Id</td>
            <td>用户名</td>
            <td>密码</td>
            <td>操作</td>
        </tr>

        <s:iterator  value="emplist" status="li">
            <tr align="center">
                <td><s:property value="uid"/></td>
                <td><s:property value="username"/></td>
                <td><s:property value="password"/></td>
                <td>
                        <%--user_id 不需要作为方法的参数，直接作为Action的属性便可以获取到对应的值， --%>
                    <a href="delete.action?user_id=${ uid }">删除</a>
                    <a href="${pageContext.request.contextPath}/addRenter.jsp-${renter.renterId}">修改</a>
                </td>
            </tr>

        </s:iterator>
    </table>


</div>


</body>
</html>
