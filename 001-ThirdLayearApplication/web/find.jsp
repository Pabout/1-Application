<%--
  Created by IntelliJ IDEA.
  User: zhang'shi'jie
  Date: 2021/12/18
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="zsj" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #a1{
        border: 1px blueviolet solid;
        height: 50px;
        background-color: gray;

    }
    #a2{
        border: 1px white solid;
        height: 50px;
        width: 100px;
        color: white;
        text-align: center;
        padding-top: 10px;
        position: relative;
        display: inline-block;
        margin-left: 1416px;
    }
    #a3{
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 69px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        padding: 12px 16px;
    }
    #a2:hover #a3 {
        display: block;
    }
</style>
<body>
<div id="a1">
    <div id="a2">
<%String username= request.getSession().getAttribute("username").toString();%><%=username%>
    <div id="a3">
        <p><a href="fix.jsp">添加学生</a></p>
        <p><a href="jspLogout">退出登录</a></p>
    </div></div>
</div>
<table align="center" border="1px">
    <caption><h1 style="color: pink">学生信息</h1></caption>
    <tr>
        <input type="checkbox" value="${st.wNum}">
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>信息</td>
        <td>操作</td>
    </tr>

<%--    <zsj:if test="${empty pageInfo.list}">--%>
<%--        <tr>--%>
<%--            <td colspan="6" align="center">暂无数据</td>--%>
<%--        </tr>--%>
<%--    </zsj:if>--%>

<%--    <zsj:if test="${not empty pageInfo.list}">--%>
        <zsj:forEach var="student" items="${pageInfo.list}" >
            <tr align="center">
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.gender}</td>
                <td>${student.info}</td>
                <td>
                    <a href="jspSelect?id=${student.id}">修改</a>
                    <a id="id${student.id}" onmouseover="over(${student.id})" onmouseout="out(${student.id})" onclick="del(${student.id})">删除</a>
                </td>
            </tr>
        </zsj:forEach>
<%--    </zsj:if>--%>

</table>
<form action="page" method="get">
    <table align="right">
        <tr>
            <%--如果当前页为第一页，则首页和上一页设置无法选中--%>
            <zsj:if test="${pageInfo.pageNo == 1}">
                <td><a href="javascript:return false;" style="text-decoration: none; color: orangered">首页</a></td>
                <td><a href="javascript:return false;" style="text-decoration: none; color: orangered">上一页</a></td>
            </zsj:if>

            <%--如果当前不为第一页--%>
            <zsj:if test="${pageInfo.pageNo != 1}">
                <%--设置首页直接跳转为第一页，传递pageNo为1--%>
                <td><a href="page?pageNo=1" style="text-decoration: none">首页</a></td>
                <%--设置上一页，传递pageNo为 当前页 - 1--%>
                <td><a href="page?pageNo=${pageInfo.pageNo - 1}" style="text-decoration: none">上一页</a></td>
            </zsj:if>

            <%--遍历当前页数--%>
            <zsj:forEach var="pageNo" varStatus="pageStatus" begin="1" end="${pageInfo.pageCount}">
                <%--如果是当前页，就设置不可点击--%>
                <zsj:if test="${pageNo == pageInfo.pageNo}">
                    <td><input type="submit" name="pageNo" value="${pageNo}" disabled></td>
                </zsj:if>

                <%--非当前页设置可点击--%>
                <zsj:if test="${pageNo != pageInfo.pageNo}">
                    <td><input type="submit" name="pageNo" value="${pageNo}"></td>
                </zsj:if>
            </zsj:forEach>
            <%--如果当前页为最后一页，则尾页和下一页设置无法选中--%>
            <zsj:if test="${pageInfo.pageNo == pageInfo.pageCount}">
                <td><a href="javascript:return false;" style="text-decoration: none; color: orangered">下一页</a></td>
                <td><a href="javascript:return false;" style="text-decoration: none; color: orangered">尾页</a></td>
            </zsj:if>

            <%--如果当前不为最后一页--%>
            <zsj:if test="${pageInfo.pageNo != pageInfo.pageCount}">
                <%--设置下一页，传递pageNo为 当前页 + 1--%>
                <td><a href="page?pageNo=${pageInfo.pageNo + 1}" style="text-decoration: none">下一页</a></td>
                <%--设置尾页直接跳转为最后一页，传递pageNo为总页数--%>
                <td><a href="page?pageNo=${pageInfo.pageCount}" style="text-decoration: none">尾页</a></td>
            </zsj:if>

            <%--从分页信息中获取数据总数和总页数--%>
            <td>共${pageInfo.totalCount}条内容，共${pageInfo.pageCount}页</td>
        </tr>
    </table>
</form>
</body>
<script>
    function del(id) {
        if (confirm('是否确认删除？') === true) {
            window.location.href = 'jspDelete?id=' + id;
        }
    }

    function over(id) {
        var a = document.getElementById('id' + id);

        a.style.color = 'red';
        a.style.cursor = 'pointer';
    }

    function out(id) {
        var a = document.getElementById('id' + id);

        a.style.color = 'black';
    }
</script>
</html>
